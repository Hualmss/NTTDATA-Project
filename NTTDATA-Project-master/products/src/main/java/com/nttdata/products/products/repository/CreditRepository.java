package com.nttdata.products.products.repository;

import com.nttdata.products.products.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    List <Credit> findByClientId(long id);

}
