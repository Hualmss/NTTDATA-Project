package com.nttdata.products.products.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MovementDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movementId;

    private long bankAccountId;

    private long clientId;

    private Date movementDate;
}
