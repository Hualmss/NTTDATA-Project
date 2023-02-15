package com.nttdata.products.products.service;

import com.nttdata.products.products.model.CreditCard;
import com.nttdata.products.products.util.BalanceAvailable;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getCreditCards();
    void createPersonalCreditCard(CreditCard creditCard);
    void createEnterpriseCreditCard(CreditCard creditCard);
    void chargeAmount(long id, double amount);
    void pay(long id, double amount);
    BalanceAvailable checkBalance(long id);
}
