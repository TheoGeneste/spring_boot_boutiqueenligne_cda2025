package com.cda.boutique.entites;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * ENTITÉ - Modèle de données métier
 * 
 * Rôle : Représente la table "appartenir" en base de données (relation Many-to-Many entre Produit et Categorie)
 * Cette entité utilise une clé primaire composite (AppartenirID)
 */
@Getter // Lombok : Génère automatiquement les méthodes getter pour tous les champs
@Setter // Lombok : Génère automatiquement les méthodes setter pour tous les champs
@Entity // @Entity : Indique que cette classe est une entité JPA (mappée à une table BDD)
@Table(name = "appartenir") // @Table : Spécifie le nom de la table en base de données
public class Appartenir {

    /**
     * Clé primaire composite (composée de produitId et categorieId)
     */
    @EmbeddedId // @EmbeddedId : Indique que la clé primaire est une classe embarquée (AppartenirID)
    private AppartenirID id;

    /**
     * Relation Many-to-One vers l'entité Produit
     */
    @MapsId("produitId") // @MapsId : Indique que cette relation fait partie de la clé primaire (produitId dans AppartenirID)
    @ManyToOne() // @ManyToOne : Plusieurs Appartenir peuvent référencer le même Produit
    @JoinColumn(name = "PR_ID") // @JoinColumn : Spécifie la colonne de jointure en BDD (clé étrangère)
    private Produit produit;

    /**
     * Relation Many-to-One vers l'entité Categorie
     */
    @MapsId("categorieId") // @MapsId : Indique que cette relation fait partie de la clé primaire (categorieId dans AppartenirID)
    @ManyToOne() // @ManyToOne : Plusieurs Appartenir peuvent référencer la même Categorie
    @JoinColumn(name = "CA_ID") // @JoinColumn : Spécifie la colonne de jointure en BDD (clé étrangère)
    private Categorie categorie;

}
