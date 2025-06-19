package com.todocodeacademy.logiscode2.service;

import com.todocodeacademy.logiscode2.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {

    public List<Vehiculo> findAll();
    public Optional<Vehiculo> findById(Long id);
    public void deleteById(Long id);
    public Vehiculo save(Vehiculo vehiculo);
    public Vehiculo update(Vehiculo vehiculo);
}
