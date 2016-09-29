package pokemon.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import pokemon.classes.Pokemon;
import pokemon.classes.Type;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonRepository {

    private DataSource dataSource;
    private TypeRepository typeRepository;

    public PokemonRepository(DataSource dataSource, TypeRepository typeRepository) {
        this.dataSource = dataSource;
        this.typeRepository = typeRepository;
    }

    public List<Pokemon> getNewPokemon() {
        List<Integer> ids = getRandomPokemonIds();
        List<Pokemon> pokemons = new ArrayList<>();
        for (Integer id : ids) {
            Pokemon pokemon = getPokemon(id);
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    public Pokemon getPokemon(int id) {
        List<Type> types = typeRepository.getPokemonElementTypes(id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] arguments = new Object[] { id };
        return jdbcTemplate.queryForObject("SELECT * FROM pokemon WHERE pokemon_id = ?", arguments, new PokemonExtractor(types));
    }

    public List<Integer> getRandomPokemonIds() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForList("SELECT pokemon_id FROM pokemon ORDER BY RAND() LIMIT 6", Integer.class);
    }

    private static class PokemonExtractor implements RowMapper<Pokemon> {

        private List<Type> elementTypes;

        public PokemonExtractor(List<Type> elementTypes) {
            this.elementTypes = elementTypes;
        }

        @Override
        public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
            return asPokemon(rs);
        }

        private Pokemon asPokemon(ResultSet rs) throws SQLException {
            String pokemonName = rs.getString("pokemon_name");
            String pokemonDesc = rs.getString("pokemon_desc");
            String pokemonGeneration = rs.getString("pokemon_generation");
            String pokemonEvolution = rs.getString("pokemon_evolution_level");
            return new Pokemon(pokemonName, pokemonDesc, pokemonGeneration, pokemonEvolution, elementTypes);
        }

    }

}
