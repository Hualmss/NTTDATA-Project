package com.nttdata.products.products.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "moviments")
public class Moviments  {
    
    
    private long productId;

    private long clientId;

    private double amount;

    private long movientType;

    
}
