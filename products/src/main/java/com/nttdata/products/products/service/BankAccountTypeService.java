package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccountType;

public interface BankAccountTypeService {
    
    List<BankAccountType> getBankAccountTypes();

    BankAccountType  getBankAccountType(long id);

    void saveBankAccountType(BankAccountType bankAccountType);

    BankAccountType  updateBankAccountType(BankAccountType bankAccountType);

    List<BankAccountType> deleteBankAccountType(long id);


}
