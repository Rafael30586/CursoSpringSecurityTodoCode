package com.todocodeacademy.LogisCode.service;

import com.todocodeacademy.LogisCode.model.Viaje;
import com.todocodeacademy.LogisCode.repository.IViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeService implements IViajeService{

    @Autowired
    private IViajeRepository repository;

    @Override
    public List<Viaje> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Viaje> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Viaje save(Viaje viaje) {
        return repository.save(viaje);
    }

    @Override
    public Viaje update(Viaje viaje) {
        return repository.save(viaje);
    }
}
