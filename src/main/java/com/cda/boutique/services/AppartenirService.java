package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.AppartenirRequestDTO;
import com.cda.boutique.dtos.AppartenirResponseDTO;
import com.cda.boutique.entites.Appartenir;
import com.cda.boutique.entites.AppartenirID;
import com.cda.boutique.mappers.AppartenirMapper;
import com.cda.boutique.repositories.AppartenirRepository;

import lombok.RequiredArgsConstructor;

/**
 * SERVICE - Couche métier
 * 
 * Rôle : Contient la logique métier pour gérer les relations "Appartenir"
 * Orchestre les opérations entre le repository (accès BDD) et le mapper (conversion DTO/Entité)
 */
@Service // @Service : Indique que cette classe est un service Spring (géré par le conteneur IoC)
@RequiredArgsConstructor // Lombok : Génère un constructeur pour l'injection de dépendances
public class AppartenirService {
    
    // Injection des dépendances nécessaires
    private final AppartenirRepository appartenirRepository; // Accès à la base de données
    private final AppartenirMapper appartenirMapper; // Conversion entre DTO et Entité

    /**
     * Récupère toutes les relations produit-catégorie
     * @return Liste de toutes les relations converties en DTO
     */
    public List<AppartenirResponseDTO> findAll(){
        // 1. Récupère les entités depuis la BDD
        List<Appartenir> appartenirs = appartenirRepository.findAll();
        // 2. Convertit les entités en DTOs pour la réponse
        return appartenirMapper.toDTO(appartenirs);
    }

    /**
     * Récupère une relation spécifique par les IDs produit et catégorie
     * @param produitId ID du produit
     * @param categorieId ID de la catégorie
     * @return La relation trouvée convertie en DTO, ou null si non trouvée
     */
    public AppartenirResponseDTO find(Integer produitId,Integer categorieId){
        Appartenir appartenir = null;
        // Crée une clé composite pour chercher dans la BDD
        AppartenirID id = new AppartenirID(produitId, categorieId);
        // Vérifie si l'entité existe avant de la récupérer
        if (appartenirRepository.findById(id).isPresent()) {
            appartenir = appartenirRepository.findById(id).get();
        }
        // Convertit l'entité en DTO
        return appartenirMapper.toDTO(appartenir);
    }

    /**
     * Sauvegarde une nouvelle relation produit-catégorie
     * @param appartenir DTO contenant les données de la relation à créer
     */
    public void save(AppartenirRequestDTO appartenir){
        // 1. Convertit le DTO en entité
        Appartenir entity = appartenirMapper.toEntity(appartenir);
        // 2. Sauvegarde l'entité en base de données
        appartenirRepository.save(entity);
    }

    /**
     * Supprime une relation produit-catégorie
     * @param produitId ID du produit
     * @param categorieId ID de la catégorie
     */
    public void remove(Integer produitId, Integer categorieId){
        // Crée la clé composite et supprime l'entité correspondante
        appartenirRepository.deleteById(new AppartenirID(produitId, categorieId));
    }

    
}
