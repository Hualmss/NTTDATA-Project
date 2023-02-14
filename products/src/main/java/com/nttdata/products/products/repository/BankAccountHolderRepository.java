package com.nttdata.products.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.products.products.model.BankAccountHolder;

@Repository
public interface BankAccountHolderRepository extends JpaRepository<BankAccountHolder, Long>{
    List<BankAccountHolder> findByBankAccountId(long bankAccountId);
    List<BankAccountHolder> findByClientBankAccountId(long bankAccountId);
}
