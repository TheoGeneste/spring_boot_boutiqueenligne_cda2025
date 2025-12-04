package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.entites.Client;
import com.cda.boutique.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;

    public List<Client> findAll(){
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public Client find(Integer id){
        Client client = null;
        if (clientRepository.findById(id).isPresent()) {
            client = clientRepository.findById(id).get();
        }
        return client;
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public void remove(Integer id){
        clientRepository.deleteById(id);
    }

    
}
