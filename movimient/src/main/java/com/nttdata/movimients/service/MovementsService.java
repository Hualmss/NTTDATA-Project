package com.nttdata.movimients.service;

import java.util.List;
import java.util.Optional;

import com.nttdata.movimients.model.Movement;

public interface MovementsService {

	List<Movement> getMovements();

	boolean saveMovements(Movement movimients);

	void deleteMovements(long id);

	Movement updateMovements(Movement movimients);

	Movement getMovementsById(long id);


	List<Movement> getMovementsByProductId(long id);

	/*
	 * public void deleteById (Long id);
	 * 
	 * Optional<Movimients> findById(Long id);
	 * 
	 */
}


