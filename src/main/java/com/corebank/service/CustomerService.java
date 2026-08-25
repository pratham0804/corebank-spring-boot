package com.corebank.service;

import org.springframework.stereotype.Service;

import com.corebank.repository.CustomerRepository;
import com.corebank.entity.Customer;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
  }

  public void saveCustomer(Customer customer){
    customerRepository.save(customer);
  }

}
