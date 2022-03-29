package com.Camp.SpringTest.Controller;

import com.Camp.SpringTest.Model.Agify;
import com.Camp.SpringTest.Model.Guess;
import com.Camp.SpringTest.Model.Person;
import com.Camp.SpringTest.dao.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MessageController implements WebMvcConfigurer {

    @Autowired
    PersonService service;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/noName").setViewName("noName");
    }

    @GetMapping("/")
    public String indexNameInput(Model model) {
        model.addAttribute("yourGuess", new Guess());

        return "nameForm";
    }

    @PostMapping("/guess")
    public String getMessage(@ModelAttribute Guess guess, Model model) {

        if (guess.getGuess().equals("")) {
            return "/";
        }
        Agify agify = restTemplate.getForObject(
                "https://api.agify.io/?name=" +  guess.getGuess(), Agify.class
        );
        Person person = service.addPerson(agify);
        model.addAttribute("agify", person);
        return "guessForm";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("persons", service.getAll());
        return "list";
    }

}


