package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Author;
import com.todocodeacademy.blog_online.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    public List<Role> findAll();
    public Optional<Role> findById(Long id);
    public void deleteById(Long id);
    public Role save(Role role);
    public Role update(Role role);
    public Role patch(Long roleId, Long permissionId, char accion);
    public Optional<Role> findByRole(String role);
}
