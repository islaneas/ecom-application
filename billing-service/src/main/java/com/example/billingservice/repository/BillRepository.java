package com.example.billingservice.repository;

import com.example.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Long> {
    /* @RestResource(path = "/byCustomerId")
     List<Bill> findByCustomerId(@Param("customerid") Long customerId);*/
    List<Bill> findByCustomerId( Long customerId);
}