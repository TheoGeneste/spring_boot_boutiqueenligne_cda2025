package com.cda.boutique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.boutique.entites.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
