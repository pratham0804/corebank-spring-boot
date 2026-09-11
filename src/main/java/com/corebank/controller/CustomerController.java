package com.corebank.controller;

import com.corebank.mapper.CustomerMapper;
import com.corebank.DTO.CreateCustomerDto;
import com.corebank.DTO.CustomerResponseDto;
import com.corebank.entity.Customer;
import com.corebank.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerResponseDto> saveCustomer(@RequestBody CreateCustomerDto customerDto){
      
      Customer cus = CustomerMapper.toCustomerEntity(customerDto);
      Customer customerEntityResponse = customerService.saveCustomer(cus);
      CustomerResponseDto customerResponseDto = CustomerMapper.toResponseDto(customerEntityResponse);
      
      return ResponseEntity.status(201).body(customerResponseDto);
    }

    
}
