package com.cda.boutique.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PaiementResponseDTO(
    Integer id,
    BigDecimal montant,
    LocalDate date,
    String method,
    List<CommandeResponsePaiementDTO> commandes
) {

}
