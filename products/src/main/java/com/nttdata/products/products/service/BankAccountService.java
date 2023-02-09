package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccount;

public interface BankAccountService {
    
    List<BankAccount> getBankAccounts();

    boolean saveBankAccount(BankAccount account);
}
