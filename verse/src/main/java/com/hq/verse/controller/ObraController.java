package com.hq.verse.controller;

import com.hq.verse.model.Categoria;
import com.hq.verse.model.Obra;
import com.hq.verse.repository.CategoriaRepository;
import com.hq.verse.repository.ObraRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/obras")
public class ObraController {
    private final CategoriaRepository categoriaRepository;
    private final ObraRepository obraRepository;

    public ObraController(CategoriaRepository categoriaRepository, ObraRepository obraRepository) {
        this.categoriaRepository = categoriaRepository;
        this.obraRepository = obraRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("obras", obraRepository.findAll());

        return "obras/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("obra", new Obra());

        model.addAttribute("categorias",
                categoriaRepository.findAll());

        return "obras/formulario";
    }

    @PostMapping
    public String salvar(Obra obra, Integer categoriaId){

        Categoria categoria = categoriaRepository
                .findById(categoriaId)
                .orElse(null);

        if (categoria == null) {
            return "redirect:/obras";
        }

        obra.setCategoria(categoria);

        obraRepository.save(obra);

        return "redirect:/obras";
    }

    @GetMapping("/{id}/editar")
    public String editar(Integer id, Model model) {

        Obra obra = obraRepository.findById(id).orElse(null);

        if (obra == null) {
            return "redirect:/obras";
        }

        model.addAttribute("obra", obra);
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "obras/formulario";
    }

    @PostMapping("/{id}/vender")
    public String vender(@PathVariable Integer id) {

        obraRepository.deleteById(id);

        return "redirect:/obras";
    }
}
