package pokemon.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pokemon.classes.Type;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by smusp on 26/08/2016.
 */
public class TypeRepository {

    private DataSource dataSource;

    public TypeRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Type> getPokemonElementTypes(int pokemonId){
        List<PokemonType> pokemonTypes = getPokemonTypes(pokemonId);
        List<Type> pokemonElementTypes = new ArrayList<>();
        for (PokemonType pokemonType : pokemonTypes){
            Type elementType = getNewType(pokemonType.getElementTypeId());
            pokemonElementTypes.add(elementType);
        }
        return pokemonElementTypes;
    }

    public List<PokemonType> getPokemonTypes(int pokemonId){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] arguments = new Object[] {pokemonId};
        return jdbcTemplate.query("SELECT * FROM pokemon_type WHERE pokemon_id = ?", arguments, new PokemonTypeExtractor());
    }

    public Type getNewType(int elementTypeId){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] arguments = new Object[] { elementTypeId };
        return jdbcTemplate.queryForObject("SELECT * FROM element_type WHERE element_type_id = ?", arguments, new TypeRowMapExtracter());
    }

    private static Type asType(ResultSet rs) throws SQLException{
        String elementType = rs.getString("element_type");
        String elementTypeDesc = rs.getString("element_type_desc");
        return new Type(elementType, elementTypeDesc);
    }

    private static class TypeRowMapExtracter implements RowMapper<Type>{
        @Override
        public Type mapRow(ResultSet resultSet, int i) throws SQLException{
            return asType(resultSet);
        }
    }

    private static class PokemonTypeExtractor implements RowMapper<PokemonType>{
        @Override
        public PokemonType mapRow(ResultSet rs, int i) throws SQLException{
            int pokemonId = rs.getInt("pokemon_id");
            int pokemonTypeId = rs.getInt("pokemon_type_id");
            int elementTypeId = rs.getInt("element_type_id");
            return new PokemonType(pokemonId, pokemonTypeId, elementTypeId);
        }
    }

    private static class PokemonType {
        private int pokemonId;
        private int pokemonTypeId;
        private int elementTypeId;

        public PokemonType(int pokemonId, int pokemonTypeId, int elementTypeId){
            this.elementTypeId = elementTypeId;
            this.pokemonId = pokemonId;
            this.pokemonTypeId = pokemonTypeId;
        }

        public int getPokemonId() {
            return pokemonId;
        }

        public int getPokemonTypeId() {
            return pokemonTypeId;
        }

        public int getElementTypeId() {
            return elementTypeId;
        }
    }

}
