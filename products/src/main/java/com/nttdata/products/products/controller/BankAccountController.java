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
import com.nttdata.products.products.service.BankAccountHolderService;
import com.nttdata.products.products.service.BankAccountService;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "bankAccounts")
public class BankAccountController {
    

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    BankAccountHolderService bankAccountHolderService;



    @GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccount>> getBankAccounts(){
        return new ResponseEntity<>(bankAccountService.getBankAccounts(), HttpStatus.OK);
    }



    @PostMapping(value = "/enterpriceClient/holder", consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountHolder> saveHolderEnterpriceBankAccount(@RequestBody BankAccountHolder bankAccountholder){
        bankAccountHolderService.saveHolder(bankAccountholder);
        return bankAccountHolderService.getAllBankAccountHolders();
    }

    @GetMapping(value = "/enterpriceClient/holder", produces =MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountHolder> getAllBankAccountHolders(){
        return bankAccountHolderService.getAllBankAccountHolders();
    }
    @DeleteMapping(value = "/enterpriceClient/holder/{accountId}/{holderId}")
    public List<BankAccountHolder> deleteHolderEnterpriceBankAccount(@PathVariable("accountId") long accountId,@PathVariable("holderId") long holderId ){
        bankAccountHolderService.deleteBankAccountHolder( holderId,accountId);
        return bankAccountHolderService.getAllBankAccountHolders();
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

