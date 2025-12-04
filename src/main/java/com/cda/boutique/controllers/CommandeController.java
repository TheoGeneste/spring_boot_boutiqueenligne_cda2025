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

import com.cda.boutique.entites.Commande;
import com.cda.boutique.services.CommandeService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/commandes", produces="application/json")
public class CommandeController {
    private final CommandeService commandeService;

    @GetMapping
    public ResponseEntity<List<Commande>> getCommandes(){
        return ResponseEntity.ok(commandeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommande(@PathVariable("id") Integer id){
        return ResponseEntity.ok(commandeService.find(id));
    }
    
    @PostMapping
    public ResponseEntity<String> addCommande(@RequestBody Commande commande){
        commandeService.save(commande);
        return ResponseEntity.ok("{\"message\": \"Commande à bien été ajouté\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCommande(@PathVariable("id") Integer id,@RequestBody Commande commande){
        commande.setId(id);
        commandeService.save(commande);
        return ResponseEntity.ok("{\"message\": \"Commande à bien été modifié\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommande(@PathVariable("id") Integer id){
        commandeService.remove(id);
        return ResponseEntity.ok("{\"message\": \"Commande à bien été supprimé\"}");
    }
}
