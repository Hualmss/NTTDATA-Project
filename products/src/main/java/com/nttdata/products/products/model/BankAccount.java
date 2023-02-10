package com.nttdata.products.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "bank_account")

public class BankAccount implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long bank_account_id;


    private double balance;

    @NotNull
    private long bank_account_type_id;

    @NotNull
    private long bank_account_client_id;
    
}
