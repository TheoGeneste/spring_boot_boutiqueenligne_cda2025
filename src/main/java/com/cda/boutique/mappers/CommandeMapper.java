package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cda.boutique.dtos.CommandeRequestDTO;
import com.cda.boutique.dtos.CommandeResponseDTO;
import com.cda.boutique.entites.Commande;

@Mapper(componentModel= "spring")
public interface CommandeMapper {
    CommandeResponseDTO toDTO(Commande commande);
    List<CommandeResponseDTO> toDTO(List<Commande> commande);

    Commande toEntity(CommandeRequestDTO dto);
}
