package com.todocodeacademy.ejemplooauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("denyAll()")
public class GreetingsController {

    @GetMapping("sayhi")
    @PreAuthorize("permitAll()")
    public String sayHi(){
        return "Hi! this endpoint is not secured";
    }

    @GetMapping("sayhisec")
    @PreAuthorize("isAuthenticated()")
    public String sayHiSec(){
        return "Hi! this enpoint has been secured";
    }
}
