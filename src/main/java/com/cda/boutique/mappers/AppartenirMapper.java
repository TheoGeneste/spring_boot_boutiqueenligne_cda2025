package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cda.boutique.dtos.AppartenirRequestDTO;
import com.cda.boutique.dtos.AppartenirResponseDTO;
import com.cda.boutique.entites.Appartenir;

@Mapper(componentModel="spring")
public interface AppartenirMapper {
    
    AppartenirResponseDTO toDTO(Appartenir appartenir);
    List<AppartenirResponseDTO> toDTO(List<Appartenir> appartenir);

    Appartenir toEntity(AppartenirRequestDTO appartenirRequestDTO);
}
