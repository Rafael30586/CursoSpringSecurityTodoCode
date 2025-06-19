package com.todocodeacademy.healthcare_solutions.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    @OneToMany
    private List<RegistroMedico> registrosMedicos;
}
