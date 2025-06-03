package com.todocodeacademy.spring.security2.controller;

import com.todocodeacademy.spring.security2.model.Role;
import com.todocodeacademy.spring.security2.model.UserSec;
import com.todocodeacademy.spring.security2.service.IRoleService;
import com.todocodeacademy.spring.security2.service.IUserService;
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
    private IUserService service;
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<List> getAllUsers(){
        List users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        Optional<UserSec> user = service.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserSec userSec){
        Set<Role> roleList = new HashSet<>();
        Role readRole;

        for(Role role : userSec.getRoleList()){
            readRole = roleService.findById(role.getId()).orElse(null);
            if(readRole != null) {
                roleList.add(readRole);
            }

        }

        if(!roleList.isEmpty()){
            userSec.setRoleList(roleList);
            UserSec newUser = service.save(userSec);

            return ResponseEntity.ok(newUser);
        }
        return null;
    }
}
