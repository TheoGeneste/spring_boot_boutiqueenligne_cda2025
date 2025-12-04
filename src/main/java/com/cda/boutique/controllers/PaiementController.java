package com.cda.boutique.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.boutique.entites.Paiement;
import com.cda.boutique.services.PaiementService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/paiements", produces="application/json")
public class PaiementController {
    private final PaiementService paiementService;

    @GetMapping
    public ResponseEntity<List<Paiement>> getPaiements(){
        return ResponseEntity.ok(paiementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiement(@PathVariable("id") Integer id){
        return ResponseEntity.ok(paiementService.find(id));
    }
    
    @PostMapping
    public ResponseEntity<String> addPaiement(@RequestBody Paiement paiement){
        paiementService.save(paiement);
        return ResponseEntity.ok("{\"message\": \"Paiement à bien été ajouté\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePaiement(@PathVariable("id") Integer id,@RequestBody Paiement paiement){
        paiement.setId(id);
        paiementService.save(paiement);
        return ResponseEntity.ok("{\"message\": \"Paiement à bien été modifié\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaiement(@PathVariable("id") Integer id){
        paiementService.remove(id);
        return ResponseEntity.ok("{\"message\": \"Paiement à bien été supprimé\"}");
    }
}
