package m.attendancesoap;

import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlSubjectDao implements SubjectDao {

  

    @Override
    public Long addSubject(String name) {
        
         MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", name);
                

        Number id = new SimpleJdbcInsert(ObjectFactory.INSTANCE.getJdbcTemplate())
                .withTableName("Subject")
                .usingGeneratedKeyColumns("id")
                .usingColumns("name")
                .executeAndReturnKey(parameters);
        
        return id.longValue();
    }

    public static void main(String[] args) {
       MysqlStudentDao msd = new MysqlStudentDao();
       //msd.addStudent("Jozko","Mrkvicka");
       //msd.addStudent("Tinka", "Pi");
       
       MysqlAttendanceListDao mald = new MysqlAttendanceListDao();
//       List<Student> students = new ArrayList<>();
       Student s1 = new Student();
//       Student s2 = new Student();
//       
       s1.setId(1L);
//       s2.setId(2L);
       s1.setName("Jozko");
       s1.setSurname("Mrkvicka");
//       students.add(s1);
//       students.add(s2);               
//       mald.addAttendanceList(1, null, students);
        List<AttendanceList> lists = msd.getLists(s1);
        System.out.println(lists);
        
        List<Student> studentsOnList = mald.getStudentsOnList(lists.get(0));
        System.out.println(studentsOnList);
                
                
    }
}
