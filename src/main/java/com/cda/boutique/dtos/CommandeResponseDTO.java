package com.cda.boutique.dtos;

import com.cda.boutique.entites.Client;
import com.cda.boutique.entites.Paiement;

public record  CommandeResponseDTO(
    Integer id,
    Client client,
    Paiement paiement
) {
    
}
