package com.nttdata.products.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.products.products.model.BankAccountType;

@Repository
public interface BankAccountTypeRepository extends JpaRepository<BankAccountType, Long>{
    
}
