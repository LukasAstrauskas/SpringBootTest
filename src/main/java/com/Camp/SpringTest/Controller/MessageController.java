package com.Camp.SpringTest.Controller;

import com.Camp.SpringTest.Model.Agify;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class MessageController {

    private final RestTemplate restTemplate = new RestTemplate();



    @GetMapping("/message")
    public String getMessage(Model model) {

        Agify agify = restTemplate.getForObject("https://api.agify.io/?name=Anderson", Agify.class);
        String string = "No Value.";
        if (agify != null) {
            string = agify.toString();
        }
        model.addAttribute("person", agify);

        return "messagePage";
    }

}


