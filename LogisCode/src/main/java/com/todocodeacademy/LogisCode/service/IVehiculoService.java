package com.todocodeacademy.LogisCode.service;

import com.todocodeacademy.LogisCode.model.Vehiculo;
import com.todocodeacademy.LogisCode.model.Viaje;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {

    public List<Vehiculo> findAll();
    public Optional<Vehiculo> findById(Long id);
    public void deleteById(Long id);
    public Vehiculo save(Vehiculo vehiculo);
    public Vehiculo update(Vehiculo vehiculo);
}
