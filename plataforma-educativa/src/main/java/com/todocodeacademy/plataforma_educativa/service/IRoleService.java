package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
    Role update(Role role);
    Role patch(Long roleId, Long permissionId, char accion);
}
