package com.nttdata.movimients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.movimients.model.MovimientType;

import com.nttdata.movimients.service.MovientsTypeService;

@RestController
public class MovientsTypeController {

	@Autowired
	MovientsTypeService movientsTypeService;

	@GetMapping(value = "MovientsType", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MovimientType>> getMovimientType() {
		return new ResponseEntity<>(movientsTypeService.getMovimientType(), HttpStatus.OK);
	}

	@PostMapping(value = "MovientsType", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveMovimientType(@RequestBody MovimientType movimientType) {

		movientsTypeService.saveMovimientType(movimientType);
	}

	@PutMapping(value = "MovientsType/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MovimientType updateMovimientType(@PathVariable long id, @RequestBody MovimientType movimientType) {
		if (movientsTypeService.getMovimientTypeById(id) == null) {
			return null;
		}
		return movientsTypeService.updateMovimientType(movimientType);
	}

	@DeleteMapping(value = "MovientsType/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovimientType> deleteMovimientType(@PathVariable long id) {
		if (movientsTypeService.getMovimientTypeById(id) == null) {
			return null;

		}
		movientsTypeService.deleteMovimientType(id);
		return movientsTypeService.getMovimientType();

	}

}
