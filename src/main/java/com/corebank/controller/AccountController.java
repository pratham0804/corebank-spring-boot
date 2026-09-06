package com.corebank.controller;

import com.corebank.service.AccountService;
import com.corebank.entity.Account;

import org.springframework.web.bind.annotation.RequestBody;
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
    public Account AddAccount(@RequestBody Account account){
       return accountService.saveAccount(account);
    }





    
}