package com.corebank.controller;

import com.corebank.entity.Customer;
import com.corebank.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
       return customerService.saveCustomer(customer);
    }

    
}
