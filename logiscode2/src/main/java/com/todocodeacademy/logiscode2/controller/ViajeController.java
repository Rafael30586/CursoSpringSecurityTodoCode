package com.todocodeacademy.logiscode2.controller;

import com.todocodeacademy.logiscode2.model.Viaje;
import com.todocodeacademy.logiscode2.service.IViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    @Autowired
    private IViajeService service;

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Viaje> findById(@PathVariable Long id){
        Viaje viaje = service.findById(id).orElse(new Viaje());
        return ResponseEntity.ok(viaje);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Viaje>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Viaje> save(@RequestBody Viaje viaje){
        return ResponseEntity.ok(service.save(viaje));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Viaje> update(@RequestBody Viaje viaje){
        return ResponseEntity.ok(service.update(viaje));
    }
}
