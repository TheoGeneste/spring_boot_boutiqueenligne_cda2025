package com.cda.boutique.dtos;

import com.cda.boutique.entites.Paiement;

public record  CommandeResponseClientDTO(
    Integer id,
    Paiement paiement
) {
    
}
