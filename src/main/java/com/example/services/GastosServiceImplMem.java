package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.CategoriaGastos;
import com.example.domain.Gastos;
import com.example.repository.GastosRepository;

@Service
public class GastosServiceImplMem implements GastosService{

    @Autowired
    GastosRepository repositorio;

    public List<Gastos> findByCategoriaGastos(Object object) {
        return repositorio.findByCategoriaGastos(object);
    }

    public Gastos add(Gastos g) {
        repositorio.save(g); 
        return g;
    }

    public List<Gastos> findAll() {
        return repositorio.findAll(); 
    }


    public Gastos findById(long id) {
        return repositorio.findById(id).orElse(null); 
        
    }

    public Gastos edit(Gastos g) {
        return repositorio.save(g);
    }

    public void delete(Long id) {
         repositorio.deleteById(id);
    }

    public Gastos findByConcepto(String concepto){
        return repositorio.findByConcepto(concepto);
    }

    @Override
    public List<Gastos> findByCategoriaGastos(CategoriaGastos categoriaGastos) {
        throw new UnsupportedOperationException("Unimplemented method 'findByCategoriaGastos'");
    }

    
}
