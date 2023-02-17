package com.nttdata.products.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.products.products.model.MovementDate;

@Repository
public interface MovementDateRepository extends JpaRepository<MovementDate, Long> {
    List<MovementDate> findByBankAccountId(long bankAccountId);
}
