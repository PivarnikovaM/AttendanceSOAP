package m.attendancesoap;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MysqlSubjectDao implements SubjectDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlSubjectDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public UUID addSubject(String name) throws InvalidInputException{
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
         int subjectCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Subject WHERE name = ?", Integer.class, name);
         if (subjectCount > 0) {
                throw new InvalidInputException("Subject with name " + name + " does already exist");
            }
        String sql = "INSERT INTO KOPR.Subject VALUES(?,?);";
        jdbcTemplate.update(sql, id, name);
        return uuid;
    }
    
    public List<Subject> getSubjects(){
        String sql = "SELECT * FROM Subject";
        return jdbcTemplate.query(sql, new MysqlSubjectDao.SubjectRowmapper());
    }
    
    public void removeSubject(UUID subjectId){
        String sql = "DELETE FROM Subject WHERE id = ?";
        jdbcTemplate.update(sql,subjectId.toString());
    }

    private static class SubjectRowmapper implements RowMapper<Subject> {


        @Override
        public Subject mapRow(ResultSet rs, int i) throws SQLException {
            Subject s = new Subject();
            String sid = rs.getString("id");
            s.setId(UUID.fromString(sid));
            s.setName(rs.getString("name"));
            return s;
        }
    }

}
