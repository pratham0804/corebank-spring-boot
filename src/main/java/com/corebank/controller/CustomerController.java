package com.corebank.controller;


import java.util.List;
import com.corebank.mapper.CustomerMapper;
import com.corebank.DTO.CreateCustomerDto;
import com.corebank.DTO.CustomerResponseDto;
import com.corebank.entity.Customer;
import com.corebank.exception.CustomerNotFound;
import com.corebank.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> saveCustomer(@RequestBody CreateCustomerDto customerDto){
      
      Customer cus = CustomerMapper.toCustomerEntity(customerDto);
      Customer customerEntityResponse = customerService.saveCustomer(cus);
      CustomerResponseDto customerResponseDto = CustomerMapper.toResponseDto(customerEntityResponse);

      return ResponseEntity.status(201).body(customerResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
      List<Customer> customers = customerService.getAllCustomers();
      return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
       
       try {
       Customer customer =  customerService.getCustomerById(id);

       return ResponseEntity.ok(customer);
        
       } catch (CustomerNotFound e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
       
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id){
      try {
        customerService.DeleteCustomerById(id);

        return ResponseEntity.ok("Customer Deleted Successfully");
      } catch (CustomerNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
    }

    
}
