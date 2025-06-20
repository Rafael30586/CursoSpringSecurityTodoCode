package com.todocodeacademy.blog_online.controller;

import com.todocodeacademy.blog_online.model.Author;
import com.todocodeacademy.blog_online.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private IAuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id).orElse(new Author(-99999L,null,null)));
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author){
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
