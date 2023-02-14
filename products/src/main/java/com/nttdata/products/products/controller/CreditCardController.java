package com.nttdata.products.products.controller;

import com.nttdata.products.products.model.CreditCard;
import com.nttdata.products.products.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping(value = "creditCards", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getCreditCards() {
        return creditCardService.getCreditCards();
    }

    @PostMapping(value = "creditCards", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void saveCreditCard(@RequestBody CreditCard creditCard) {
        creditCardService.saveCreditCard(creditCard);
    }

    @PutMapping(value = "creditCards/charge/{id}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void chargeAmount(@PathVariable("id") long id, @PathVariable("amount") double amount) {
        creditCardService.chargeAmount(id, amount);
    }

    @PatchMapping(value = "creditCards/pay/{id}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void pay(@PathVariable("id") long id, @PathVariable("amount") double amount) {
        creditCardService.pay(id, amount);
    }

}
