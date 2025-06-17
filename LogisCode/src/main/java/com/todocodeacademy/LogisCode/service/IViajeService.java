package com.todocodeacademy.LogisCode.service;

import com.todocodeacademy.LogisCode.model.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IViajeService {

    public List<Viaje> findAll();
    public Optional<Viaje> findById(Long id);
    public void deleteById(Long id);
    public Viaje save(Viaje viaje);
    public Viaje update(Viaje viaje);
}
