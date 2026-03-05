package com.cda.boutique.dtos;

import com.cda.boutique.entites.Categorie;
import com.cda.boutique.entites.Produit;

/**
 * DTO (Data Transfer Object) - Requête
 * 
 * Rôle : Objet utilisé pour recevoir les données depuis le client (front-end, Postman, etc.)
 * Contient les données nécessaires pour créer une nouvelle relation produit-catégorie
 * 
 * Note : Utilise un "record" Java (depuis Java 14) qui génère automatiquement :
 * - Les champs finaux (immutables)
 * - Un constructeur
 * - Les getters
 * - equals(), hashCode(), toString()
 */
public record AppartenirRequestDTO(
        Produit produit,    // Produit à associer à la catégorie
        Categorie categorie  // Catégorie à associer au produit
        ) {
    // Les records sont immutables par défaut (valeurs finales)
    // Utilisé pour les requêtes POST (création)
}
