package com.example.services;

import java.util.List;

import com.example.domain.Usuario;


public interface UsuarioService {
    Usuario add(Usuario Usuario);
    List<Usuario> findAll();
    Usuario findById(long id);
    Usuario edit(Usuario Usuario);
    void delete(Usuario Usuario);
    Usuario findByNombre(String nombre);
}
