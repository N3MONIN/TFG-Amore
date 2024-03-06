package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Categoria;
import com.example.domain.Invitado;


public interface InvitadoRepository extends JpaRepository<Invitado, Long> {
    List<Invitado> findByCategoria(Categoria categoria);
    Invitado findByNombre(String Nombre);
}
