package com.todocodeacademy.logiscode2.service;

import com.todocodeacademy.logiscode2.model.Viaje;

import java.util.List;
import java.util.Optional;

public interface IViajeService {

    public List<Viaje> findAll();
    public Optional<Viaje> findById(Long id);
    public void deleteById(Long id);
    public Viaje save(Viaje viaje);
    public Viaje update(Viaje viaje);
}
