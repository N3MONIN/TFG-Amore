package com.example.domain;

// import java.util.ArrayList;
// import java.util.List;

// import javax.persistence.CascadeType;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Gastos {
    @Id
    @GeneratedValue
    long id;

    @ToString.Exclude
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CategoriaGastos categoriaGastos;

    

    String concepto;
    String fecha;
    Double importe;

    public Gastos(String concepto, String fecha, Double importe, CategoriaGastos categoriaGastos) {
        this.concepto = concepto;
        this.fecha = fecha;
        this.importe = importe;
        this.categoriaGastos = categoriaGastos;

    }

}
