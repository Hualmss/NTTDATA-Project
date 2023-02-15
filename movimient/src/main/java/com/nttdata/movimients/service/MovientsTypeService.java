package com.nttdata.movimients.service;

import java.util.List;

import com.nttdata.movimients.model.MovimientType;


public interface MovientsTypeService {

	List<MovimientType> getMovimientType();

	boolean saveMovimientType(MovimientType movimientType);

	void deleteMovimientType(long id);

	MovimientType updateMovimientType(MovimientType movimientType);

	MovimientType getMovimientTypeById(long id);
}
