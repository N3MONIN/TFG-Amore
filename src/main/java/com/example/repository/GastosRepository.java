package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Gastos;

public interface GastosRepository extends JpaRepository<Gastos, Long>{
    List<Gastos> findByCategoriaGastos(Object object);
    Gastos findByConcepto(String Concepto);
}
