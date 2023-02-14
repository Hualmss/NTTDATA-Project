package com.nttdata.products.products.service;

import com.nttdata.products.products.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getCreditCards();
    void saveCreditCard(CreditCard creditCard);
    void chargeAmount(long id, double amount);
    void pay(long id, double amount);
    String checkBalance(long id);
}
