package com.nttdata.products.products.service;

import com.nttdata.products.products.model.CreditType;

import java.util.List;

public interface CreditTypeService {
    List<CreditType> getCreditTypes();
    void createCreditType(CreditType creditType);
    void editCreditType(long id, CreditType creditType);
    void deleteCreditType(long id);
}
