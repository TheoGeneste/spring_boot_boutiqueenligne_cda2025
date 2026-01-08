package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cda.boutique.dtos.ContenirRequestDTO;
import com.cda.boutique.dtos.ContenirResponseDTO;
import com.cda.boutique.entites.Contenir;

@Mapper(componentModel="spring")
public interface ContenirMapper {
    
    ContenirResponseDTO toDTO(Contenir contenir);
    List<ContenirResponseDTO> toDTO(List<Contenir> contenir);
    
    Contenir toEntity(ContenirRequestDTO contenirRequestDTO);
}
