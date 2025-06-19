package com.todocodeacademy.healthcare_solutions.service;

import com.todocodeacademy.healthcare_solutions.model.RegistroMedico;

import java.util.List;
import java.util.Optional;

public interface IRegistroMedicoService {

    public Optional<RegistroMedico> findById(Long id);
    public List<RegistroMedico> findAll();
    public void deleteById(Long id);
    public RegistroMedico save(RegistroMedico registroMedico);
    public RegistroMedico update(RegistroMedico registroMedico);
}
