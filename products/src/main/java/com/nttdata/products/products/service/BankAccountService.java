package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.util.BalanceAvailable;

public interface BankAccountService {


     /**
     * returns all stored bank account records
     * @return The list of records that match
     * @see BankAccount
     */
    List<BankAccount> getBankAccounts();

    /**
     * Save an instance of the Bank Account object for business customers
     * @param account bankAccount instance
     * @see BankAccount
     */
    void saveEnterpriceBankAccount(BankAccount account);

   /**
     * Save an instance of the Bank Account object for personal customers
     * @param account bankAccount instance
     * @see BankAccount
     */
    void savePersonalBankAccount(BankAccount account);

    /**
     * removes the registration of a bank account based on its id
     * @param id bankAccount id
     */
    void deleteBankAccount(long id);

    /**
     * update a bank account
     * @param BankAccount bankAccount object
     * @return updated bank account instance
     * @see BankAccount
     */
    BankAccount updateBankAccount(BankAccount bankAccount);

     /**
     * returns a bank account based on its id
     * @param id bankAccount id
     * @return  bank account instance
     * @see BankAccount
     */
    BankAccount getBankAccountById(long id);

       /**
     * returns a bank account based on client id
     * @param id client id
     * @return  the list of records that match
     * @see BankAccount
     */
    List<BankAccount> getBankAccountByclientId(long id);



    /**
     * increase the balance of a bank account
     * @param bankAccountId bankAccount id
     * @param amount amount to increase
     */
    void deposit(long bankAccountId, double amount);

    /**
     * decreases the balance of a bank account
     * @param bankAccountId bankAccount id
     * @param amount amount to increase
     */
    void withdraw(long bankAccountId, double amount);

     /**
     * returns the total balance of a bank account
     * @param bankAccountId bankAccount id
     * @return total balance of a bank account
     * @see BalanceAvailable
     * 
     */
    BalanceAvailable checkBalance(long bankAccountId);

}
