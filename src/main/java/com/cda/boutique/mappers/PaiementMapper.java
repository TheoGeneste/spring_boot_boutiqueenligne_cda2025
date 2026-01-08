package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cda.boutique.dtos.CommandeResponsePaiementDTO;
import com.cda.boutique.dtos.PaiementRequestDTO;
import com.cda.boutique.dtos.PaiementResponseDTO;
import com.cda.boutique.entites.Commande;
import com.cda.boutique.entites.Paiement;

@Mapper(componentModel="spring")
public interface PaiementMapper {
    
    PaiementResponseDTO toDTO(Paiement paiement);
    List<PaiementResponseDTO> toDTO(List<Paiement> paiement);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "commandes", ignore = true)
    Paiement toEntity(PaiementRequestDTO dto);
    
    CommandeResponsePaiementDTO commandeToDTO(Commande commande);
    List<CommandeResponsePaiementDTO> commandeToDTO(List<Commande> commandes);
}

