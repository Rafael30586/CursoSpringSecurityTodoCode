package com.todocodeacademy.LogisCode.controller;

import com.todocodeacademy.LogisCode.model.Chofer;
import com.todocodeacademy.LogisCode.service.IChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/choferes")
public class ChoferController {

    @Autowired
    private IChoferService service;

    @GetMapping("/{id}")
    public Chofer findById(@PathVariable Long id){
        return service.findById(id).orElse(new Chofer());
    }

    @GetMapping
    public List<Chofer> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Chofer save(@RequestBody Chofer chofer){
        return service.save(chofer);
    }

    @PutMapping
    public Chofer update(@RequestBody Chofer chofer){
        return service.update(chofer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
