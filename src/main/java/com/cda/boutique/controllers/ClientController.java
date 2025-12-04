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

import com.cda.boutique.entites.Client;
import com.cda.boutique.services.ClientService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequestMapping(value="/api/clients", produces="application/json")
@RequiredArgsConstructor
public class ClientController {
    
    private final ClientService clientService;


    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Integer id){
        return ResponseEntity.ok(clientService.find(id));
    }
    
    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody Client client){
        clientService.save(client);
        return ResponseEntity.ok("{\"message\": \"Client à bien été ajouté\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable("id") Integer id,@RequestBody Client client){
        client.setId(id);
        clientService.save(client);
        return ResponseEntity.ok("{\"message\": \"Client à bien été modifié\"}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Integer id){
        clientService.remove(id);
        return ResponseEntity.ok("{\"message\": \"Client à bien été supprimé\"}");
    }
}
