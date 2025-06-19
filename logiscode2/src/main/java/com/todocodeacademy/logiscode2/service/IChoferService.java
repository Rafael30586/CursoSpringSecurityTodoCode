package com.todocodeacademy.logiscode2.service;

import com.todocodeacademy.logiscode2.model.Chofer;

import java.util.List;
import java.util.Optional;

public interface IChoferService {

    public List<Chofer> findAll();
    public Optional<Chofer> findById(Long id);
    public void deleteById(Long id);
    public Chofer save(Chofer chofer);
    public Chofer update(Chofer chofer);
}
