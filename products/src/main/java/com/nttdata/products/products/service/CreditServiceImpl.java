package com.nttdata.products.products.service;

import com.nttdata.products.products.feignClients.ClientFeignClient;
import com.nttdata.products.products.model.Credit;
import com.nttdata.products.products.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService{
    @Autowired
    CreditRepository creditRepository;

    @Autowired
    private ClientFeignClient clientFeignClient;

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
    public void createPersonalCredit(Credit credit) {
        boolean isPersonalClient = clientFeignClient.isPersonalClient(credit.getClientId());
        List<Credit> search = creditRepository.findByClientId(credit.getClientId());

        if (isPersonalClient && search.isEmpty()) {
            creditRepository.save(credit);
        }
    }

    /**
     * @param credit
     */
    @Override
    public void createBusinessCredit(Credit credit) {
        if (clientFeignClient.isEnterpriceClient(credit.getClientId())) {
            creditRepository.save(credit);
        }
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
            c.setBalance(c.getBalance() - amount);
            creditRepository.save(c);
        });
    }
}
