package com.nttdata.products.products.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

@Table(name = "bankAccountSignatory")
public class BankAccountSignatory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long clientBankAccountId;

    private long bankAccountId;
}
