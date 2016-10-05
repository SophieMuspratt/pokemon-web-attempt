package pokemon.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pokemon.classes.Trainer;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class DataRepository {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void addNewTrainerToDB(String name, int age, char gender){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{name, age, gender};
        jdbcTemplate.update("INSERT INTO trainer (name, age, gender) VALUES (?, ?, ?)", args);
    }


}
