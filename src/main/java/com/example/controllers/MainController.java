package com.example.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class MainController {

        @GetMapping({ "/index", "/home", "/", "" })
        public String showHome(@RequestParam(name = "usuario") Optional<String> usuario,
                        Model model) {
                return "index";
        }

        @GetMapping("/tareas")
        public String showTareas() {
                return "/tareas/tareas";
        }

}
