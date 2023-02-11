package com.nttdata.products.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;



    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public void saveBankAccount(BankAccount account) {
        bankAccountRepository.save(account);
        
    }

    @Override
    public void deleteBankAccount(long id) {
        bankAccountRepository.deleteById(id);

        
    }

    @Override
    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
        
    }

    @Override
    public BankAccount getBankAccountById(long id) {
        
        return bankAccountRepository.findById(id).orElseThrow();
    }
    
}
