package m.attendancesoap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlSubjectDao implements SubjectDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlSubjectDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public UUID addSubject(String name) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        String sql = "INSERT INTO KOPR.Subject VALUES(?,?);";
        jdbcTemplate.update(sql, id, name);
        return uuid;
    }

    public static void main(String[] args) {
        MysqlStudentDao msd = new MysqlStudentDao();
        UUID jozkoid = msd.addStudent("Jozko", "Mrkvicka");
        UUID tinkaid = msd.addStudent("Tinka", "Pi");
        
        System.out.println(jozkoid.toString());
        System.out.println(jozkoid.toString().length());

        MysqlAttendanceListDao mald = new MysqlAttendanceListDao();
        List<Student> students = new ArrayList<>();
        Student s1 = new Student();
        Student s2 = new Student();
//       
       
//       s2.setId(2L);
        s1.setId(jozkoid);
        s1.setName("Jozko");
        s1.setSurname("Mrkvicka");
        
        s2.setId(tinkaid);
        s2.setName("Tinka");
        s2.setSurname("Pi");
        students.add(s1);
        students.add(s2); 
        
        MysqlSubjectDao mssd = new MysqlSubjectDao();
        UUID subjectId = mssd.addSubject("Programovanie");
        UUID attendanceListId = mald.addAttendanceList(subjectId, null, students);
        
        List<AttendanceList> lists = msd.getLists(jozkoid);
        System.out.println(lists);

        List<Student> studentsOnList = mald.getStudentsOnList(attendanceListId);
        System.out.println(studentsOnList);

    }
}
