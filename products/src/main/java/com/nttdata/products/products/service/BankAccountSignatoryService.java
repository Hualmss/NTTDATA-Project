package com.nttdata.products.products.service;

import java.util.List;

import com.nttdata.products.products.model.BankAccountSignatory;

public interface BankAccountSignatoryService {
    

  /**
     * Save an instance of the BankAccountSignatory object
     * @param bankAccountSignatory object type BankAccountSignatory to save
     * @see BankAccountSignatory
     */
    void saveSignatory(BankAccountSignatory bankAccountSignatory);
    

 /**
     * returns all records that have the provided account id
     * @param bankAccountId provided account id
     * @return The list of records that match
     * @see BankAccountSignatory
     */
    List<BankAccountSignatory> getBankAccountSignatory(long bankAccountId);

    /**
     * returns all stored signer records
     * @return The list of records 
     * @see BankAccountSignatory
     */
    List<BankAccountSignatory> getAllBankAccountSignatory();



    /**
     * delete records matching a certain account id and signer id
     * @param clientBankAccountId  signer id
     * @param bankAccountId  account id
     */
    void deleteBankAccountSignatory(long clientBankAccountId, long bankAccountId);

}
