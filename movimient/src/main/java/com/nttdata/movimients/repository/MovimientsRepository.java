package com.nttdata.movimients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.movimients.model.Movement;






@Repository
public interface MovimientsRepository extends JpaRepository<Movement, Long>{
    List<Movement> findByproductId(long idProduct);
}
