package com.nttdata.products.products.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credit_cards")
public class CreditCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long creditCardId;
    //@NotNull

    private double balance;
    private double interestRate;
    private LocalDate paymentDate;
    private double limitBalance;
    @NotNull
    private long creditTypeId;
    @NotNull
    private long clientId;
}
