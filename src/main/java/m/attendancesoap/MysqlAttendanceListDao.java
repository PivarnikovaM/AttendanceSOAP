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
    
    public List<AttendanceList> getAttendanceLists(){
        String sql = "SELECT * FROM AttendanceList";
        return jdbcTemplate.query(sql, new MysqlAttendanceListDao.AttendanceRowMapper());
    }
    
    public void removeAttendanceList(UUID attendanceListId){
        jdbcTemplate.update("DELETE FROM StudentAttendance WHERE idAttendanceList = ?",attendanceListId.toString());
        jdbcTemplate.update("DELETE FROM AttendanceList WHERE id = ?", attendanceListId.toString());
    }

    @Override
    public List<Student> getStudentsOnList(UUID attendanceListId) throws InvalidInputException {
        int attendanceListCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM AttendanceList WHERE id = ?", new Object[]{attendanceListId.toString()},Integer.class);
        
        System.out.println("POCET: " + attendanceListCount);
        if (attendanceListCount == 0) {
            throw new InvalidInputException("AttendanceList with id " + attendanceListId.toString() + " does not exist");
        }
        
        String sql = "SELECT S.* FROM Student S JOIN StudentAttendance SA "
                + "JOIN AttendanceList A ON A.id = SA.idAttendanceList "
                + "AND S.id = SA.idStudent WHERE A.id = ?";
        return jdbcTemplate.query(sql, new Object[]{attendanceListId.toString()}, new StudentRowMapper());

    }
    
    public static void main(String[] args) {
        MysqlAttendanceListDao mald = new MysqlAttendanceListDao();
        List<Student> studentsOnList = mald.getStudentsOnList(UUID.fromString("909020f8-ba22-479a-86e7-b1d2afcecace"));
        System.out.println(studentsOnList);
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
    
    private static class AttendanceRowMapper implements RowMapper<AttendanceList>{

        @Override
        public AttendanceList mapRow(ResultSet rs, int i) throws SQLException {
            AttendanceList al = new AttendanceList();
            String sid = rs.getString("id");
            al.setId(UUID.fromString(sid));
            //System.out.println(al.getId());
            String sidsub = rs.getString("idSubject");
            al.setIdSubject(UUID.fromString(sidsub));
            //System.out.println(al.getIdSubject());
            
            al.setDateTime(rs.getDate("date"));
        
            return al;
        }
        

    }

}
