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
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Invitado;
import com.example.services.CategoriaServicelmplMen;
import com.example.services.InvitadoServiceImplMem;



@Controller
@RequestMapping("/invitados")
public class InvitadoController {

    @Autowired
    InvitadoServiceImplMem invitadoService;

    @Autowired
    CategoriaServicelmplMen categoriaService;

    @GetMapping({ "/", "/list",""})
    public String showList(Model model) {
        model.addAttribute("listaInvitados", invitadoService.findAll());
        model.addAttribute("listaCategorias", categoriaService.findAll());
        model.addAttribute("categoriaSeleccionada", "Todas");
        return "invitado/invitadosList";
    }

    @GetMapping("/list/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) {
        model.addAttribute("listaInvitados", invitadoService.findByCategoria(categoriaService.findById(idCat)));
        model.addAttribute("listaCategorias", categoriaService.findAll());
        model.addAttribute("categoriaSeleccionada", categoriaService.findById(idCat).getNombre());
        return "invitado/invitadosList";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("invitadoForm", new Invitado());
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "invitado/invitadosNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("invitadoForm") Invitado nuevoinvitado,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newForm";
        invitadoService.add(nuevoinvitado);
        return "redirect:/invitados/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Invitado invitado = invitadoService.findById(id);
        if (invitado != null) {
            model.addAttribute("invitadoForm", invitado);
            model.addAttribute("listaCategorias", categoriaService.findAll());
            return "invitado/invitadosEditView";
        }
        return "redirect:/invitados";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("invitadoForm") Invitado invitado,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "invitado/invitadosEditView";
        } else {
            invitadoService.edit(invitado);
            return "redirect:/invitados/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        invitadoService.delete(id);
        return "redirect:/invitados/list";
    }
}
