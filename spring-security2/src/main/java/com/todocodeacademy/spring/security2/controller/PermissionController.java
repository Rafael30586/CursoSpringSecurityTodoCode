package com.todocodeacademy.spring.security2.controller;

import com.todocodeacademy.spring.security2.model.Permission;
import com.todocodeacademy.spring.security2.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private IPermissionService service;

    @GetMapping
    public ResponseEntity<List> getAllPermissions(){
        List permissions = service.findAll();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPermissionById(@PathVariable Long id){
        Optional<Permission> permission = service.findById(id);
        return permission.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());

    }
/*
    @GetMapping("/{id}")
    public Optional<Permission> getPermissionById(@PathVariable Long id){
        return service.findById(id);
    }*/

    @PostMapping
    public ResponseEntity createPermission(@RequestBody Permission permission){
        Permission newPermission = service.save(permission);
        return ResponseEntity.ok(newPermission);
    }
}
