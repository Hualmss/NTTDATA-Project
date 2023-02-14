package com.nttdata.products.products.service;

import com.nttdata.products.products.model.Credit;
import com.nttdata.products.products.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService{
    @Autowired
    CreditRepository creditRepository;

    /**
     * @return list of all credits
     */
    @Override
    public List<Credit> getCredits() {
        return creditRepository.findAll();
    }

    /**
     * @param credit 
     */
    @Override
    public void createCredit(Credit credit) {
        creditRepository.save(credit);
    }

    /**
     * @param id
     * @param credit
     */
    @Override
    public void editCredit(long id, Credit credit) {
        creditRepository.findById(id).ifPresent(c -> creditRepository.save(credit));
    }

    /**
     * @param id
     * @param amount
     */
    @Override
    public void pay(long id, double amount) {
        creditRepository.findById(id).ifPresent(c -> {
            c.setBalance(c.getBalance() + amount);
            creditRepository.save(c);
        });
    }
}
