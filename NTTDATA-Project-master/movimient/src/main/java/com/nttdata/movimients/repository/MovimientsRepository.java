package com.nttdata.movimients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.nttdata.movimients.model.Movimients;

@Repository
public interface MovimientsRepository extends JpaRepository<Movimients, Long>{
    List<Movimients> findByproductId(long idProduct);
}
