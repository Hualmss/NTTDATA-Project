package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccountSignatory;

public interface BankAccountSignatoryService {
    
    void saveSignatory(BankAccountSignatory bankAccountSignatory);
    
    List<BankAccountSignatory> getBankAccountSignatory(long bankAccountId);

    List<BankAccountSignatory> getAllBankAccountSignatory();

    void deleteBankAccountSignatory(long clientBankAccountId, long bankAccountId);

}
