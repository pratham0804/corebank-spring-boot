package com.corebank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corebank.entity.Account;

import com.corebank.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

  private final AccountService accountService;
  public AccountController(AccountService accountService){
    this.accountService = accountService;
  }
  
  @PostMapping("/accounts")
  public void saveCustomerController(@RequestBody Account account){
    accountService.saveAccount(null);
  } 
}
