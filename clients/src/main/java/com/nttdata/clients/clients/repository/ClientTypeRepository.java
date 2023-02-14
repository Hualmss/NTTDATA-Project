package com.nttdata.clients.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.clients.clients.model.ClientType;

@Repository

public interface ClientTypeRepository extends JpaRepository<ClientType, Long>{
    
}
