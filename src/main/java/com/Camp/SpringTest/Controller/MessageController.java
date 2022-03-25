package com.Camp.SpringTest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MessageController {

    @GetMapping("/message")
    public String getMessage(@RequestParam(name = "msg", required = false,
           defaultValue = "Lukas") String message, Model model) {
        model.addAttribute("msg", message);
        return "messagePage";
    }

}


