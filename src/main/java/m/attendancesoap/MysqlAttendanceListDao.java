package m.attendancesoap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlAttendanceListDao implements AttendanceListDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlAttendanceListDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public Long addAttendanceList(int subjectId, Date date, List<Student> students) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("idSubject", subjectId)
                .addValue("date", date);
        

        Number id = new SimpleJdbcInsert(ObjectFactory.INSTANCE.getJdbcTemplate())
                .withTableName("AttendanceList")
                .usingGeneratedKeyColumns("id")
                .usingColumns("idSubject", "date")
                .executeAndReturnKey(parameters);

        for (Student student : students) {
        jdbcTemplate.update("INSERT INTO Kopr.StudentAttendance VALUES (?,?)", student.getId(), id);
        }

        return id.longValue();
    }

    @Override
    public List<Student> getStudentsOnList(AttendanceList attendanceList) {
        String sql = "SELECT S.* FROM Student S JOIN StudentAttendance SA "
                + "JOIN AttendanceList A ON A.id = SA.idAttendanceList "
                + "AND S.id = SA.idStudent WHERE A.id = ?";
        return jdbcTemplate.query(sql,new Object[]{attendanceList.getId()}, new StudentRowMapper());

    }

    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
             Student s = new Student();
            s.setId(rs.getLong("id"));
            s.setName(rs.getString("name"));
            s.setSurname(rs.getString("surname"));
        
            return s;
        }
    }

}