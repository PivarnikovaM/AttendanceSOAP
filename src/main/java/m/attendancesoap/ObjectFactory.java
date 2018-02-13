package m.attendancesoap;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum ObjectFactory {
    
    INSTANCE;
    private JdbcTemplate jdbcTemplate;

    private AttendanceListDao attendanceListDao;
    private StudentDao studentDao;
    private SubjectDao subjectDao;
            


    public JdbcTemplate getJdbcTemplate() {

        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/KOPR?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
            dataSource.setUser("kopr");
            dataSource.setPassword("koprsoap");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;

    }
    
     public AttendanceListDao attendanceListDao() {
        if (this.attendanceListDao == null) {
            this.attendanceListDao = new MysqlAttendanceListDao();
        }
        return attendanceListDao;
    }
     
     public StudentDao studentDao(){
         if (this.studentDao == null) { 
             this.studentDao = new MysqlStudentDao();
         }
         return studentDao;
     }
     
     public SubjectDao subjectDao(){
         if (this.subjectDao == null){
             this.subjectDao = new MysqlSubjectDao();
         }
         return subjectDao;
     }
             
    
}
