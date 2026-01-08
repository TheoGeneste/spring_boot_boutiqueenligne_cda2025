package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.AppartenirRequestDTO;
import com.cda.boutique.dtos.AppartenirResponseDTO;
import com.cda.boutique.entites.Appartenir;
import com.cda.boutique.entites.AppartenirID;
import com.cda.boutique.mappers.AppartenirMapper;
import com.cda.boutique.repositories.AppartenirRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppartenirService {
    
    private final AppartenirRepository appartenirRepository;
    private final AppartenirMapper appartenirMapper;

    public List<AppartenirResponseDTO> findAll(){
        List<Appartenir> appartenirs = appartenirRepository.findAll();
        return appartenirMapper.toDTO(appartenirs);
    }

    public AppartenirResponseDTO find(Integer produitId,Integer categorieId){
        Appartenir appartenir = null;
        if (appartenirRepository.findById(new AppartenirID(produitId, categorieId)).isPresent()) {
            appartenir = appartenirRepository.findById(new AppartenirID(produitId, categorieId)).get();
        }
        return appartenirMapper.toDTO(appartenir);
    }

    public void save(AppartenirRequestDTO appartenir){
        appartenirRepository.save(appartenirMapper.toEntity(appartenir));
    }

    public void remove(Integer produitId, Integer categorieId){
        appartenirRepository.deleteById(new AppartenirID(produitId, categorieId));
    }

    
}
