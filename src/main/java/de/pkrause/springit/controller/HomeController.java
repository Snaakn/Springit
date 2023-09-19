package de.pkrause.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// @ResponseBody
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Hello, Thymeleaf!");
        return "home";
    }

}
