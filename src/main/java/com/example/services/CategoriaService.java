package com.example.services;

import java.util.List;

import com.example.domain.Categoria;


public interface CategoriaService {
    Categoria add(Categoria categoria); 
    List<Categoria> findAll(); 
    Categoria findById(long id); 
    Categoria edit(Categoria e); 
    void delete(Categoria d); 
    Categoria findByNombre(String nombre);
}
