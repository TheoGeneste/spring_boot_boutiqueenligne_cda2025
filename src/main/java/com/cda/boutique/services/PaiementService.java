package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.entites.Paiement;
import com.cda.boutique.repositories.PaiementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementService {
    
    private final PaiementRepository paiementRepository;

    
    public List<Paiement> findAll(){
        List<Paiement> paiements = paiementRepository.findAll();
        return paiements;
    }

    public Paiement find(Integer id){
        Paiement paiement = null;
        if (paiementRepository.findById(id).isPresent()) {
            paiement = paiementRepository.findById(id).get();
        }
        return paiement;
    }

    public void save(Paiement paiement){
        paiementRepository.save(paiement);
    }

    public void remove(Integer id){
        paiementRepository.deleteById(id);
    }
}
