package com.todocodeacademy.LogisCode.controller;

import com.todocodeacademy.LogisCode.model.Viaje;
import com.todocodeacademy.LogisCode.service.IViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    @Autowired
    private IViajeService service;

    @GetMapping("/{id}")
    public ResponseEntity<Viaje> findById(@PathVariable Long id){
        Viaje viaje = service.findById(id).orElse(new Viaje());
        return ResponseEntity.ok(viaje);
    }

    @GetMapping
    public ResponseEntity<List<Viaje>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Viaje> save(@RequestBody Viaje viaje){
        return ResponseEntity.ok(service.save(viaje));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<Viaje> update(@RequestBody Viaje viaje){
        return ResponseEntity.ok(service.update(viaje));
    }
}
