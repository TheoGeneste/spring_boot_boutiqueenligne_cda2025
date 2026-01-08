package com.cda.boutique.dtos;

import java.math.BigDecimal;

public record ProduitRequestDTO(
        String nom,
        String description,
        BigDecimal prix,
        Integer stock) {

}
