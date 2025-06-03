package com.todocodeacademy.spring.security2.service;

import com.todocodeacademy.spring.security2.model.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    List findAll();
    Optional<Permission> findById(Long id);
    Permission save(Permission permission);
    void deleteById(Long id);
    Permission update(Permission permission);
}
