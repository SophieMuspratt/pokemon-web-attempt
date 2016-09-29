package pokemon.classes;

import java.util.List;

public class Pokemon {
    private String pokemonName;
    private String pokemonDesc;
    private String pokemonGeneration;
    private String pokemonEvolution;
    private List<Type> elementTypes;

    public Pokemon(String pokemonName, String pokemonDesc, String pokemonGeneration, String pokeEvolution, List<Type> elementTypes){
        this.pokemonName = pokemonName;
        this.pokemonDesc = pokemonDesc;
        this.pokemonGeneration = pokemonGeneration;
        this.pokemonEvolution = pokeEvolution;
        this.elementTypes = elementTypes;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonDesc() {
        return pokemonDesc;
    }

    public String getPokemonGeneration() {
        return pokemonGeneration;
    }

    public String getPokemonEvolution() {
        return pokemonEvolution;
    }

    public List<Type> getElementTypes() {
        return elementTypes;
    }
}
