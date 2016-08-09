package pokemon.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataRepository {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<String> getTrainerDetails(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> trainerDetailList = jdbcTemplate.query("SELECT * FROM trainer", new RowMapper<String>(){
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException{
                return resultSet.getString("trainer_name");
            }
        });
        return trainerDetailList;
    }
}
