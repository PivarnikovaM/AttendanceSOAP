package m.attendancesoap;


import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;

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

}
