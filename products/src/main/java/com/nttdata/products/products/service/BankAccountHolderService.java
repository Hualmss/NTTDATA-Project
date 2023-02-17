package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccountHolder;

public interface BankAccountHolderService {


    /**
     * Save an instance of the BankAccountHolder object
     * @param bankAccountHolder object type BankAccountHolder to save
     * @see BankAccountHolder
     */
    void saveHolder(BankAccountHolder bankAccountHolder);
    

    /**
     * returns all records that have the provided account id
     * @param bankAccountId provided account id
     * @return The list of records that match
     * @see BankAccountHolder
     */
    List<BankAccountHolder> getBankAccountHolders(long bankAccountId);


    /**
     * returns all stored headline records
     * @return The list of records 
     * @see BankAccountHolder
     */
    List<BankAccountHolder> getAllBankAccountHolders();



    /**
     * delete records matching a certain account id and holder id
     * @param clientBankAccountId  holder id
     * @param bankAccountId  account id
     */
    void deleteBankAccountHolder(long clientBankAccountId, long bankAccountId);

}
