package com.nttdata.movimients.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "movimient")
public class Movement extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movimientsNo;
	//@NotNull
	private long productId;
	//@NotNull
	private long clientId;

	private double amount;

	//@NotNull
	private long movientType;

	
}
