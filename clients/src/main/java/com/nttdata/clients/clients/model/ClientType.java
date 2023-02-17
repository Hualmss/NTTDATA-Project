package com.nttdata.clients.clients.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ClientType")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientTypeId;
    private String description;
    
}
