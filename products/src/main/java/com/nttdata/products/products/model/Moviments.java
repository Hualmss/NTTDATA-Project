package com.nttdata.products.products.model;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class Moviments implements Serializable {
    
    
    private long productId;

    private long clientId;

    private double amount;

    private long movientType;

    
}
