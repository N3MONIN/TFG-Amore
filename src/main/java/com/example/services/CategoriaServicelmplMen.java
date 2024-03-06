package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Categoria;
import com.example.repository.CategoriaRepository;


@Service
public class CategoriaServicelmplMen implements CategoriaService {
    @Autowired
    CategoriaRepository repositorio;

    public Categoria add(Categoria e) {
        return repositorio.save(e);
    }

    public List<Categoria> findAll() {
        return repositorio.findAll();
    }

    public Categoria findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Categoria edit(Categoria d) {
        return repositorio.save(d);
    }

    public void delete(Categoria d) {
        repositorio.delete(d);
    }

    public Categoria findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
}
