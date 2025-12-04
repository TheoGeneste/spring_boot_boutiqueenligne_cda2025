package com.cda.boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.boutique.entites.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
    
}
