package de.pkrause.springit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// @ResponseBody
public class HomeController {

    // @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        // model.addAttribute(null, model)
        return "index.html";
    }

}
