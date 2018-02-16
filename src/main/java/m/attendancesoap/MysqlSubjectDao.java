package m.attendancesoap;


import java.util.UUID;
import org.springframework.jdbc.core.JdbcTemplate;

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

}
