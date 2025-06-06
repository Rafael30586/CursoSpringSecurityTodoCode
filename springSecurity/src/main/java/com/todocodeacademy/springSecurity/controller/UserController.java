package com.todocodeacademy.springSecurity.controller;


import com.todocodeacademy.springSecurity.model.Role;
import com.todocodeacademy.springSecurity.model.UserSec;
import com.todocodeacademy.springSecurity.service.IRoleService;
import com.todocodeacademy.springSecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<UserSec>> getAllUsers() {
        List users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Optional<UserSec> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserSec userSec) {

        Set<Role> roleList = new HashSet<>();
        Role readRole;

        userSec.setPassword(userService.encriptPassword(userSec.getPassword()));

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

            UserSec newUser = userService.save(userSec);
            return ResponseEntity.ok(newUser);
        }
        return null;
    }
}

