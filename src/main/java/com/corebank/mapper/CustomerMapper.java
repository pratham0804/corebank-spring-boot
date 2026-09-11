package com.corebank.mapper;

import com.corebank.DTO.CreateCustomerDto;
import com.corebank.DTO.CustomerResponseDto;
import com.corebank.entity.Customer;

public class CustomerMapper {

  // CreateCustomerDto to Customer Entity
  public static Customer toCustomerEntity(CreateCustomerDto customerDto){
     Customer customer = new Customer();

     customer.setName(customerDto.getName());
     customer.setEmail(customerDto.getEmail());

     return customer;
  }

  
  // Customer Entity to CustomerResponseDto
  public static CustomerResponseDto toResponseDto(Customer customer){

    CustomerResponseDto customerResponseDto = new CustomerResponseDto();
    customerResponseDto.setId(customer.getId());
    customerResponseDto.setName(customer.getName());
    customerResponseDto.setEmail(customer.getEmail());

    return customerResponseDto;
  }
}
