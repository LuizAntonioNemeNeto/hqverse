package com.hq.verse.controller;

import com.hq.verse.model.Categoria;
import com.hq.verse.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", repository.findAll());

        return "categorias/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    @PostMapping
    public String salvar(Categoria categoria) {

        repository.save(categoria);

        return "redirect:/categorias";
    }

    @GetMapping("/{id}/editar")
    public String editar(Integer id, Model model) {

        Categoria categoria = repository.findById(id).orElse(null);

        if (categoria == null) {
            return "redirect:/categorias";
        }

        model.addAttribute("categoria", categoria);

        return "categorias/formulario";
    }
}
