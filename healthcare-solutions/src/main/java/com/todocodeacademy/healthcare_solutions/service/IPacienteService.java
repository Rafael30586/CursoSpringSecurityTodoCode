package com.todocodeacademy.healthcare_solutions.service;

import com.todocodeacademy.healthcare_solutions.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    public Optional<Paciente> findById(Long id);
    public List<Paciente> findAll();
    public void deleteById(Long id);
    public Paciente save(Paciente paciente);
    public Paciente update(Paciente paciente);
}
