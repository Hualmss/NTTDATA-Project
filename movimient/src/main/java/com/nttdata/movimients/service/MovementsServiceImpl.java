package com.nttdata.movimients.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.movimients.model.Movement;
import com.nttdata.movimients.repository.MovimientsRepository;

@Service
public class MovementsServiceImpl implements MovementsService {

	@Autowired
	MovimientsRepository movimientsRepository;

	@Override
	public List<Movement> getMovements() {

		return movimientsRepository.findAll();
	}

	@Override
	public boolean saveMovements(Movement movimients) {
		movimientsRepository.save(movimients);
		return true;
	}

	@Override
	public void deleteMovements(long id) {
		movimientsRepository.deleteById(id);

	}

	@Override
	public Movement updateMovements(Movement movimients) {

		return movimientsRepository.save(movimients);

	}

	@Override
	public Movement getMovementsById(long id) {
		return movimientsRepository.findById(id).orElseThrow();

	}

	@Override
	public List<Movement> getMovementsByProductId(long id){
		return movimientsRepository.findByproductId(id);
	}

	/*
	 * @Override public void deleteById(Long id) {
	 * movimientsRepository.deleteById(id);
	 * 
	 * }
	 * 
	 * @Override public Optional<Movimients> findById(Long id) {
	 * 
	 * return movimientsRepository.findById(id); }
	 */

}
