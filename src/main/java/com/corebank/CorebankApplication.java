package com.corebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CorebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorebankApplication.class, args);
	}

	// @PostConstruct this will not work , postconstruct method runs after the creation and injection of bean if completed, but here i am using the beans as parameters , there is possibility that they are not created yet..... 
	// public void Initializor(AccountService accountService, CustomerService customerService){
	// 	if(accountService == null){
	// 		System.out.println("Account Service dependencies not injected");
	// 	}

	// 	if(customerService == null){
	// 		System.out.println("Customer Service dependencies not injected");
	// 	}

	// 	if(accountService != null && customerService != null){
	// 		System.out.println("Corebank is initialized");
	// 	}

		
	// }
	
}
