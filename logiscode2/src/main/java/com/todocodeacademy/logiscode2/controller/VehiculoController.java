package com.todocodeacademy.logiscode2.controller;

import com.todocodeacademy.logiscode2.model.Vehiculo;
import com.todocodeacademy.logiscode2.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService service;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<Vehiculo> findAll(){
        return service.findAll();
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public Vehiculo save(@RequestBody Vehiculo vehiculo){
        return service.save(vehiculo);
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public Vehiculo findById(@PathVariable Long id){
        return service.findById(id).orElse(new Vehiculo());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public Vehiculo update(@RequestBody Vehiculo vehiculo){
        return service.update(vehiculo);
    }
}
