package com.cda.boutique.dtos;

public record ClientDTO(
    String nom,
    String prenom,
    String ville,
    String codePostal,
    String adresse,
    String email,
    String telephone
){}
