package com.nttdata.movimients.service;

import java.util.List;
import java.util.Optional;

import com.nttdata.movimients.model.Movimients;

public interface MovimientsService {


    /**
     * list all bank movements
     * return – returns a list of bank transactions
     */

    List<Movimients> getMovimients();

    /**
     * save bank movements
     *
     * @param movents – saves movement data
     * @return – returns bank movement
     */

    boolean saveMovimients(Movimients movimients);

    /**
     * updates bank movements
     *
     * @param movements – update the movement data
     * @return – returns updated bank movement data
     */
    Movimients updateMovimients(Movimients movimients);

    /**
     * search for bank movements
     *
     * @param id – search movement by id
     * @return – returns bank movement id
     */
    Movimients getMovimientsById(long id);

    /**
     * search products by productid
     *
     * @param id – search product by id
     * @return – returns bank product id
     */
    List<Movimients> getMovimientsByProductId(long id);


    /**
     * eliminate bank movement
     *
     * @param id – removes movement data
     */

    void deleteMovimients(long id);


}


