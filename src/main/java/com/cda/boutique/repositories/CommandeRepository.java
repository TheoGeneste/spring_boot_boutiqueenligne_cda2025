package com.cda.boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.boutique.entites.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer>  {
    
}
