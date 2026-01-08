package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.CategorieDTO;
import com.cda.boutique.dtos.CategorieRequestDTO;
import com.cda.boutique.entites.Categorie;
import com.cda.boutique.mappers.CategorieMapper;
import com.cda.boutique.repositories.CategorieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieService {
    
    private final CategorieRepository categorieRepository;
    private final CategorieMapper categorieMapper;

    public List<CategorieDTO> findAll(){
        List<Categorie> categories = categorieRepository.findAll();
        return categorieMapper.toDTO(categories);
    }

    public CategorieDTO find(Integer id){
        Categorie categorie = null;
        if (categorieRepository.findById(id).isPresent()) {
            categorie = categorieRepository.findById(id).get();
        }
        return categorieMapper.toDTO(categorie);
    }

    public void save(CategorieRequestDTO categorie){
        categorieRepository.save(categorieMapper.toEntity(categorie));
    }

    public void update(CategorieRequestDTO categorie, Integer id){
        Categorie categorieToUpdate = categorieMapper.toEntity(categorie);
        categorieToUpdate.setId(id);
        categorieRepository.save(categorieToUpdate);
    }

    public void remove(Integer id){
        categorieRepository.deleteById(id);
    }

    
}
