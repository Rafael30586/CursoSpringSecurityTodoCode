package com.todocodeacademy.logiscode2.service;

import com.todocodeacademy.logiscode2.model.Chofer;
import com.todocodeacademy.logiscode2.repository.IChoferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoferService implements IChoferService{

    @Autowired
    private IChoferRepository repository;

    @Override
    public List<Chofer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Chofer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Chofer save(Chofer chofer) {
        return repository.save(chofer);
    }

    @Override
    public Chofer update(Chofer chofer) {
        return repository.save(chofer);
    }
}
