package com.nttdata.movimients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.movimients.model.MovimientType;

@Repository
public interface MovimientTypeRepository extends JpaRepository<MovimientType, Long>{

}
