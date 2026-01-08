package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cda.boutique.dtos.CategorieDTO;
import com.cda.boutique.dtos.CategorieRequestDTO;
import com.cda.boutique.entites.Categorie;

@Mapper(componentModel="spring")
public interface CategorieMapper {
    CategorieDTO toDTO(Categorie categorie);
    List<CategorieDTO> toDTO(List<Categorie> categorie);

    Categorie toEntity(CategorieDTO categorieDTO);
    Categorie toEntity(CategorieRequestDTO categorieRequestDTO);
}
