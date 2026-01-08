package com.cda.boutique.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.boutique.dtos.AppartenirRequestDTO;
import com.cda.boutique.dtos.AppartenirResponseDTO;
import com.cda.boutique.services.AppartenirService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequestMapping(value="/api/appartenirs", produces="application/json")
@RequiredArgsConstructor
public class AppartenirController {
    
    private final AppartenirService appartenirService;


    @GetMapping
    public ResponseEntity<List<AppartenirResponseDTO>> getAppartenirs(){
        return ResponseEntity.ok(appartenirService.findAll());
    }

    @GetMapping("/{produitId}/{categorieId}")
    public ResponseEntity<AppartenirResponseDTO> getAppartenir(@PathVariable("produitId") Integer produitId,@PathVariable("categorieId") Integer categorieId){
        return ResponseEntity.ok(appartenirService.find(produitId,categorieId));
    }
    
    @PostMapping
    public ResponseEntity<String> addAppartenir(@RequestBody AppartenirRequestDTO appartenir){
        appartenirService.save(appartenir);
        return ResponseEntity.ok("{\"message\": \"Appartenir à bien été ajouté\"}");
    }

    @DeleteMapping("/{produitId}/{categorieId}")
    public ResponseEntity<String> deleteAppartenir(@PathVariable("produitId") Integer produitId,@PathVariable("categorieId") Integer categorieId){
        appartenirService.remove(produitId,categorieId);
        return ResponseEntity.ok("{\"message\": \"Appartenir à bien été supprimé\"}");
    }
}
