package com.cda.boutique.dtos;

import java.math.BigDecimal;

public record ProduitDTO(
        Integer id,
        String nom,
        String description,
        BigDecimal prix,
        Integer stock) {

}
