package com.example.services;

import java.util.List;

import com.example.domain.CategoriaGastos;

public interface CategoriaGastosService {
    CategoriaGastos add(CategoriaGastos CategoriaGastos); 
    List<CategoriaGastos> findAll(); 
    CategoriaGastos findById(long id); 
    CategoriaGastos edit(CategoriaGastos e); 
    void delete(CategoriaGastos d); 
    CategoriaGastos findByNombre(String nombre);

}
