package com.nttdata.products.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.products.products.model.BankAccountType;
import com.nttdata.products.products.repository.BankAccountTypeRepository;

@Service
public class BankAccountTypeServiceImpl implements BankAccountTypeService {

    @Autowired
    private BankAccountTypeRepository bankAccountTypeRepository;

    @Override
    public List<BankAccountType> getBankAccountTypes() {
        
        return bankAccountTypeRepository.findAll();
    }

    @Override
    public BankAccountType getBankAccountType(long id) {
        
        return bankAccountTypeRepository.findById(id).orElse(null);
    }


    @Override
    public void saveBankAccountType(BankAccountType bankAccountType){
         bankAccountTypeRepository.save(bankAccountType);
    }

    @Override
    public BankAccountType updateBankAccountType(BankAccountType bankAccountType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BankAccountType> deleteBankAccountType(long id) {
        // TODO Auto-generated method stub
        return null;
    }

   
}
