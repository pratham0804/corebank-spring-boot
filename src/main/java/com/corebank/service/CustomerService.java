package com.corebank.service;

import org.springframework.stereotype.Service;

import com.corebank.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

import com.corebank.entity.Customer;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
  }
  
  @PostConstruct
  public void initialize(){
    System.out.println("CustomerService is ready to use");
  }
  public Customer saveCustomer(Customer customer){
    return customerRepository.save(customer);
  }

}
