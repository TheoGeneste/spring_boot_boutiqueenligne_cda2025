package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cda.boutique.dtos.ProduitDTO;
import com.cda.boutique.dtos.ProduitRequestDTO;
import com.cda.boutique.entites.Produit;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    ProduitDTO toDTO(Produit produit);

    List<ProduitDTO> toDTO(List<Produit> produits);

    Produit toEntity(ProduitDTO produitDTO);

    Produit toEntity(ProduitRequestDTO produitDTO);
}
