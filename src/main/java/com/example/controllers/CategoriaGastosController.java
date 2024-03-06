package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.CategoriaGastos;
import com.example.services.CategoriaGastosServiceImplMen;
import com.example.services.GastosServiceImplMem;

@Controller
@RequestMapping("/categoriaGastos")
public class CategoriaGastosController {
    

    @Autowired
    CategoriaGastosServiceImplMen categoriaGastosService;
    @Autowired
    GastosServiceImplMem gastosService;

    @GetMapping({ "/", "/list",""})
    public String showList(Model model) {
        model.addAttribute("listaCategoriasGastos", categoriaGastosService.findAll());
        return "catGastos/categoriaGastosList";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("categoriaGastosForm", new CategoriaGastos());
        return "catGastos/categoriaGastosNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("categoriaGastosForm") CategoriaGastos nuevoCategoriaGastos,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newForm";
            categoriaGastosService.add(nuevoCategoriaGastos);
        return "redirect:/categoriaGastos/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        CategoriaGastos categoriaGastos = categoriaGastosService.findById(id);

        if (categoriaGastos != null) {
            model.addAttribute("categoriaGastosForm", categoriaGastos);
            return "catGastos/categoriaGastosEditView";
        }
        return "redirect:/categoriaGastos";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("categoriaGastosForm") CategoriaGastos categoriaGastos,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "catGastos/categoriaGastosEditView";
        } else {
            categoriaGastosService.edit(categoriaGastos);
            return "redirect:/categoriaGastos/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        categoriaGastosService.delete(categoriaGastosService.findById(id));
        return "redirect:/categoria/list";
    }
}
