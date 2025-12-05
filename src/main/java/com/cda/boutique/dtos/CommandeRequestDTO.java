package com.cda.boutique.dtos;

import com.cda.boutique.entites.Client;
import com.cda.boutique.entites.Paiement;

public record  CommandeRequestDTO(
    Client client,
    Paiement paiement
) {
    
}
