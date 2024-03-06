package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Galeria;
import com.example.repository.GaleriaRepository;

@Service
public class GaleriaServiceImplMem implements GaleriaService {
    @Autowired
    GaleriaRepository repositorio;


    public Galeria add(Galeria g) {
        repositorio.save(g); 
        return g;
    }
    public List <Galeria> findAll(){
        return repositorio.findAll();
    }

    public Galeria edit(Galeria g) {
        return repositorio.save(g);
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
   }

   public Galeria findById(long id) {
    return repositorio.findById(id).orElse(null); 
    
}

}
