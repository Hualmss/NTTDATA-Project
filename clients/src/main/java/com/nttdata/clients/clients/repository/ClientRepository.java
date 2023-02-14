package com.nttdata.clients.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.clients.clients.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
