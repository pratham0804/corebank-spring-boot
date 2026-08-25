package com.corebank.service;

import org.springframework.stereotype.Service;

import com.corebank.repository.AccountRepository;

import jakarta.annotation.PostConstruct;

import com.corebank.entity.Account;

@Service
public class AccountService {

  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository){
    this.accountRepository = accountRepository;
  }

  @PostConstruct
  public void initialize(){
    System.out.println("Account Service ready to use");
  }


  public void saveAccount(Account account){
    accountRepository.save(account);
  }

}
