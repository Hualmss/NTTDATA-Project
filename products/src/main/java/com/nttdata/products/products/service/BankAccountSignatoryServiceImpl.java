package com.nttdata.products.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.model.BankAccountSignatory;
import com.nttdata.products.products.repository.BankAccountSignatoryRepository;

@Service
public class BankAccountSignatoryServiceImpl implements BankAccountSignatoryService{

    @Autowired
    private BankAccountSignatoryRepository bankAccountSignatoryRepository;

    @Override
    public void saveSignatory(BankAccountSignatory bankAccountSignatory) {
        bankAccountSignatoryRepository.save(bankAccountSignatory);
        
    }

    @Override
    public List<BankAccountSignatory> getBankAccountSignatory(long bankAccountId) {
        
        return bankAccountSignatoryRepository.findByBankAccountId(bankAccountId);
    }

    @Override
    public List<BankAccountSignatory> getAllBankAccountSignatory() {
        
        return bankAccountSignatoryRepository.findAll();
    }

    @Override
    public void deleteBankAccountSignatory(long clientBankAccountId, long bankAccountId) {
        bankAccountSignatoryRepository.findByClientBankAccountId(clientBankAccountId)
        .stream()
        .filter(holdersAccount -> holdersAccount.getBankAccountId()==bankAccountId)
        .forEach(bankAccountSignatoryRepository::delete);
        
    }

    
}
