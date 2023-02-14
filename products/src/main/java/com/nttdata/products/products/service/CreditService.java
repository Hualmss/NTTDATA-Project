package com.nttdata.products.products.service;

import com.nttdata.products.products.model.Credit;

import java.util.List;

public interface CreditService {
    List<Credit> getCredits();
    void createCredit(Credit credit);
    void editCredit(long id, Credit credit);
    void pay(long id, double amount);
}
