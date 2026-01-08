package com.cda.boutique.dtos;

import com.cda.boutique.entites.AppartenirID;
import com.cda.boutique.entites.Categorie;
import com.cda.boutique.entites.Produit;


public record AppartenirResponseDTO(
        AppartenirID id,
        Produit produit,
        Categorie categorie
        ) {

}
