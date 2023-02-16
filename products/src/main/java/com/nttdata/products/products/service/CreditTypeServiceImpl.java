package com.nttdata.products.products.service;

import com.nttdata.products.products.model.CreditType;
import com.nttdata.products.products.repository.CreditTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditTypeServiceImpl implements CreditTypeService{

    @Autowired
    CreditTypeRepository creditTypeRepository;

    /**
     * @return list of credit types
     */
    @Override
    public List<CreditType> getCreditTypes() {
        return creditTypeRepository.findAll();
    }

    /**
     * @param creditType
     */
    @Override
    public void createCreditType(CreditType creditType) {
        creditTypeRepository.save(creditType);
    }

    /**
     * @param id
     * @param creditType
     */
    @Override
    public void editCreditType(long id, CreditType creditType) {
        creditTypeRepository.findById(id).ifPresent(c -> creditTypeRepository.save(creditType));
    }

    /**
     * @param id
     */
    @Override
    public void deleteCreditType(long id) {
        creditTypeRepository.findById(id).ifPresent(c -> creditTypeRepository.delete(c));
    }
}
