package com.todocodeacademy.springSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("denyAll()")
public class HelloWolrdController {

    @GetMapping("/holaseg")
    @PreAuthorize("hasAuthority('READ')")
    public String secHelloWorld(){
        return "Hola mundo todocode con seguridad";
    }

    @GetMapping("/holanoseg")
    @PreAuthorize("permitAll()")
    public String noSecHelloWorld(){
        return "Hola mundo todocode sin seguridad";
    }
}
