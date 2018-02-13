package m.attendancesoap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlStudentDao implements StudentDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public MysqlStudentDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }
  
    @Override
    public Long addStudent(String name, String surname) {
        
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("name", name)
                .addValue("surname", surname);

        Number id = new SimpleJdbcInsert(ObjectFactory.INSTANCE.getJdbcTemplate())
                .withTableName("Student")
                .usingGeneratedKeyColumns("id")
                .usingColumns("name","surname")
                .executeAndReturnKey(parameters);

        return id.longValue();
    }

    @Override
    public List<AttendanceList> getLists(Student student) {
       String sql = "SELECT A.* FROM AttendanceList A \n"
               + "JOIN StudentAttendance SA JOIN Student S \n"
               + "ON A.id = SA.idAttendanceList and S.id = SA.idStudent \n"
               + "WHERE S.id = ?";

        return jdbcTemplate.query(sql, new Object[]{student.getId()},new AttendanceRowMapper());
    }

    private static class AttendanceRowMapper implements RowMapper<AttendanceList>{

        @Override
        public AttendanceList mapRow(ResultSet rs, int i) throws SQLException {
            AttendanceList al = new AttendanceList();
            al.setId(rs.getLong("id"));
            //System.out.println(al.getId());
            al.setIdSubject(rs.getLong("idSubject"));
            //System.out.println(al.getIdSubject());
            
            al.setDateTime(rs.getDate("date"));
        
            return al;
        }
        

    }
}
