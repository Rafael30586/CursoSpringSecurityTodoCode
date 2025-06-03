package com.todocodeacademy.spring.security2.controller;

import com.todocodeacademy.spring.security2.model.Permission;
import com.todocodeacademy.spring.security2.model.Role;
import com.todocodeacademy.spring.security2.service.IPermissionService;
import com.todocodeacademy.spring.security2.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private IRoleService service;
    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    public ResponseEntity<List> getAllRoles(){
        List roles = service.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoleById(@PathVariable Long id){
        Optional<Role> role = service.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    /*
    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable Long id){
        return service.findById(id);
    }*/

    @PostMapping
    public ResponseEntity createRole(@RequestBody Role role){
        Set<Permission> permissionList = new HashSet<>();
        Permission readPermission;

        for(Permission p : role.getPermissionList()){
            readPermission = permissionService.findById(p.getId()).orElse(null);
            if(readPermission != null) permissionList.add(readPermission);
        }

        role.setPermissionList(permissionList);
        Role newRole = service.save(role);

        return ResponseEntity.ok(newRole);

    }

}
