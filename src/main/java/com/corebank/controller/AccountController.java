package com.corebank.controller;

import com.corebank.service.AccountService;
import com.corebank.DTO.AccountResponseDto;
import com.corebank.DTO.CreateAccountDto;
import com.corebank.entity.Account;
import com.corebank.mapper.AccountMapper;

import org.springframework.web.bind.annotation.RequestBody;


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

    @PostMapping
    public ResponseEntity<AccountResponseDto> AddAccount(@RequestBody CreateAccountDto createAccountDto){

      Account account = AccountMapper.toAccountEntity(createAccountDto);
      Account accountResponse = accountService.saveAccount(account);
      AccountResponseDto accountResponseDto = AccountMapper.toResponseDto(accountResponse);
      return ResponseEntity.status(201).body(accountResponseDto);
    }

    // Get all account
    // Get Account By id
    // Delete Account 
    // Update Account





    
}