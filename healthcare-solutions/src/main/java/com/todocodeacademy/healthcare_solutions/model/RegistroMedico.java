package com.todocodeacademy.healthcare_solutions.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "registros")
public class RegistroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostico;
    @ElementCollection
    private List<String> tratamientos;
    @ElementCollection
    private List<String> medicamentosRecetados;
}
