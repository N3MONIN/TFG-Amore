package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Galeria {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] imagenData;

    public Galeria(byte[] imagenData) {
        this.imagenData = imagenData;
    }

    
}
