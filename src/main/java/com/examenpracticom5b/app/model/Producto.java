package com.examenpracticom5b.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Producto")
@Getter
@Setter
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Integer codigo;
    
    @NotNull
    @Column(length = 100,name="descripcion")
    private String descripcion;
    
    @NotNull
    @Min(value = 1)
    @Column(name = "precio")
    private Double precio;
    
    @NotNull
    @Min(value = 1)
    @Column(name = "cantidad")
    private Integer cantidad;

}
