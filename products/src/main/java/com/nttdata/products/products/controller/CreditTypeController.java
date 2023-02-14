package com.nttdata.products.products.controller;

import com.nttdata.products.products.model.CreditType;
import com.nttdata.products.products.service.CreditTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditTypeController {
    @Autowired
    CreditTypeService creditTypeService;

    @GetMapping(value = "creditTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CreditType> getCreditTypes() {
        return creditTypeService.getCreditTypes();
    }

    @PostMapping(value = "creditTypes", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createCreditType(@RequestBody CreditType creditType) {
        creditTypeService.createCreditType(creditType);
    }

    @PutMapping(value = "creditTypes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void editCreditType(@PathVariable("id") long id, @RequestBody CreditType creditType) {
        creditTypeService.editCreditType(id, creditType);
    }

    @DeleteMapping(value = "creditTypes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCreditType(@PathVariable("id") long id) {
        creditTypeService.deleteCreditType(id);
    }



}
