package com.nttdata.products.products.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.feignClients.ClientFeignClient;
import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.repository.BankAccountRepository;

import static com.nttdata.products.products.util.AccountsTypes.CURRENT_ACCOUNT;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;


    @Autowired
    private ClientFeignClient clientFeignClient;



    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public void saveEnterpriceBankAccount(BankAccount bankAccount) {
        //Si es cliente personal puede crear cualquier tipo de cuenta
        //si es cliente empresarial solo puede crear cuentas corriente
        //un cliente personal solo puede tener una de las 3 cuentas
        
        //whether or not the aforementioned account is a business account
        
        //TODO:verificar si el cliente es empresarial consutando una api en el MS cliente
        //* Verificacion si el cliente esta creando una cuenta de tipo cuenta corriente */
        if( bankAccount.getBankAccountTypeId() == CURRENT_ACCOUNT && clientFeignClient.isEnterpriceClient(bankAccount.getBankAccountClientId())){
            bankAccountRepository.save(bankAccount);
        }
        
        
    }

    @Override
    public void savePersonalBankAccount(BankAccount account){
        
        //TODO: verificar si el cliente es tipo personal desde el MS, consultando una API
        //** Verificacion de que el cliente no tiene una cuenta ya creada, de forma tal que no pueda crear otra
        long clientId = account.getBankAccountClientId();
        if(bankAccountRepository.findByBankAccountClientId(clientId).isEmpty() && clientFeignClient.isPersonalClient(clientId)){
            bankAccountRepository.save(account);
        }
    }

    @Override
    public void deleteBankAccount(long id) {
        bankAccountRepository.deleteById(id);

        
    }

    @Override
    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
        
    }

    @Override
    public BankAccount getBankAccountById(long id) {
        
        return bankAccountRepository.findById(id).orElseThrow();
    }
    
}
