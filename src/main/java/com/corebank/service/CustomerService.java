package com.corebank.service;

import java.util.List;
import java.util.Optional;

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

  public List<Customer> getAllCustomers(){
     return customerRepository.findAll();
  }

  public Optional<Customer> getCustomerById(Long id){

    Optional<Customer> customer = customerRepository.findById(id);
    return customer;    
  }

}
