package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String fechaRegistro;
    private String password;
    private String fotoUrl;
    private Rol rol;

    public Usuario(String nombre, String fechaRegistro, String password, String fotoUrl, Rol rol) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.password = password;
        this.fotoUrl = fotoUrl;
        this.rol = rol;
    }

}
