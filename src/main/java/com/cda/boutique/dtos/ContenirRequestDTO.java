package com.cda.boutique.dtos;

import com.cda.boutique.entites.Commande;
import com.cda.boutique.entites.Produit;

public record ContenirRequestDTO(
        Produit produit,
        Commande commande,
        Integer quantite
        ) {

}
