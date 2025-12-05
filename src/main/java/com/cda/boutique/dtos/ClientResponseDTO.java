package com.cda.boutique.dtos;

import java.util.List;

public record ClientResponseDTO(
    Integer id,
    String nom,
    String prenom,
    String ville,
    String codePostal,
    String adresse,
    String email,
    String telephone,
    List<CommandeResponseClientDTO> commandes
){}
