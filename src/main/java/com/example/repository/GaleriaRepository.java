package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Galeria;

public interface GaleriaRepository extends JpaRepository<Galeria, Long> {
    Galeria findByImagenData(byte[] imagenData);
}

