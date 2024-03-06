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

import com.example.domain.Gastos;
import com.example.services.CategoriaGastosServiceImplMen;
import com.example.services.GastosServiceImplMem;

@Controller
@RequestMapping("/gastos")
public class GatosController {
    @Autowired
    GastosServiceImplMem gastosService;

    @Autowired
    CategoriaGastosServiceImplMen categoriaGastosService;

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
        model.addAttribute("listaGastos", gastosService.findAll());
        model.addAttribute("listaCategoriasGastos", categoriaGastosService.findAll());
        model.addAttribute("categoriaGastosSeleccionada", "Todas");
        return "gastos/gastosList";
    }

    @GetMapping("/list/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) {
        model.addAttribute("listaGastos", gastosService.findByCategoriaGastos(categoriaGastosService.findById(idCat)));
        model.addAttribute("listaCategoriasGastos", categoriaGastosService.findAll());
        model.addAttribute("categoriaGastosSeleccionada", categoriaGastosService.findById(idCat).getNombre());
        return "gastos/gastosList";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("gastosForm", new Gastos());
        model.addAttribute("listaCategoriasGastos", categoriaGastosService.findAll());
        return "gastos/gastosNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("gastosForm") Gastos nuevogastos,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newForm";
        gastosService.add(nuevogastos);
        return "redirect:/gastos/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Gastos gastos = gastosService.findById(id);
        if (gastos != null) {
            model.addAttribute("gastosForm", gastos);
            model.addAttribute("listaCategoriasGastos", categoriaGastosService.findAll());
            return "gastos/gastosEditView";
        }
        return "redirect:/gastos/";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("gastosForm") Gastos gastos,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "gastos/gastosEditView";
        } else {
            gastosService.edit(gastos);
            return "redirect:/gastos/";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        gastosService.delete(id);
        return "redirect:/gastos/list";
    }
}
