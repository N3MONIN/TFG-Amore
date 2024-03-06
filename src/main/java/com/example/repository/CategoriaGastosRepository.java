package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.CategoriaGastos;


public interface CategoriaGastosRepository extends JpaRepository<CategoriaGastos, Long> {
    CategoriaGastos findByNombre(String nombre);
    
}
