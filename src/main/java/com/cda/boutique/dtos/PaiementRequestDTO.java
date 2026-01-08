package com.cda.boutique.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaiementRequestDTO(
        BigDecimal montant,
        LocalDate date,
        String method
        ) {

}
