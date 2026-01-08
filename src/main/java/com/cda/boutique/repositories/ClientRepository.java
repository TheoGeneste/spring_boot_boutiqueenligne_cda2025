package com.cda.boutique.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cda.boutique.entites.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT * FROM clients", nativeQuery = true)
    List<Client> test();

    @Query(value = "SELECT c from Client c ", nativeQuery = false)
    List<Client> test2();

    @Query(value = "SELECT * FROM clients Where CL_ID = :id", nativeQuery = true)
    Client testById(@Param("id") Integer id);

    @Query(value = "SELECT c from Client c WHERE c.id = :id", nativeQuery = false)
    Client testById2(@Param("id") Integer id);
}
