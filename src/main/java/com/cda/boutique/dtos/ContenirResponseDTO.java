package com.cda.boutique.dtos;

import com.cda.boutique.entites.Commande;
import com.cda.boutique.entites.ContenirID;
import com.cda.boutique.entites.Produit;

public record ContenirResponseDTO(
        ContenirID id,
        Produit produit,
        Commande commande,
        Integer quantite
        ) {

}
