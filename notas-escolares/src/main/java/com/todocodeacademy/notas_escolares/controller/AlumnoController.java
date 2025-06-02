package com.todocodeacademy.notas_escolares.controller;

import com.todocodeacademy.notas_escolares.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/califications")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/")
    public List<Double> getNotas(){
        return alumnoService.getNotas();
    }

    @GetMapping("/average")
    public Double getPromedio(){
        return alumnoService.getPromedio();
    }
}
