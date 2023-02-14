package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccount;

public interface BankAccountService {
    
    List<BankAccount> getBankAccounts();

    void saveEnterpriceBankAccount(BankAccount account);

    void savePersonalBankAccount(BankAccount account);

    void deleteBankAccount(long id);

    BankAccount updateBankAccount(BankAccount bankAccount);

    BankAccount getBankAccountById(long id);

}
