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

    public RegistroMedico() {
    }

    public RegistroMedico(Long id, String diagnostico, List<String> tratamientos, List<String> medicamentosRecetados) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.tratamientos = tratamientos;
        this.medicamentosRecetados = medicamentosRecetados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<String> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public List<String> getMedicamentosRecetados() {
        return medicamentosRecetados;
    }

    public void setMedicamentosRecetados(List<String> medicamentosRecetados) {
        this.medicamentosRecetados = medicamentosRecetados;
    }
}
