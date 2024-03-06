package com.example.services;

import java.util.List;

import com.example.domain.CategoriaGastos;
import com.example.domain.Gastos;

public interface GastosService {

    public Gastos add(Gastos g);
    public List <Gastos> findAll();
    public Gastos findById(long id);
    public Gastos edit (Gastos g);
    public  List<Gastos> findByCategoriaGastos(CategoriaGastos categoriaGastos);
    public Gastos findByConcepto(String concepto);
    
}
