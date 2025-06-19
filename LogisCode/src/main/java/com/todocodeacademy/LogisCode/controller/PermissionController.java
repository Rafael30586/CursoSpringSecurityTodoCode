package com.todocodeacademy.LogisCode.controller;

import com.todocodeacademy.LogisCode.model.Permission;
import com.todocodeacademy.LogisCode.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
@PreAuthorize("denyAll()")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Permission>> getAllPermissions() {
        List permissions = permissionService.findAll();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity getPermissionById(@PathVariable Long id) {
        Optional<Permission> permission = permissionService.findById(id);
        return permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity createPermission(@RequestBody Permission permission) {
        Permission newPermission = permissionService.save(permission);
        return ResponseEntity.ok(newPermission);
    }

}
