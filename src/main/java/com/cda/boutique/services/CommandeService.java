package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.entites.Commande;
import com.cda.boutique.repositories.CommandeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommandeService {
    
    private final CommandeRepository commandeRepository;

    
    public List<Commande> findAll(){
        List<Commande> commandes = commandeRepository.findAll();
        return commandes;
    }

    public Commande find(Integer id){
        Commande commande = null;
        if (commandeRepository.findById(id).isPresent()) {
            commande = commandeRepository.findById(id).get();
        }
        return commande;
    }

    public void save(Commande commande){
        commandeRepository.save(commande);
    }

    public void remove(Integer id){
        commandeRepository.deleteById(id);
    }
}
