package m.attendancesoap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
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
    public UUID addStudent(String name, String surname) {
         UUID uuid = UUID.randomUUID();
         String id = uuid.toString();
         String sql = "INSERT INTO KOPR.Student VALUES(?,?,?);";
         jdbcTemplate.update(sql,id,name,surname);

        return uuid;
    }

    @Override
    public List<AttendanceList> getLists(UUID studentId) {
       String sql = "SELECT A.* FROM AttendanceList A \n"
               + "JOIN StudentAttendance SA JOIN Student S \n"
               + "ON A.id = SA.idAttendanceList and S.id = SA.idStudent \n"
               + "WHERE S.id = ?";

        return jdbcTemplate.query(sql, new Object[]{studentId.toString()},new AttendanceRowMapper());
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
