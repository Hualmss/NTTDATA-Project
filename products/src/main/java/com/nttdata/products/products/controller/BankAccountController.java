package com.nttdata.products.products.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.model.BankAccountHolder;
import com.nttdata.products.products.model.BankAccountSignatory;
import com.nttdata.products.products.service.BankAccountHolderService;
import com.nttdata.products.products.service.BankAccountService;
import com.nttdata.products.products.service.BankAccountSignatoryService;
import com.nttdata.products.products.util.BalanceAvailable;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "bankAccounts")
public class BankAccountController {
    

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankAccountHolderService bankAccountHolderService;

    @Autowired
    private BankAccountSignatoryService bankAccountSignatoryService;



    @GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccount>> getBankAccounts(){
        return new ResponseEntity<>(bankAccountService.getBankAccounts(), HttpStatus.OK);
    }

    @GetMapping(value="client/{clientId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccount>> getBankAccountsByClientId(@PathVariable long clientId){
        return new ResponseEntity<>(bankAccountService.getBankAccountByclientId(clientId), HttpStatus.OK);
    }

    @GetMapping(value="checkBalance/{accountId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public BalanceAvailable checkBalance(@PathVariable long accountId){
        return bankAccountService.checkBalance(accountId);
    }


    @GetMapping(value = "/enterpriceClient/holder/{accountId}", produces =MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountHolder> getAllBankAccountHolders(@PathVariable long accountId){
        return bankAccountHolderService.getBankAccountHolders(accountId);
    }

    @PostMapping(value = "/enterpriceClient/holder", consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountHolder> saveHolderEnterpriceBankAccount(@RequestBody BankAccountHolder bankAccountholder){
        bankAccountHolderService.saveHolder(bankAccountholder);
        return bankAccountHolderService.getAllBankAccountHolders();
    }

    
    @DeleteMapping(value = "/enterpriceClient/holder/{accountId}/{holderId}")
    public List<BankAccountHolder> deleteHolderEnterpriceBankAccount(@PathVariable("accountId") long accountId,@PathVariable("holderId") long holderId ){
        bankAccountHolderService.deleteBankAccountHolder( holderId,accountId);
        return bankAccountHolderService.getAllBankAccountHolders();
    }


    @GetMapping(value = "/enterpriceClient/signatory/{accountId}", produces =MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountSignatory> getAllBankAccountSignatories(@PathVariable long accountId){
        return bankAccountSignatoryService.getBankAccountSignatory(accountId);
    }

    @PostMapping(value = "/enterpriceClient/signatory", consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountSignatory> saveSignatoryEnterpriceBankAccount(@RequestBody BankAccountSignatory bankAccountholder){
        bankAccountSignatoryService.saveSignatory(bankAccountholder);
        return bankAccountSignatoryService.getAllBankAccountSignatory();
    }

    
    @DeleteMapping(value = "/enterpriceClient/signatory/{accountId}/{holderId}")
    public List<BankAccountSignatory> deleteSignatoryEnterpriceBankAccount(@PathVariable("accountId") long accountId,@PathVariable("holderId") long holderId ){
        bankAccountSignatoryService.deleteBankAccountSignatory( holderId,accountId);
        return bankAccountSignatoryService.getAllBankAccountSignatory();
    }

    @PostMapping(value = "/enterpriceClient", consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccount> saveEnterpriceBankAccount(@RequestBody BankAccount bankAccount){
        bankAccountService.saveEnterpriceBankAccount(bankAccount);
        return bankAccountService.getBankAccounts();
    }
    @PostMapping(value = "/personalClient", consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccount> saveBankAccount(@RequestBody BankAccount bankAccount){
        bankAccountService.savePersonalBankAccount(bankAccount);
        return bankAccountService.getBankAccounts();
    }


    @PutMapping(value = "/deposit/{bankAccountId}/{ammout}")
    public BankAccount deposit(@PathVariable ("bankAccountId")long bankAccountId, @PathVariable ("ammout")double ammout){
        bankAccountService.deposit(bankAccountId, ammout);
        return bankAccountService.getBankAccountById(bankAccountId);
    }

    @PutMapping(value = "/withdraw/{bankAccountId}/{ammout}")
    public BankAccount withdraw(@PathVariable ("bankAccountId")long bankAccountId, @PathVariable ("ammout")double ammout){
        bankAccountService.withdraw(bankAccountId, ammout);
        return bankAccountService.getBankAccountById(bankAccountId);
    }

    @PutMapping(value = "/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
    public BankAccount updateBankAccount(@PathVariable long id,@RequestBody BankAccount bankAccount ){
        if(bankAccountService.getBankAccountById(id)==null) {
            return null;
        }
        return bankAccountService.updateBankAccount(bankAccount);
    } 



    @DeleteMapping(value ="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccount> deleteBankAccount(@PathVariable long id){
        if(bankAccountService.getBankAccountById(id)== null){
            return null;    
            
        }
        bankAccountService.deleteBankAccount(id);
        return bankAccountService.getBankAccounts();
        
    }
}

