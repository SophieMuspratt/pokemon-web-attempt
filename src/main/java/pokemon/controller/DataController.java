package pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pokemon.repositories.DataRepository;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @RequestMapping("/addData")
    public String handleData(Model m) {
        return "addData";
    }

    @RequestMapping("/addTrainerData")
    public String handleTrainerAdding(Model m, HttpServletRequest request){
        String name = request.getParameter("trainerName");
        String age = request.getParameter("trainerAge");
        String gender = request.getParameter("trainerGender");
        return "addData";
    }

}
