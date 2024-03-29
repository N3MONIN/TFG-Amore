package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String Nombre);

}
