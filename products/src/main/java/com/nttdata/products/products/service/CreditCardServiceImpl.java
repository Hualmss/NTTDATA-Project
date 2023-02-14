package com.nttdata.products.products.service;

import com.nttdata.products.products.model.CreditCard;
import com.nttdata.products.products.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public List<CreditCard> getCreditCards() {
        return creditCardRepository.findAll();
    }

    /**
     * @param creditCard
     */
    @Override
    public void saveCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

    /**
     * @param id
     * @param amount
     */
    @Override
    public void chargeAmount(long id, double amount) {
        creditCardRepository.findById(id).ifPresent(c -> {
            double balance = c.getBalance() + amount;
            if (balance <= c.getLimitBalance()) {
                c.setBalance(balance);
                creditCardRepository.save(c);
            }
        });
    }

    /**
     * @param id
     * @param amount
     */
    @Override
    public void pay(long id, double amount) {

        creditCardRepository.findById(id).ifPresent(c -> {
            //LocalDate date = LocalDate.from(Instant.now());
            //boolean penalty = date.isAfter(c.getPaymentDate());
            c.setBalance(c.getBalance() - amount);
            creditCardRepository.save(c);
        });
    }

    /**
     * @param id
     */
    @Override
    public String checkBalance(long id) {
        CreditCard creditCard = creditCardRepository.findById(id).orElse(null);
        assert creditCard != null;
        return ""+ (creditCard.getLimitBalance() - creditCard.getBalance());
    }
}
