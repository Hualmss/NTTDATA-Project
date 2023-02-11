package com.nttdata.products.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.products.products.model.BankAccountType;
import com.nttdata.products.products.service.BankAccountTypeService;

@RestController
@RequestMapping(value = "bankAccountsTypes")
public class BankAccountTypeController {

    @Autowired
    BankAccountTypeService bankAccountTypeService;
    
    @GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccountType>> getBankAccountsTypes(){
        return new ResponseEntity<>(bankAccountTypeService.getBankAccountTypes(), HttpStatus.OK);
    }


    
}
