package com.todocodeacademy.blog_online.controller;

import com.todocodeacademy.blog_online.model.Post;
import com.todocodeacademy.blog_online.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private IPostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id).orElse(new Post(-999L,null,null,null)));
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post){
        return ResponseEntity.ok(service.save(post));
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<Post> update(@RequestBody Post post){
        return ResponseEntity.ok(service.update(post));
    }
}
