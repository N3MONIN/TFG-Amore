package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Categoria;
import com.example.domain.Invitado;
import com.example.repository.InvitadoRepository;


@Service
public class InvitadoServiceImplMem implements InvitadoService {

    @Autowired
    InvitadoRepository repositorio;

    public List<Invitado> findByCategoria(Categoria categoria) {
        return repositorio.findByCategoria(categoria);
    }

    public Invitado add(Invitado i) {
        repositorio.save(i); 
        return i;
    }

    public List<Invitado> findAll() {
        return repositorio.findAll(); 
    }


    public Invitado findById(long id) {
        return repositorio.findById(id).orElse(null); 
        
    }

    public Invitado edit(Invitado i) {
        return repositorio.save(i);
    }

    public void delete(Long id) {
         repositorio.deleteById(id);
    }

    public Invitado findByNombre(String nombre){
        return repositorio.findByNombre(nombre);
    }


}