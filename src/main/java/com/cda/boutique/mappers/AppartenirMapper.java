package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cda.boutique.dtos.AppartenirRequestDTO;
import com.cda.boutique.dtos.AppartenirResponseDTO;
import com.cda.boutique.entites.Appartenir;

/**
 * MAPPER - Couche de conversion
 * 
 * Rôle : Convertit les données entre les Entités (modèle BDD) et les DTOs (modèle API)
 * MapStruct génère automatiquement l'implémentation de cette interface à la compilation
 */
@Mapper(componentModel="spring") 
// @Mapper : Annotation MapStruct qui indique que cette interface est un mapper
// componentModel="spring" : Génère un bean Spring injectable (peut être utilisé avec @Autowired)
public interface AppartenirMapper {
    
    /**
     * Convertit une entité Appartenir en DTO de réponse
     * @param appartenir Entité à convertir
     * @return DTO de réponse correspondant
     */
    AppartenirResponseDTO toDTO(Appartenir appartenir);
    
    /**
     * Convertit une liste d'entités Appartenir en liste de DTOs de réponse
     * @param appartenir Liste d'entités à convertir
     * @return Liste de DTOs de réponse
     */
    List<AppartenirResponseDTO> toDTO(List<Appartenir> appartenir);

    /**
     * Convertit un DTO de requête en entité Appartenir
     * @param appartenirRequestDTO DTO à convertir
     * @return Entité correspondante
     */
    Appartenir toEntity(AppartenirRequestDTO appartenirRequestDTO);
    // Note : MapStruct génère automatiquement le code de conversion en comparant
    // les noms des champs entre l'entité et le DTO
}
