package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.ContenirRequestDTO;
import com.cda.boutique.dtos.ContenirResponseDTO;
import com.cda.boutique.entites.Contenir;
import com.cda.boutique.entites.ContenirID;
import com.cda.boutique.mappers.ContenirMapper;
import com.cda.boutique.repositories.ContenirRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContenirService {
    
    private final ContenirRepository contenirRepository;
    private final ContenirMapper contenirMapper;

    public List<ContenirResponseDTO> findAll(){
        List<Contenir> contenirs = contenirRepository.findAll();
        return contenirMapper.toDTO(contenirs);
    }

    public ContenirResponseDTO find(Integer produitId, Integer commandeId){
        Contenir contenir = null;
        if (contenirRepository.findById(new ContenirID(produitId, commandeId)).isPresent()) {
            contenir = contenirRepository.findById(new ContenirID(produitId, commandeId)).get();
        }
        return contenirMapper.toDTO(contenir);
    }

    public void save(ContenirRequestDTO contenir){
        contenirRepository.save(contenirMapper.toEntity(contenir));
    }

    public void remove(Integer produitId, Integer commandeId){
        contenirRepository.deleteById(new ContenirID(produitId, commandeId));
    }

    
}
