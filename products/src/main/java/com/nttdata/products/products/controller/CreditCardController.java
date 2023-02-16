package com.nttdata.products.products.controller;

import com.nttdata.products.products.model.CreditCard;
import com.nttdata.products.products.service.CreditCardService;
import com.nttdata.products.products.util.BalanceAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "creditCards")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getCreditCards() {
        return creditCardService.getCreditCards();
    }

    @PostMapping(value = "/createPersonalCreditCard", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createPersonalCreditCard(@RequestBody CreditCard creditCard) {
        creditCardService.createPersonalCreditCard(creditCard);
    }

    @PostMapping(value = "/createEnterpriseCreditCard", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createEnterpriseCreditCard(@RequestBody CreditCard creditCard) {
        creditCardService.createEnterpriseCreditCard(creditCard);
    }

    @PutMapping(value = "/charge/{id}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void chargeAmount(@PathVariable("id") long id, @PathVariable("amount") double amount) {
        creditCardService.chargeAmount(id, amount);
    }

    @PatchMapping(value = "/pay/{id}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void pay(@PathVariable("id") long id, @PathVariable("amount") double amount) {
        creditCardService.pay(id, amount);
    }

    @GetMapping(value="/checkBalance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BalanceAvailable checkBalance(@PathVariable("id") long id) {
        return creditCardService.checkBalance(id);
    }
}
