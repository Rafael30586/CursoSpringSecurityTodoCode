package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Author;
import com.todocodeacademy.blog_online.model.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    public List<Permission> findAll();
    public Optional<Permission> findById(Long id);
    public void deleteById(Long id);
    public Permission save(Permission permission);
    public Permission update(Permission permission);
}
