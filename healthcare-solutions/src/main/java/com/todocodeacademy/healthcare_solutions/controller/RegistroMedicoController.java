package com.todocodeacademy.healthcare_solutions.controller;

import com.todocodeacademy.healthcare_solutions.model.RegistroMedico;
import com.todocodeacademy.healthcare_solutions.service.IRegistroMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros-medicos")
public class RegistroMedicoController {

    @Autowired
    private IRegistroMedicoService service;

    @GetMapping
    public ResponseEntity<List<RegistroMedico>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping
    public ResponseEntity<RegistroMedico> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id).orElse(new RegistroMedico(-9999L,null,null,null)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<RegistroMedico> save(@RequestBody RegistroMedico registroMedico){
        return ResponseEntity.ok(service.save(registroMedico));
    }

    @PutMapping
    public ResponseEntity<RegistroMedico> update(@RequestBody RegistroMedico registroMedico){
        return ResponseEntity.ok(service.update(registroMedico));
    }
}
