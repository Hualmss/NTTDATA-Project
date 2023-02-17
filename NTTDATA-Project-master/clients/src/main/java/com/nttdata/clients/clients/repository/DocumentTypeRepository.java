package com.nttdata.clients.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.clients.clients.model.DocumentType;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    
}   
