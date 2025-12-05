package com.cda.boutique.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cda.boutique.dtos.ClientRequestDTO;
import com.cda.boutique.dtos.ClientResponseDTO;
import com.cda.boutique.entites.Client;


@Mapper(componentModel= "spring")
public interface ClientMapper {
    ClientResponseDTO toDTO(Client client);
    List<ClientResponseDTO> toDTO(List<Client> client);

    Client toEntity(ClientRequestDTO dto);
}
