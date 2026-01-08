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

import com.cda.boutique.dtos.ContenirRequestDTO;
import com.cda.boutique.dtos.ContenirResponseDTO;
import com.cda.boutique.entites.Contenir;
import com.cda.boutique.services.ContenirService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequestMapping(value="/api/contenirs", produces="application/json")
@RequiredArgsConstructor
public class ContenirController {
    
    private final ContenirService contenirService;


    @GetMapping
    public ResponseEntity<List<ContenirResponseDTO>> getContenirs(){
        return ResponseEntity.ok(contenirService.findAll());
    }

    @GetMapping("/{produitId}/{commandeId}")
    public ResponseEntity<ContenirResponseDTO> getContenir(@PathVariable("produitId") Integer produitId,@PathVariable("commandeId") Integer commandeId){
        return ResponseEntity.ok(contenirService.find(produitId, commandeId));
    }
    
    @PostMapping
    public ResponseEntity<String> addContenir(@RequestBody ContenirRequestDTO contenir){
        contenirService.save(contenir);
        return ResponseEntity.ok("{\"message\": \"Contenir à bien été ajouté\"}");
    }

    @PutMapping()
    public ResponseEntity<String> updateContenir(@RequestBody ContenirRequestDTO contenir){
        contenirService.save(contenir);
        return ResponseEntity.ok("{\"message\": \"Contenir à bien été modifié\"}");
    }

    @DeleteMapping("/{produitId}/{commandeId}")
    public ResponseEntity<String> deleteContenir(@PathVariable("produitId") Integer produitId,@PathVariable("commandeId") Integer commandeId){
        contenirService.remove(produitId,commandeId);
        return ResponseEntity.ok("{\"message\": \"Contenir à bien été supprimé\"}");
    }
}
