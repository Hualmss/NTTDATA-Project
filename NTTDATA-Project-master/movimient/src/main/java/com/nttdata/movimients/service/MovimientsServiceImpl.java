package com.nttdata.movimients.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.movimients.model.Movimients;
import com.nttdata.movimients.repository.MovimientsRepository;

@Service
public class MovimientsServiceImpl implements MovimientsService {

	@Autowired
	MovimientsRepository movimientsRepository;

	@Override
	public List<Movimients> getMovimients() {

		return movimientsRepository.findAll();
	}

	@Override
	public boolean saveMovimients(Movimients movimients) {
		movimientsRepository.save(movimients);
		return true;
	}

	@Override
	public void deleteMovimients(long id) {
		movimientsRepository.deleteById(id);

	}

	@Override
	public Movimients updateMovimients(Movimients movimients) {

		return movimientsRepository.save(movimients);

	}

	@Override
	public Movimients getMovimientsById(long id) {
		return movimientsRepository.findById(id).orElseThrow();

	}

	@Override
	public List<Movimients> getMovimientsByProductId(long id){
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
