package com.nttdata.products.products.controller;

import com.nttdata.products.products.model.Credit;
import com.nttdata.products.products.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditController {
    @Autowired
    CreditService creditService;

    @GetMapping(value = "credits", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> getCredits() {
        return creditService.getCredits();
    }

    @PostMapping(value = "credits", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void saveCredit(@RequestBody Credit credit) {
        creditService.createCredit(credit);
    }

}
