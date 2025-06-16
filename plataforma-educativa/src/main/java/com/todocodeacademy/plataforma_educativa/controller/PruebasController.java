package com.todocodeacademy.plataforma_educativa.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pruebas")
public class PruebasController {

    @GetMapping
    public String authentication(){
        String userDetails = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDetails;
    }
}
