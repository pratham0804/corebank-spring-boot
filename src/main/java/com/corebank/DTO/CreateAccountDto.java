package com.corebank.DTO;

import java.math.BigDecimal;
// Question 4: is it mandatory that the field names in dto should be same as entity
// Question 5: in dto too do we need a no parameter constructor ??
// Question 6: no i am mapping the entity manually to the dto then ??
public class CreateAccountDto {
  private String accountNumber;
  private BigDecimal balance;
  
  
  public CreateAccountDto(){
    
  }

  public CreateAccountDto(String accountNumber, BigDecimal balance){
    this.accountNumber = accountNumber;
    this.balance = balance;
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