package com.cda.boutique.dtos;

import com.cda.boutique.entites.AppartenirID;
import com.cda.boutique.entites.Categorie;
import com.cda.boutique.entites.Produit;

/**
 * DTO (Data Transfer Object) - Réponse
 * 
 * Rôle : Objet utilisé pour renvoyer les données au client (front-end, Postman, etc.)
 * Contient toutes les informations d'une relation produit-catégorie à afficher
 * 
 * Différence avec AppartenirRequestDTO :
 * - Contient l'ID de la relation (généré après création)
 * - Utilisé pour les réponses GET (lecture)
 */
public record AppartenirResponseDTO(
        AppartenirID id,      // Clé primaire composite de la relation (produitId + categorieId)
        Produit produit,       // Produit associé
        Categorie categorie    // Catégorie associée
        ) {
    // Les records sont immutables par défaut (valeurs finales)
    // Utilisé pour les réponses GET (lecture)
}
