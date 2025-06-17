package com.todocodeacademy.LogisCode.service;

import com.todocodeacademy.LogisCode.model.Chofer;
import com.todocodeacademy.LogisCode.model.Viaje;

import java.util.List;
import java.util.Optional;

public interface IChoferService {
    public List<Chofer> findAll();
    public Optional<Chofer> findById(Long id);
    public void deleteById(Long id);
    public Chofer save(Chofer chofer);
    public Chofer update(Chofer chofer);
}
