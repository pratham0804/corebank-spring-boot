package com.corebank.mapper;

import com.corebank.DTO.CreateAccountDto;
import com.corebank.entity.Account;
import com.corebank.DTO.AccountResponseDto;

public class AccountMapper {
  
  // CreateAccountDto to Account Entity  
  public static Account toAccountEntity(CreateAccountDto accountDto){ // i put this method as static because i dont want it to rely on object ,,,, i did it out of lazyness so that there is no need of writing constructor, but is there any logical reason behind it , or shouldd i write no parameter constructor here..
    Account account = new Account();
    account.setAccountNumber(accountDto.getAccountNumber());
    account.setBalance(accountDto.getBalance());

    return account;
  }


  
  // Account Entity to Account Response Dto

  public static AccountResponseDto toResponseDto(Account account){
    AccountResponseDto AccountResponseDto = new AccountResponseDto();

    AccountResponseDto.setAccountNumber(account.getAccountNumber());
    AccountResponseDto.setId(account.getId());
    AccountResponseDto.setBalance(account.getBalance());

    return AccountResponseDto;
  }
}
