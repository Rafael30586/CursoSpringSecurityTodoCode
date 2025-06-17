package com.todocodeacademy.LogisCode.service;

import com.todocodeacademy.LogisCode.model.Vehiculo;
import com.todocodeacademy.LogisCode.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    private IVehiculoRepository repository;

    @Override
    public List<Vehiculo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    @Override
    public Vehiculo update(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }
}
