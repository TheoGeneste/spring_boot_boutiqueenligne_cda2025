package com.cda.boutique.dtos;

import ch.qos.logback.core.net.server.Client;

public record  CommandeResponsePaiementDTO(
    Integer id,
    Client client
) {
    
}
