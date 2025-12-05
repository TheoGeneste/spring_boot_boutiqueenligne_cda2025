package com.cda.boutique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.boutique.dtos.CommandeRequestDTO;
import com.cda.boutique.dtos.CommandeResponseDTO;
import com.cda.boutique.entites.Commande;
import com.cda.boutique.mappers.CommandeMapper;
import com.cda.boutique.repositories.CommandeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeMapper commandeMapper;

    public List<CommandeResponseDTO> findAll() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandeMapper.toDTO(commandes);
    }

    public CommandeResponseDTO find(Integer id) {
        Commande commande = null;
        if (commandeRepository.findById(id).isPresent()) {
            commande = commandeRepository.findById(id).get();
        }
        return commandeMapper.toDTO(commande);
    }

    public void update(Integer id, CommandeRequestDTO commande) {
        Commande commandeToUpdate = commandeMapper.toEntity(commande);
        commandeToUpdate.setId(id);
        commandeRepository.save(commandeToUpdate);
    }

    public void save(CommandeRequestDTO commande) {
        commandeRepository.save(commandeMapper.toEntity(commande));
    }

    public void remove(Integer id) {
        commandeRepository.deleteById(id);
    }
}
