package com.todocodeacademy.logiscode2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destino;
    @ManyToOne
    private Chofer chofer;
    @ManyToOne
    private Vehiculo vehiculo;
}
