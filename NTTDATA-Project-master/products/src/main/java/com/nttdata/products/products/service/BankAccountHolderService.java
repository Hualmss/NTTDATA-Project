package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccountHolder;

public interface BankAccountHolderService {

    void saveHolder(BankAccountHolder bankAccountHolder);
    
    List<BankAccountHolder> getBankAccountHolders(long bankAccountId);

    List<BankAccountHolder> getAllBankAccountHolders();

    void deleteBankAccountHolder(long clientBankAccountId, long bankAccountId);

}
