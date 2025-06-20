package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Permission;
import com.todocodeacademy.blog_online.repository.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements IPermissionService{

    @Autowired
    private IPermissionRepository repository;


    @Override
    public List<Permission> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Permission> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Permission save(Permission permission) {
        return repository.save(permission);
    }

    @Override
    public Permission update(Permission permission) {
        return repository.save(permission);
    }
}
