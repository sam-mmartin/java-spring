package com.example.projectgeneral.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {
    @GetMapping
    public String olaMundo() {
        return "Olá World";
    }
}