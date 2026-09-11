package com.corebank.controller;

import com.corebank.service.AccountService;
import com.corebank.entity.Account;

import org.springframework.web.bind.annotation.RequestBody;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/addAccount")
    public ResponseEntity<Account> AddAccount(@RequestBody Account account){

      Account acc = accountService.saveAccount(account);
      return ResponseEntity.status(201).body(acc);
    }





    
}