package com.todocodeacademy.spring.security2.service;

import com.todocodeacademy.spring.security2.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    List findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
    Role update(Role role);

}
