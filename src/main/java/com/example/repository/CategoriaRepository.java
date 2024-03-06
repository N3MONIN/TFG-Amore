package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    Categoria findByNombre(String nombre);
}
