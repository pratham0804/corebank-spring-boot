package com.corebank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corebank.service.CustomerService;
import com.corebank.entity.Customer;

@RestController
@RequestMapping("/api2")
public class CustomerController {
  private final CustomerService customerService;
  public CustomerController(CustomerService customerService){
    this.customerService = customerService;
  }

  @PostMapping("/customers")
  public void saveCustomer(@RequestBody Customer customer){
    customerService.saveCustomer(customer);
  }
  
}