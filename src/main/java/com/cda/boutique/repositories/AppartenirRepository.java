package com.cda.boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.boutique.entites.Appartenir;
import com.cda.boutique.entites.AppartenirID;

/**
 * REPOSITORY - Couche d'accès aux données (DAO)
 * 
 * Rôle : Interface pour accéder aux données de la table "appartenir" en base de données
 * Spring Data JPA génère automatiquement l'implémentation de cette interface
 */
@Repository // @Repository : Indique que cette interface est un repository Spring (accès aux données)
public interface  AppartenirRepository extends JpaRepository<Appartenir, AppartenirID> {
    // extends JpaRepository<Appartenir, AppartenirID> :
    // - Appartenir : Type de l'entité gérée
    // - AppartenirID : Type de la clé primaire (clé composite dans ce cas)
    // 
    // Méthodes disponibles automatiquement (sans les écrire) :
    // - findAll() : Récupère toutes les entités
    // - findById(id) : Récupère une entité par son ID
    // - save(entity) : Sauvegarde ou met à jour une entité
    // - deleteById(id) : Supprime une entité par son ID
    // - count() : Compte le nombre d'entités
    // - etc.
}
