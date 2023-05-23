package de.pkrause.springit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.pkrause.springit.model.Link;
import de.pkrause.springit.repository.LinkRepository;

@RestController
@RequestMapping("/links")
public class LinkController {

    private LinkRepository repository;

    public LinkController(LinkRepository repository) {
        this.repository = repository;
    }

    // list
    @GetMapping("/")
    public List<Link> list() {
        return repository.findAll();
    }

    // CRUD
    @PostMapping("/create")
    public Link create(@ModelAttribute Link link) {
        return repository.save(link);
    }

    // /links/1
    @GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public Link update(@PathVariable Long id, @ModelAttribute Link link) {
        return repository.save(link);
    }

    // / delete/1
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
