package com.corebank.controller;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
      //  Customer cus = customerService.saveCustomer(customer); // this is important , customer object we are receiving has id as null , and using it for returning in body of response entity will give u only name and email and id as null , if we want system generated id too in our response , we store the returned object and then pass it to body, not the object we are getting from request body... 
      // imp : i tested this , but still i got correct output 
      // Reason : save() returns the saved entity, and we should generally use that returned value rather than assuming the input reference is the object we should work with.

  
      //  customerService.saveCustomer(customer);
      //  return ResponseEntity.status(201).body(customer);

      Customer cus = customerService.saveCustomer(customer);
      return ResponseEntity.status(201).body(cus);
    }

    
}
