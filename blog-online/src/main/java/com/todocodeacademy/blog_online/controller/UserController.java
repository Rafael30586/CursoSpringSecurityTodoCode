package com.todocodeacademy.blog_online.controller;

import com.todocodeacademy.blog_online.model.Role;
import com.todocodeacademy.blog_online.model.UserSec;
import com.todocodeacademy.blog_online.service.IRoleService;
import com.todocodeacademy.blog_online.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private IRoleService roleService;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<UserSec>> getAllUsers() {
        List users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Optional<UserSec> user = service.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping
    public ResponseEntity createUser(@RequestBody UserSec userSec) {

        Set<Role> roleList = new HashSet<>();
        Role readRole;

        userSec.setPassword(service.encriptPassword(userSec.getPassword()));

        // Recuperar la Permission/s por su ID
        for (Role role : userSec.getRoleList()){
            readRole = roleService.findById(role.getId()).orElse(null);
            if (readRole != null) {
                //si encuentro, guardo en la lista
                roleList.add(readRole);
            }
        }

        if (!roleList.isEmpty()) {
            userSec.setRoleList(roleList);

            UserSec newUser = service.save(userSec);
            return ResponseEntity.ok(newUser);
        }
        return null;
    }

    //rafael , admin , contraseña: 1234
}
