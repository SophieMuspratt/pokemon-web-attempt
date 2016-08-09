package pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pokemon.classes.Trainer;
import pokemon.repositories.TrainerRepository;

@Controller
public class IndexController {
    @Autowired
    private TrainerRepository trainerRepository;

    @RequestMapping("/")
    public String handleIndex(Model m){
        Trainer trainer = trainerRepository.getNewTrainer();
        m.addAttribute("name", "Pokemon");
        m.addAttribute("trainerName", trainer.getTrainerName());
        return "index";
    }

}
