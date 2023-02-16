package com.nttdata.products.products.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.feignClients.ClientFeignClient;
import com.nttdata.products.products.feignClients.MovimentFeignClient;
import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.model.Moviments;
import com.nttdata.products.products.repository.BankAccountRepository;

import static com.nttdata.products.products.util.AccountsTypes.CURRENT_ACCOUNT;
import static com.nttdata.products.products.util.MovimentType.MOVIMENT_DEPOSIT;
import static com.nttdata.products.products.util.MovimentType.MOVIMENT_WITHDRAW;;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;


    @Autowired
    private ClientFeignClient clientFeignClient;

    @Autowired
    private MovimentFeignClient movimentFeignClient;


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
        
        //* Verificacion si el cliente esta creando una cuenta de tipo cuenta corriente */
        long holderId = bankAccount.getBankAccountHolderId();
        if( bankAccount.getBankAccountTypeId() == CURRENT_ACCOUNT && clientFeignClient.isEnterpriceClient(bankAccount.getBankAccountClientId()) && holderId!=0){
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

    @Override
    public void deposit(long bankAccountId, double amount){
        
        bankAccountRepository.findById(bankAccountId).ifPresentOrElse(bankAccount -> {
            double currentBalance = bankAccount.getBalance();
            bankAccount.setBalance(currentBalance + amount); 
            bankAccountRepository.save(bankAccount);
            movimentFeignClient.saveMoviment(new Moviments(bankAccountId,bankAccount.getBankAccountClientId(),amount, MOVIMENT_DEPOSIT) );
        },
        ()->{
            System.out.println("account not found");
        });
    }


    @Override
    public void withdraw(long bankAccountId, double amount){
        bankAccountRepository.findById(bankAccountId).ifPresentOrElse(bankAccount -> {
            double currentBalance = bankAccount.getBalance();
            if(currentBalance>=amount){
                bankAccount.setBalance(currentBalance-amount);        
                bankAccountRepository.save(bankAccount);
                Moviments mov = new Moviments(bankAccountId,bankAccount.getBankAccountClientId(),amount, MOVIMENT_WITHDRAW);
                movimentFeignClient.saveMoviment(mov);
            }else{
                System.out.println("Non Sufficient Fund");
            }
        },
        ()->{
            System.out.println("account not found");
        });
    }

    /**
     * TODO:to check the number of moves we need to get this answer from another MS
     * ? Se tiene que ver el mes y cotejar la cantidad demovimientos devueltos en un determinado mes y cotejar con los movimientos permitidos en el tipo de cuenta  
     */
    public boolean verifyMovements(){
        return true;
    }
    
}
