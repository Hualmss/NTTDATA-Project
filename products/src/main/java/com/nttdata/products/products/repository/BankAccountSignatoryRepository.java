package com.nttdata.products.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.products.products.model.BankAccountSignatory;

@Repository
public interface BankAccountSignatoryRepository extends JpaRepository<BankAccountSignatory, Long>{
    List<BankAccountSignatory> findByBankAccountId(long bankAccountId);
    List<BankAccountSignatory> findByClientBankAccountId(long bankAccountId);
}
