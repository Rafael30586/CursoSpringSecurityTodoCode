package com.todocodeacademy.healthcare_solutions.service;

import com.todocodeacademy.healthcare_solutions.model.Paciente;
import com.todocodeacademy.healthcare_solutions.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository repository;


    @Override
    public Optional<Paciente> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Paciente> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Paciente save(Paciente paciente) {
        return repository.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        return repository.save(paciente);
    }
}
