package com.corebank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.corebank.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

import com.corebank.entity.Customer;
import com.corebank.exception.CustomerNotFound;


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

  public Customer getCustomerById(Long id) throws CustomerNotFound {
    return customerRepository.findById(id)
          .orElseThrow(() -> new CustomerNotFound("Customer does not exist"));    
  }

  public void DeleteCustomerById(Long id) throws CustomerNotFound {
     Optional<Customer> optionalCustomer = customerRepository.findById(id);
     if(optionalCustomer.isPresent()){
      customerRepository.deleteById(id);
     }
     else{
      throw new CustomerNotFound("Customer Not Found");
     }
  }

}
