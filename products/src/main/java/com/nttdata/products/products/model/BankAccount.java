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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "bank_account")
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long bankAccountId;


    private double balance;

    @NotNull
    private long bankAccountTypeId;

    @NotNull
    private long bankAccountClientId;
    
}
