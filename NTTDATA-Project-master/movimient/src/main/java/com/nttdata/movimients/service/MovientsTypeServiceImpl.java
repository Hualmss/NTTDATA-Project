package com.nttdata.movimients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.movimients.model.MovimientType;
import com.nttdata.movimients.repository.MovimientTypeRepository;

@Service
public class MovientsTypeServiceImpl implements MovientsTypeService{
	@Autowired
	MovimientTypeRepository movimientTypeRepository;

	@Override
	public List<MovimientType> getMovimientType() {
		return movimientTypeRepository.findAll();
	}

	@Override
	public boolean saveMovimientType(MovimientType movimientType) {
		movimientTypeRepository.save(movimientType);
		return true;
	}

	@Override
	public void deleteMovimientType(long id) {
		movimientTypeRepository.deleteById(id);
		
	}

	@Override
	public MovimientType updateMovimientType(MovimientType movimientType) {
		return movimientTypeRepository.save(movimientType);
	}

	@Override
	public MovimientType getMovimientTypeById(long id) {
		return movimientTypeRepository.findById(id).orElseThrow();
	}

}
