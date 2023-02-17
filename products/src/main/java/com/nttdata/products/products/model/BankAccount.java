package com.nttdata.products.products.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter 
@Getter
@Table(name = "BankAccount")
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

    
    private int movimentsAllowed;

    @Transient
    @JsonFormat(pattern = "YYY-MM-dd")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Date movementDate;

    @Transient
    @JsonProperty(access = Access.WRITE_ONLY)
    private long bankAccountHolderId;

    

    
}
