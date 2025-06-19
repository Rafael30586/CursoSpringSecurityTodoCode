package com.todocodeacademy.logiscode2.controller;

import com.todocodeacademy.logiscode2.model.Chofer;
import com.todocodeacademy.logiscode2.service.IChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/choferes")
public class ChoferController {

    @Autowired
    private IChoferService service;

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public Chofer findById(@PathVariable Long id){
        return service.findById(id).orElse(new Chofer());
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<Chofer> findAll(){
        return service.findAll();
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public Chofer save(@RequestBody Chofer chofer){
        return service.save(chofer);
    }

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public Chofer update(@RequestBody Chofer chofer){
        return service.update(chofer);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
