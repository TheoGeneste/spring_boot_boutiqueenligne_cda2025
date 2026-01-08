package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.PaiementRequestDTO;
import com.cda.boutique.dtos.PaiementResponseDTO;
import com.cda.boutique.entites.Paiement;
import com.cda.boutique.mappers.PaiementMapper;
import com.cda.boutique.repositories.PaiementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementService {
    
    private final PaiementRepository paiementRepository;
    private final PaiementMapper paiementMapper;
    
    public List<PaiementResponseDTO> findAll(){
        List<Paiement> paiements = paiementRepository.findAll();
        return paiementMapper.toDTO(paiements);
    }

    public PaiementResponseDTO find(Integer id){
        Paiement paiement = null;
        if (paiementRepository.findById(id).isPresent()) {
            paiement = paiementRepository.findById(id).get();
        }
        return paiementMapper.toDTO(paiement);
    }

    public void update(Integer id,PaiementRequestDTO paiement){
        Paiement paiementToUpdate = paiementMapper.toEntity(paiement);
        paiementToUpdate.setId(id);
        paiementRepository.save(paiementToUpdate);
    }

    public void save(PaiementRequestDTO paiement){
        paiementRepository.save(paiementMapper.toEntity(paiement));
    }

    public void remove(Integer id){
        paiementRepository.deleteById(id);
    }
}
