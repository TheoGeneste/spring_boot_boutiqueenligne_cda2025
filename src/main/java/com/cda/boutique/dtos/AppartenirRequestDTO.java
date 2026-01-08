package com.cda.boutique.dtos;

import com.cda.boutique.entites.Categorie;
import com.cda.boutique.entites.Produit;

public record AppartenirRequestDTO(
        Produit produit,
        Categorie categorie
        ) {

}
