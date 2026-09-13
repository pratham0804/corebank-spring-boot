package com.corebank.controller;

import com.corebank.service.AccountService;
import com.corebank.DTO.AccountResponseDto;
import com.corebank.DTO.CreateAccountDto;
import com.corebank.entity.Account;
import com.corebank.mapper.AccountMapper;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.corebank.exception.AccountNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<AccountResponseDto> addAccount(@RequestBody CreateAccountDto createAccountDto){

      Account account = AccountMapper.toAccountEntity(createAccountDto);
      Account accountResponse = accountService.saveAccount(account);
      AccountResponseDto accountResponseDto = AccountMapper.toResponseDto(accountResponse);
      return ResponseEntity.status(201).body(accountResponseDto);
    }

    // Get all account
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
      return ResponseEntity.ok(accountService.getAllAccount());
    }


    // Get Account By id
    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Long id){
      try {

        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);

      } catch (AccountNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
    }

    // Delete Account 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountById(@PathVariable Long id){
      try {
        accountService.deleteAccountById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account Deleted Successfully");

      } catch (AccountNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
    }

    // Update Account
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccountById(@PathVariable Long id, @RequestBody Account account){
      try {
        Account account2 = accountService.updateAccountById(id, account);
        return ResponseEntity.ok(account2);
      } catch (AccountNotFound e) {
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }

    }




    
}