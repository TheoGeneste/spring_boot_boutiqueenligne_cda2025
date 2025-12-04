package com.cda.boutique.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CL_ID")
    private Integer id;

    @Column(name = "CL_Nom", nullable = false)
    private String nom;

    @Column(name="CL_Prenom", nullable=false)
    private String prenom;

    @Column(name="CL_Ville")
    private String ville;

    @Column(name="CL_CodePostal", length=5)
    private String codePostal;

    @Column(name="CL_Adresse")
    private String adresse;

    @Column(name="CL_Email", nullable=false, unique=true)
    private String email;

    @Column(name="CL_Telephone", nullable=false, unique=true, length=10)
    private String telephone;

}
