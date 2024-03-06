package com.example.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Galeria;
import com.example.services.GaleriaService;

@Controller
@RequestMapping("/galeria")
public class GaleriaController {
    @Autowired
    GaleriaService galeriaService;

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
        model.addAttribute("galeriaImagenes", galeriaService.findAll());
        return "galeria/galeria";
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable long id) {
        Galeria imagen = galeriaService.findById(id);

        if (imagen != null) {
            ByteArrayResource resource = new ByteArrayResource(imagen.getImagenData());

            return ResponseEntity.ok()
                    .contentLength(imagen.getImagenData().length)
                    .contentType(MediaType.IMAGE_JPEG) 
                    .body(resource);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("galeriaForm", new Galeria());
        return "galeria/galeria";
    }

    @PostMapping("/new")
    public String processNew(@Valid @ModelAttribute("galeriaForm") Galeria nuevaImagen,
            BindingResult bindingResult,
            @RequestParam("file") MultipartFile[] files) {
        if (bindingResult.hasErrors()) {
            return "galeria/galeria";
        }

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    byte[] imagenData = file.getBytes();
                    nuevaImagen.setImagenData(imagenData);
                    galeriaService.add(nuevaImagen);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "galeria/galeria";
                }
            }
        }

        return "redirect:/galeria/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteImage(@PathVariable long id) {
        galeriaService.delete(id);
        return "redirect:/galeria";
    }

    @PostMapping("/delete/{id}")
    public String processDelete(@PathVariable long id) {
        galeriaService.delete(id);
        return "redirect:/galeria";
    }
}



