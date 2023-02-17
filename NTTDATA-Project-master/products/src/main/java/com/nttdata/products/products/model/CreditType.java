package com.nttdata.products.products.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "creditTypes")
public class CreditType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long creditTypeId;
    @NotNull
    String description;
}
