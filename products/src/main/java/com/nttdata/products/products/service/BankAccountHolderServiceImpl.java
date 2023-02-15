package com.nttdata.products.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.model.BankAccountHolder;
import com.nttdata.products.products.repository.BankAccountHolderRepository;

@Service
public class BankAccountHolderServiceImpl implements BankAccountHolderService{

    @Autowired
    private BankAccountHolderRepository bankAccountHolderRepository;

    @Override
    public void saveHolder(BankAccountHolder bankAccountHolder) {
        bankAccountHolderRepository.save(bankAccountHolder);
    }

    @Override
    public List<BankAccountHolder> getBankAccountHolders(long bankAccountId) {
        return bankAccountHolderRepository.findByBankAccountId(bankAccountId);
    }

    @Override
    public void deleteBankAccountHolder(long clientBankAccountId, long bankAccountId) {
        bankAccountHolderRepository.findByClientBankAccountId(clientBankAccountId)
        .stream()
        .filter(holdersAccount -> holdersAccount.getBankAccountId()==bankAccountId)
        .forEach(bankAccountHolderRepository::delete);
    }

    @Override
    public List<BankAccountHolder> getAllBankAccountHolders(){
        return bankAccountHolderRepository.findAll();
    }
}
