package com.todocodeacademy.blog_online.controller;

import com.todocodeacademy.blog_online.model.Author;
import com.todocodeacademy.blog_online.model.Role;
import com.todocodeacademy.blog_online.model.UserSec;
import com.todocodeacademy.blog_online.service.IAuthorService;
import com.todocodeacademy.blog_online.service.IRoleService;
import com.todocodeacademy.blog_online.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private IAuthorService service;
    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService roleService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER','ROLE_AUTHOR')")
    public ResponseEntity<List<Author>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER','ROLE_AUTHOR')")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id).orElse(new Author(-99999L,null,null)));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping //Hay que crear un usuario a partir de los datos del autor
    public ResponseEntity<Author> save(@RequestBody Author author){
        UserSec user = new UserSec();
        user.setUsername(author.getUsername());
        user.setPassword(passwordEncoder.encode(author.getPassword()));
        user.setEnabled(true);
        user.setAccountNotExpired(true);
        user.setAccountNotLocked(true);
        user.setCredentialNotExpired(true);

        Set<Role> roleList = new HashSet<>();
        Role role = roleService.findByRole("AUTHOR").get();
        roleList.add(role);
        user.setRoleList(roleList);

        userService.save(user);

        return ResponseEntity.ok(service.save(author));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<Author> update(@RequestBody Author author){
        return ResponseEntity.ok(service.update(author));
    }
}
