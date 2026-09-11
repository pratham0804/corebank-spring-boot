package com.corebank.DTO;

import java.math.BigDecimal;

public class AccountResponseDto {
  private Long id;
  private String accountNumber;
  private BigDecimal balance;
  
  public AccountResponseDto(){

  }

  public AccountResponseDto(Long id, String accountNumber, BigDecimal balance){
    this.id = id;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public void setId(Long id) {
    this.id = id;
  }
  public Long getId() {
    return id;
  }
  
  public String getAccountNumber() {
    return accountNumber;
  }
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public BigDecimal getBalance() {
    return balance;
  }
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
  
  

}
