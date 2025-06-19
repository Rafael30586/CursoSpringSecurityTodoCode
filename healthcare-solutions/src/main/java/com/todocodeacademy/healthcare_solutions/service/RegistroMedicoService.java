package com.todocodeacademy.healthcare_solutions.service;

import com.todocodeacademy.healthcare_solutions.model.RegistroMedico;
import com.todocodeacademy.healthcare_solutions.repository.IRegistroMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroMedicoService implements IRegistroMedicoService{

    @Autowired
    private IRegistroMedicoRepository repository;

    @Override
    public Optional<RegistroMedico> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<RegistroMedico> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RegistroMedico save(RegistroMedico registroMedico) {
        return repository.save(registroMedico);
    }

    @Override
    public RegistroMedico update(RegistroMedico registroMedico) {
        return repository.save(registroMedico);
    }
}
