package com.cda.boutique.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.boutique.dtos.AppartenirRequestDTO;
import com.cda.boutique.dtos.AppartenirResponseDTO;
import com.cda.boutique.services.AppartenirService;

import lombok.RequiredArgsConstructor;

/**
 * CONTROLLER - Couche de présentation
 * 
 * Rôle : Expose les endpoints REST pour gérer les relations "Appartenir" (produit-catégorie)
 * Reçoit les requêtes HTTP et délègue le traitement au service
 */
@RestController // @RestController : Combine @Controller + @ResponseBody (retourne directement du JSON, pas de vue HTML)
@RequestMapping(value="/api/appartenirs", produces="application/json") // @RequestMapping : Définit le préfixe URL pour tous les endpoints de ce contrôleur
@RequiredArgsConstructor // Lombok : Génère automatiquement un constructeur avec les champs finaux (injection de dépendances)
public class AppartenirController {
    
    // Injection de dépendance : Spring fournit automatiquement une instance du service
    private final AppartenirService appartenirService;

    /**
     * GET /api/appartenirs
     * Récupère toutes les relations produit-catégorie
     * @return Liste de toutes les relations au format JSON
     */
    @GetMapping // @GetMapping : Mappe les requêtes HTTP GET sur cette méthode
    public ResponseEntity<List<AppartenirResponseDTO>> getAppartenirs(){
        return ResponseEntity.ok(appartenirService.findAll()); // ResponseEntity.ok() : Retourne un statut HTTP 200 avec le corps de la réponse
    }

    /**
     * GET /api/appartenirs/{produitId}/{categorieId}
     * Récupère une relation spécifique par les IDs produit et catégorie
     * @param produitId ID du produit (extrait de l'URL)
     * @param categorieId ID de la catégorie (extrait de l'URL)
     * @return La relation trouvée au format JSON
     */
    @GetMapping("/{produitId}/{categorieId}") // Les accolades {} définissent des variables de chemin
    public ResponseEntity<AppartenirResponseDTO> getAppartenir(@PathVariable("produitId") Integer produitId,@PathVariable("categorieId") Integer categorieId){
        // @PathVariable : Extrait les valeurs de l'URL et les injecte dans les paramètres
        return ResponseEntity.ok(appartenirService.find(produitId,categorieId));
    }
    
    /**
     * POST /api/appartenirs
     * Crée une nouvelle relation produit-catégorie
     * @param appartenir Données de la relation à créer (reçues en JSON dans le corps de la requête)
     * @return Message de confirmation
     */
    @PostMapping // @PostMapping : Mappe les requêtes HTTP POST sur cette méthode
    public ResponseEntity<String> addAppartenir(@RequestBody AppartenirRequestDTO appartenir){
        // @RequestBody : Convertit automatiquement le JSON reçu en objet Java AppartenirRequestDTO
        appartenirService.save(appartenir);
        return ResponseEntity.ok("{\"message\": \"Appartenir à bien été ajouté\"}");
    }

    /**
     * DELETE /api/appartenirs/{produitId}/{categorieId}
     * Supprime une relation produit-catégorie spécifique
     * @param produitId ID du produit
     * @param categorieId ID de la catégorie
     * @return Message de confirmation
     */
    @DeleteMapping("/{produitId}/{categorieId}") // @DeleteMapping : Mappe les requêtes HTTP DELETE sur cette méthode
    public ResponseEntity<String> deleteAppartenir(@PathVariable("produitId") Integer produitId,@PathVariable("categorieId") Integer categorieId){
        appartenirService.remove(produitId,categorieId);
        return ResponseEntity.ok("{\"message\": \"Appartenir à bien été supprimé\"}");
    }
}
