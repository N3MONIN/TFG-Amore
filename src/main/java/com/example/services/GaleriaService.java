package com.example.services;

import java.util.List;


import com.example.domain.Galeria;

public interface GaleriaService {
    public Galeria add(Galeria g);
    public List <Galeria> findAll();
    public Galeria edit (Galeria g);
    public void delete(Long id);
    public Galeria findById(long id);



}
