package com.nttdata.products.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.products.products.model.BankAccountType;

public interface BankAccountTypeRepository extends JpaRepository<BankAccountType, Long>{
    
}
