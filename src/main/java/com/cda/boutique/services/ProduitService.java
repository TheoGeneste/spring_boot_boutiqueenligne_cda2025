package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.ProduitDTO;
import com.cda.boutique.dtos.ProduitRequestDTO;
import com.cda.boutique.entites.Produit;
import com.cda.boutique.mappers.ProduitMapper;
import com.cda.boutique.repositories.ProduitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitService {
    
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    public List<ProduitDTO> findAll(){
        List<Produit> produits = produitRepository.findAll();
        return produitMapper.toDTO(produits);
    }

    public ProduitDTO find(Integer id){
        Produit produit = null;
        if (produitRepository.findById(id).isPresent()) {
            produit = produitRepository.findById(id).get();
        }
        return produitMapper.toDTO(produit);
    }

    public void save(ProduitRequestDTO produit){
        produitRepository.save(produitMapper.toEntity(produit));
    }

    public void remove(Integer id){
        produitRepository.deleteById(id);
    }

    public void update(ProduitRequestDTO produit, Integer id) {
        Produit produitToUpdate = produitMapper.toEntity(produit);
        produitToUpdate.setId(id);
        produitRepository.save(produitToUpdate);
    }

    
}
