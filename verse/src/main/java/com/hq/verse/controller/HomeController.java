package com.hq.verse.controller;

import com.hq.verse.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CategoriaRepository repository;

    public HomeController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categorias", repository.findAll());
        return "index";
    }
}
