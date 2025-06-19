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

    public Paciente() {
    }

    public Paciente(Long id, String nombres, String apellidos, List<RegistroMedico> registrosMedicos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.registrosMedicos = registrosMedicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<RegistroMedico> getRegistrosMedicos() {
        return registrosMedicos;
    }

    public void setRegistrosMedicos(List<RegistroMedico> registrosMedicos) {
        this.registrosMedicos = registrosMedicos;
    }
}
