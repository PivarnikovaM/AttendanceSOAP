package m.attendancesoap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class MysqlAttendanceListDao implements AttendanceListDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlAttendanceListDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public UUID addAttendanceList(UUID subjectId, Date date, List<Student> students) throws InvalidInputException {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        int subjectCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Subject WHERE id = ?",Integer.class,subjectId.toString());
        if (subjectCount == 0) {
            throw new InvalidInputException("Subject with id " + subjectId.toString() + " does not exist");
        }
        for (Student student : students) {
            int studentCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Student WHERE id = ?", Integer.class, student.getId().toString());
            if (studentCount == 0) {
                throw new InvalidInputException("Student with id " + student.getId().toString() + " does not exist");
            }
        }
        String sql = "INSERT INTO KOPR.AttendanceList VALUES(?,?,?);";
        jdbcTemplate.update(sql, id, subjectId.toString(), date);
        
        
        for (Student student : students) {
            jdbcTemplate.update("INSERT INTO Kopr.StudentAttendance VALUES (?,?)", student.getId().toString(), id);
    }

        return uuid;
    }

    @Override
    public List<Student> getStudentsOnList(UUID attendanceListId) throws InvalidInputException {
        int attendanceListCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM AttendanceList WHERE id = ? ", Integer.class,attendanceListId);
        if (attendanceListCount == 0) {
            throw new InvalidInputException("AttendanceList with id " + attendanceListId.toString() + " does not exist");
        }
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
