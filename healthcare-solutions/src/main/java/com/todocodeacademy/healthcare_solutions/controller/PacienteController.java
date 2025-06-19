package com.todocodeacademy.healthcare_solutions.controller;

import com.todocodeacademy.healthcare_solutions.model.Paciente;
import com.todocodeacademy.healthcare_solutions.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id){
        Paciente paciente = service.findById(id).orElse(new Paciente(-99999L,null,null,null));
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        return ResponseEntity.ok(service.save(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente){
        return ResponseEntity.ok(service.update(paciente));
    }
}
