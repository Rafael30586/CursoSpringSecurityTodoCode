package com.todocodeacademy.LogisCode.controller;

import com.todocodeacademy.LogisCode.model.Vehiculo;
import com.todocodeacademy.LogisCode.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService service;

    @GetMapping
    public List<Vehiculo> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Vehiculo save(@RequestBody Vehiculo vehiculo){
        return service.save(vehiculo);
    }

    @GetMapping("/{id}")
    public Vehiculo findById(@PathVariable Long id){
        return service.findById(id).orElse(new Vehiculo());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    public Vehiculo update(@RequestBody Vehiculo vehiculo){
        return service.update(vehiculo);
    }
}
