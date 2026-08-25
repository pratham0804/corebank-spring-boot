package com.corebank.entity;

import java.math.BigDecimal;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;
  private String accountNumber;
  private BigDecimal balance;

  

  public Account(){
    
  }

  public Account(String accountNumber, BigDecimal balance){
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public Long getId() {
    return id;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
  
}
