package com.nttdata.movimients.service;

import java.util.List;

import com.nttdata.movimients.model.MovimientType;


public interface MovientsTypeService {

	/**
     * list all types of bank movements
     * return – returns a list of bank transaction types
     */
	List<MovimientType> getMovimientType();

	/**
     * save types of bank movements
     *
     * @param movementType – stores movement type data
     * @return – returns bank movement types
     */
	boolean saveMovimientType(MovimientType movimientType);

	/**
     * eliminate bank movement type
     *
     * @param id – deletes the data of the type of movements
     */
	void deleteMovimientType(long id);

	/**
     * update type bank movements
     *
     * @param movementType – updates the data of the type of movements
     * @return – returns data of the updated bank movement type
     */
	MovimientType updateMovimientType(MovimientType movimientType);

	/**
     * search type bank movements
     *
     * @param id – search movement type by id
     * @return – returns bank movement type id
     */
	MovimientType getMovimientTypeById(long id);
}
