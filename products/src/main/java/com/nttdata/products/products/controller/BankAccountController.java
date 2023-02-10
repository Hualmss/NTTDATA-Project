package com.nttdata.products.products.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.service.BankAccountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class BankAccountController {
    

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping(value="bankAccounts", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccount>> getBankAccounts(){
        return new ResponseEntity<>(bankAccountService.getBankAccounts(), HttpStatus.OK);
    }


    @PostMapping(value = "bankAccounts", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void saveBankAccount(@RequestBody BankAccount bankAccount){


        bankAccountService.saveBankAccount(bankAccount);
    }



}

