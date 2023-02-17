package com.nttdata.movimients.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimientType")
public class MovimientType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movimientType;

	private String movimientDesc;

	public long getMovimientType() {
		return movimientType;
	}

	public void setMovimientType(long movimientType) {
		this.movimientType = movimientType;
	}

	public String getMovimientDesc() {
		return movimientDesc;
	}

	public void setMovimientDesc(String movimientDesc) {
		this.movimientDesc = movimientDesc;
	}

}
