package com.cda.boutique.entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CLÉ PRIMAIRE COMPOSITE
 * 
 * Rôle : Représente la clé primaire composite de la table "appartenir"
 * Cette classe est "embarquée" dans l'entité Appartenir pour former sa clé primaire
 */
@Getter // Lombok : Génère les getters
@Setter // Lombok : Génère les setters
@Embeddable // @Embeddable : Indique que cette classe peut être embarquée dans une autre entité (@EmbeddedId)
@NoArgsConstructor // Lombok : Génère un constructeur sans paramètres (requis par JPA)
@AllArgsConstructor // Lombok : Génère un constructeur avec tous les paramètres
@EqualsAndHashCode // Lombok : Génère equals() et hashCode() (nécessaire pour les clés primaires)
public class AppartenirID implements Serializable {
    // implements Serializable : Permet la sérialisation (requis pour les clés primaires composites)

    /**
     * ID du produit (partie de la clé primaire composite)
     */
    @Column(name = "PR_ID") // @Column : Spécifie le nom de la colonne en base de données
    private Integer produitId;

    /**
     * ID de la catégorie (partie de la clé primaire composite)
     */
    @Column(name = "CA_ID") // @Column : Spécifie le nom de la colonne en base de données
    private Integer categorieId;
}
