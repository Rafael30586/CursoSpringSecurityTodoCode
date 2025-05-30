package com.todocodeacademy.spring.security2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/holaseg")
    public String secHelloWorld(){
        return "Hola mundo todocode con seguridad";
    }

    @GetMapping("/holanoseg")
    public String noSecHelloWorld(){
        return "Hola mundo todocode sin seguridad";
    }
}
