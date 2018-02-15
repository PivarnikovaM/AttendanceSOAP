package m.attendancesoap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    public UUID addAttendanceList(UUID subjectId, Date date, List<Student> students) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

//        MapSqlParameterSource parameters = new MapSqlParameterSource()
//                .addValue("idSubject", subjectId)
//                .addValue("date", date);
//        
//
//        Number id = new SimpleJdbcInsert(ObjectFactory.INSTANCE.getJdbcTemplate())
//                .withTableName("AttendanceList")
//                .usingGeneratedKeyColumns("id")
//                .usingColumns("idSubject", "date")
//                .executeAndReturnKey(parameters);
        String sql = "INSERT INTO KOPR.AttendanceList VALUES(?,?,?);";
        jdbcTemplate.update(sql, id, subjectId.toString(), date);

        for (Student student : students) {
            jdbcTemplate.update("INSERT INTO Kopr.StudentAttendance VALUES (?,?)", student.getId().toString(), id);
    }

        return uuid;
    }

    @Override
    public List<Student> getStudentsOnList(UUID attendanceListId) {
        String sql = "SELECT S.* FROM Student S JOIN StudentAttendance SA "
                + "JOIN AttendanceList A ON A.id = SA.idAttendanceList "
                + "AND S.id = SA.idStudent WHERE A.id = ?";
        return jdbcTemplate.query(sql, new Object[]{attendanceListId.toString()}, new StudentRowMapper());

    }

    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            Student s = new Student();
             String sid = rs.getString("id");
            s.setId(UUID.fromString(sid));
            s.setName(rs.getString("name"));
            s.setSurname(rs.getString("surname"));

            return s;
        }
    }

}
