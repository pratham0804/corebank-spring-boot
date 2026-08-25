package com.corebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.corebank.entity.Customer; 

public interface CustomerRepository extends JpaRepository<Customer,Long> {

  
}
