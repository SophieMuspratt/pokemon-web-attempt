package pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pokemon.classes.Pokemon;
import pokemon.classes.Trainer;
import pokemon.classes.Type;
import pokemon.repositories.DataRepository;
import pokemon.repositories.PokemonRepository;
import pokemon.repositories.TrainerRepository;
import pokemon.repositories.TypeRepository;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private TypeRepository typeRepository;

    @RequestMapping("/")
    public String handleIndex(Model m){
        Trainer trainer = trainerRepository.getNewTrainer();
        List<Pokemon> pokemon = pokemonRepository.getNewPokemon();
       // List<Type> element_type = typeRepository.getNewType();

        m.addAttribute("name", "Pokemon");
        m.addAttribute("trainerName", trainer.getTrainerName());
        m.addAttribute("pokemon", pokemon);
       // m.addAttribute("element_type", element_type);
//        m.addAttribute("pokemonDesc", pokemon.getPokemonDesc());
//        m.addAttribute("pokemonGeneration", pokemon.getPokemonGeneration());
//        m.addAttribute("pokemonEvolution", pokemon.getPokemonEvolution());
        return "index";
    }
}
