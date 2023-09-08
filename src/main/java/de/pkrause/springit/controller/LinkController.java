package de.pkrause.springit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import de.pkrause.springit.repository.LinkRepository;

@Controller
public class LinkController {

    @Autowired
    private LinkRepository repository;

    @GetMapping("/")
    public String list(Model model) {

        model.addAttribute( "links", repository.findAll() );
        return "link/list";

    }

}
