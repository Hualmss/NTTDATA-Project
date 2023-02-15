package com.nttdata.movimients.service;

import java.util.List;
import java.util.Optional;

import com.nttdata.movimients.model.Movimients;

public interface MovimientsService {

	List<Movimients> getMovimients();

	boolean saveMovimients(Movimients movimients);

	void deleteMovimients(long id);

	Movimients updateMovimients(Movimients movimients);

	Movimients getMovimientsById(long id);


	List<Movimients> getMovimientsByProductId(long id);

	/*
	 * public void deleteById (Long id);
	 * 
	 * Optional<Movimients> findById(Long id);
	 * 
	 */
}


