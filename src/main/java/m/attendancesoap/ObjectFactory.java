package m.attendancesoap;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum ObjectFactory {
    
    INSTANCE;
    private JdbcTemplate jdbcTemplate;

//    private ReceptDao receptDao;
//
//    private IngredienciaDao ingredienciaDao;
//
//    private NakupnyZoznamDao nakupnyZoznamDao;
//    
//    private JedalnicekDao jedalnicekDao;

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
    
}
