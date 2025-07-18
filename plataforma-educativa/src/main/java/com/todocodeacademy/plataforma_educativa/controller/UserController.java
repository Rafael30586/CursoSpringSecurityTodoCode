package com.todocodeacademy.plataforma_educativa.controller;

import com.todocodeacademy.plataforma_educativa.model.Role;
import com.todocodeacademy.plataforma_educativa.model.UserSec;
import com.todocodeacademy.plataforma_educativa.service.IRoleService;
import com.todocodeacademy.plataforma_educativa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@PreAuthorize("denyAll()")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<UserSec>> getAllUsers() {
        List users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Optional<UserSec> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity editUser(@RequestBody UserSec userSec){
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

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
    //rafael, contraseña: 1234 ADMIN
    //pancho, contraseña: 1234 STUDENT
}
