package com.nttdata.products.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.repository.BankAccountRepository;

@Service
public class BankAccountImpl implements BankAccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> getBankAccounts() {
        
        return bankAccountRepository.findAll();
    }

    @Override
    public boolean saveBankAccount(BankAccount account) {
        bankAccountRepository.save(account);
        return true;
    }
    
}
