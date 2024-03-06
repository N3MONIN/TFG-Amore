package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.CategoriaGastos;
import com.example.repository.CategoriaGastosRepository;

@Service
public class CategoriaGastosServiceImplMen  implements CategoriaGastosService{
    @Autowired
    CategoriaGastosRepository repositorio;

    public CategoriaGastos add(CategoriaGastos e) {
        return repositorio.save(e);
    }

    public List<CategoriaGastos> findAll() {
        return repositorio.findAll();
    }

    public CategoriaGastos findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public CategoriaGastos edit(CategoriaGastos d) {
        return repositorio.save(d);
    }

    public void delete(CategoriaGastos d) {
        repositorio.delete(d);
    }

    public CategoriaGastos findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

}
