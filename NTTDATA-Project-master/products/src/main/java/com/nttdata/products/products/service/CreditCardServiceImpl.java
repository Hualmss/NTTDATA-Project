package com.nttdata.products.products.service;

import com.nttdata.products.products.feignClients.ClientFeignClient;

import com.nttdata.products.products.feignClients.MovimentFeignClient;

import com.nttdata.products.products.model.CreditCard;
import com.nttdata.products.products.model.Moviments;
import com.nttdata.products.products.repository.CreditCardRepository;
import com.nttdata.products.products.util.BalanceAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nttdata.products.products.util.MovimentType.*;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    private ClientFeignClient clientFeignClient;


    @Autowired
    private MovimentFeignClient movimentFeignClient;

    @Override
    public List<CreditCard> getCreditCards() {
        return creditCardRepository.findAll();
    }

    /**
     * @param creditCard
     */
    @Override
    public void createPersonalCreditCard(CreditCard creditCard) {
        if (clientFeignClient.isPersonalClient(creditCard.getClientId())) {
            creditCardRepository.save(creditCard);
        }
    }

    /**
     * @param creditCard
     */
    @Override
    public void createEnterpriseCreditCard(CreditCard creditCard) {
        if (clientFeignClient.isEnterpriceClient(creditCard.getClientId())) {
            creditCardRepository.save(creditCard);
        }
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
                Moviments mov = new Moviments(id,c.getClientId(),amount, MOVIMENT_CHARGE);
                movimentFeignClient.saveMoviment(mov);
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
            c.setBalance(c.getBalance() - amount);
            creditCardRepository.save(c);
            Moviments mov = new Moviments(id,c.getClientId(),amount, MOVIMENT_PAY);
            movimentFeignClient.saveMoviment(mov);
        });
    }

    /**
     * @param id
     */
    @Override
    public BalanceAvailable checkBalance(long id) {
        BalanceAvailable balanceAvailable = new BalanceAvailable(-1L, 0);
        creditCardRepository.findById(id).ifPresent(c -> {
            balanceAvailable.setId(c.getCreditCardId());
            balanceAvailable.setBalance(c.getLimitBalance() - c.getBalance());
        });
        return balanceAvailable;
    }
}
