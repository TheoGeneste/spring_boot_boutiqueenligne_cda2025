package com.cda.boutique.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/",produces="application/json" )
public class HelloController {
    
    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("{\"message\" : \"Helloo\"}");
    }
}
