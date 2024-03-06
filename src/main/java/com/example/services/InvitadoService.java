package com.example.services;

import java.util.List;

import com.example.domain.Categoria;
import com.example.domain.Invitado;


public interface InvitadoService {
    public Invitado add(Invitado i);
    public List<Invitado> findAll();
    public Invitado findById(long id);
    public Invitado edit(Invitado i);
    public void delete(Long id);
    public List<Invitado> findByCategoria(Categoria categoria);
    public Invitado findByNombre(String nombre);
}
