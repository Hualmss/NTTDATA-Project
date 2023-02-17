package com.nttdata.movimients.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "movimient")
public class Movimients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movimientsNo;

	private long productId;

	private long clientId;

	private double amount;

	private Date creationDate;
	
	//@NotNull
	private long movientType;

	
}
