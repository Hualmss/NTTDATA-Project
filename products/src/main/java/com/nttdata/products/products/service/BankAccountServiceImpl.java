package com.nttdata.products.products.service;

import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.feignClients.ClientFeignClient;
import com.nttdata.products.products.feignClients.MovimentFeignClient;
import com.nttdata.products.products.model.BankAccount;

import com.nttdata.products.products.model.MovementDate;
import com.nttdata.products.products.model.Moviments;
import com.nttdata.products.products.repository.BankAccountRepository;
import com.nttdata.products.products.repository.MovementDateRepository;
import com.nttdata.products.products.util.BalanceAvailable;

import static com.nttdata.products.products.util.AccountsTypes.CURRENT_ACCOUNT;
import static com.nttdata.products.products.util.AccountsTypes.FIXED_TERM_ACCOUNT;
import static com.nttdata.products.products.util.AccountsTypes.SAVINGS_ACCOUNT;

import static com.nttdata.products.products.util.MovimentType.MOVIMENT_DEPOSIT;
import static com.nttdata.products.products.util.MovimentType.MOVIMENT_WITHDRAW;;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private MovementDateRepository movementDateRepository;

    @Autowired
    private ClientFeignClient clientFeignClient;

    @Autowired
    private MovimentFeignClient movimentFeignClient;

    @Autowired
    private BankAccountTypeService bankAccountTypeService;

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public void saveEnterpriceBankAccount(BankAccount bankAccount) {

        
        //* Verificacion si el cliente esta creando una cuenta de tipo cuenta corriente */
        long holderId = bankAccount.getBankAccountHolderId();
        long clientId = bankAccount.getBankAccountClientId();
        if( bankAccount.getBankAccountTypeId() == CURRENT_ACCOUNT && clientFeignClient.isEnterpriceClient(clientId) && holderId!=0){
            bankAccount.setMovimentsAllowed(0);
            bankAccountRepository.save(bankAccount);
        }
        
        
    }

    @Override
    public void savePersonalBankAccount(BankAccount account){
        //** Verificacion de que el cliente no tiene una cuenta ya creada, de forma tal que no pueda crear otra
        int registers = bankAccountRepository.findByBankAccountClientId(account.getBankAccountClientId()).size();
        boolean isPersonalClient = clientFeignClient.isPersonalClient(account.getBankAccountClientId());
        if(registers==0 && isPersonalClient)
            createAccountPersonal(account);
        else
            System.out.println("no se puede");
        
            
        
            
            
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
            int movementAllowed = bankAccount.getMovimentsAllowed();
            if(verifyMovements(bankAccount)){
                double currentBalance = bankAccount.getBalance();
                bankAccount.setMovimentsAllowed(movementAllowed-1);
                bankAccount.setBalance(currentBalance + amount); 
                bankAccountRepository.save(bankAccount);
                movimentFeignClient.saveMoviment(new Moviments(bankAccountId,bankAccount.getBankAccountClientId(),amount, MOVIMENT_DEPOSIT) );
            }else{
                System.out.println("No se puede procesar la accion");
            }
        
            
        },
        ()->{
            System.out.println("account not found");
        });
    }


    @Override
    public void withdraw(long bankAccountId, double amount){
        bankAccountRepository.findById(bankAccountId).ifPresentOrElse(bankAccount -> {
            double currentBalance = bankAccount.getBalance();
            int movementAllowed = bankAccount.getMovimentsAllowed();
            if(currentBalance>=amount && verifyMovements(bankAccount)){
                bankAccount.setBalance(currentBalance-amount);        
                bankAccount.setMovimentsAllowed(movementAllowed-1);
                bankAccountRepository.save(bankAccount);
                Moviments mov = new Moviments(bankAccountId,bankAccount.getBankAccountClientId(),amount, MOVIMENT_WITHDRAW);
                movimentFeignClient.saveMoviment(mov);
            }else{
                System.out.println("Non Sufficient Fund or No se puede procesar la accion");
                
            }
        },
        ()->{
            System.out.println("account not found");
        });
    }

    @Override
    public BalanceAvailable checkBalance(long bankAccountId){
        BalanceAvailable balanceAvailable = new BalanceAvailable();
        bankAccountRepository.findById(bankAccountId).ifPresentOrElse(
            bankAccount->{
                balanceAvailable.setId(bankAccount.getBankAccountId());
                balanceAvailable.setBalance(bankAccount.getBalance());
            },
            ()->{
                System.out.println("Cuenta no encontrada");
            } );
            return balanceAvailable;
    }

    @Override
    public List<BankAccount> getBankAccountByclientId(long id){
        return bankAccountRepository.findByBankAccountClientId(id);
    }


    public void createAccountPersonal(BankAccount bankAccount){
        switch((int)bankAccount.getBankAccountTypeId()){
            case (int)SAVINGS_ACCOUNT:
                createSavingAccount(bankAccount);
                break;
            case (int)CURRENT_ACCOUNT:
                createCurrentAccount(bankAccount);
                break;
            case (int)FIXED_TERM_ACCOUNT:
                createFixedTerm(bankAccount);
                break;
            default:
                

        }
    }

    
     


    public boolean verifyMovements(BankAccount bankAccount){
        switch((int)bankAccount.getBankAccountTypeId()){
            case (int)SAVINGS_ACCOUNT:
                return verifySavingsAccount(bankAccount);
            case (int)CURRENT_ACCOUNT:
                return verifyCurrentAccount(bankAccount);
            case (int)FIXED_TERM_ACCOUNT:
                return verifyFixedTermAccount(bankAccount);
            default:
                return false;

        }   
    }

    
    public boolean verifySavingsAccount(BankAccount bankAccount){
        return (bankAccount.getMovimentsAllowed()>0) ? true : false;

    }

    public boolean verifyCurrentAccount(BankAccount bankAccount){
        bankAccount.setMovimentsAllowed(bankAccount.getMovimentsAllowed()+1);
        return true;
    }
    
    public boolean verifyFixedTermAccount(BankAccount bankAccount){

        
        MovementDate mov =movementDateRepository.findByBankAccountId(bankAccount.getBankAccountId()).get(0);


        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(mov.getMovementDate());
        


        System.out.println("meses");
        System.out.println(c1.get(Calendar.DATE));
        System.out.println( c2.get(Calendar.DATE));

        return (bankAccount.getMovimentsAllowed()>0 && c1.get(Calendar.DATE) == c2.get(Calendar.DATE)) ? true : false;

    }


    public void createSavingAccount(BankAccount bankAccount){
        long bankAccountTypeId = bankAccount.getBankAccountTypeId();
        bankAccount.setMovimentsAllowed(bankAccountTypeService.getBankAccountType(bankAccountTypeId).getMovement_limit());
        bankAccountRepository.save(bankAccount);    
    }


    public void createFixedTerm(BankAccount bankAccount){
        if(bankAccount.getMovementDate()==null)
            return;

        long bankAccountTypeId = bankAccount.getBankAccountTypeId();
        bankAccount.setMovimentsAllowed(bankAccountTypeService.getBankAccountType(bankAccountTypeId).getMovement_limit());

        MovementDate movemenDate=new MovementDate();
        BankAccount newBank = bankAccountRepository.save(bankAccount);    

        movemenDate.setClientId(newBank.getBankAccountClientId());
        movemenDate.setMovementDate(newBank.getMovementDate());
        movemenDate.setBankAccountId(newBank.getBankAccountId());
        movementDateRepository.save(movemenDate);
        
        
    }

    public void createCurrentAccount(BankAccount bankAccount){
        long bankAccountTypeId = bankAccount.getBankAccountTypeId();
        bankAccount.setMovimentsAllowed(bankAccountTypeService.getBankAccountType(bankAccountTypeId).getMovement_limit());
        bankAccountRepository.save(bankAccount);    

    }
}
