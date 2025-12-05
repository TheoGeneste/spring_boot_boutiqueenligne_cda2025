package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.ClientRequestDTO;
import com.cda.boutique.dtos.ClientResponseDTO;
import com.cda.boutique.entites.Client;
import com.cda.boutique.mappers.ClientMapper;
import com.cda.boutique.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientResponseDTO> findAll(){
        List<Client> clients = clientRepository.findAll();
        return clientMapper.toDTO(clients);
    }

    public ClientResponseDTO find(Integer id){
        Client client = null;
        if (clientRepository.findById(id).isPresent()) {
            client = clientRepository.findById(id).get();
        }
        return clientMapper.toDTO(client);
    }

    public void update(Integer id, ClientRequestDTO client){
        Client clientToUpdate = clientMapper.toEntity(client);
        clientToUpdate.setId(id);
        clientRepository.save(clientToUpdate);
    }

    
    public void save(ClientRequestDTO client){
        clientRepository.save(clientMapper.toEntity(client));
    }

    public void remove(Integer id){
        clientRepository.deleteById(id);
    }

    
}
