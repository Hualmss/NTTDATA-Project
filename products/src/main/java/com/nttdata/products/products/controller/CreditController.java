package com.nttdata.products.products.controller;

import com.nttdata.products.products.model.Credit;
import com.nttdata.products.products.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "credits")
public class CreditController {
    @Autowired
    CreditService creditService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Credit> getCredits() {
        return creditService.getCredits();
    }

    @PostMapping(value = "createPersonalCredit", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createPersonalCredit(@RequestBody Credit credit) {
        creditService.createPersonalCredit(credit);
    }

    @PostMapping(value = "createEnterpriseCredit", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createEnterpriseCredit(@RequestBody Credit credit) {
        creditService.createBusinessCredit(credit);
    }

    @PutMapping(value = "edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editCredit(@PathVariable("id") long id, @RequestBody Credit credit) {
        creditService.editCredit(id, credit);
    }

    @PatchMapping(value = "pay/{id}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void pay(@PathVariable("id") long id, @PathVariable("amount") double amount) {
        creditService.pay(id, amount);
    }

}
