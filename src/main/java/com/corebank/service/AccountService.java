package com.corebank.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.corebank.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import com.corebank.entity.Account;
import com.corebank.exception.AccountNotFound;


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


  public Account saveAccount(Account account){
    return accountRepository.save(account);
  }

  // Get all account
  public List<Account> getAllAccount(){
    return accountRepository.findAll();
  }

    // Get Account By id
  public Account getAccountById(Long id) throws AccountNotFound {
    Optional<Account> optionalAccount =  accountRepository.findById(id);
    if(optionalAccount.isPresent()){
      return optionalAccount.get();
    }
    else{
      throw new AccountNotFound("Account not found");
    }
  }

  
    // Delete Account 

  public void deleteAccountById(Long id) throws AccountNotFound {
    Optional<Account> optionalAccount = accountRepository.findById(id);
    if(optionalAccount.isPresent()){
      accountRepository.deleteById(id);
    }
    else{
      throw new AccountNotFound("Account not found, cannot perform delete operation");
    }
  }
    // Update Account

    public Account updateAccountById(Long id, Account account) throws AccountNotFound {
      Optional<Account> optionalAccount = accountRepository.findById(id);
      if(optionalAccount.isPresent()){
        // Account account2 = new Account();
        // account2.setAccountNumber(account.getAccountNumber());
        // account2.setBalance(account.getBalance());
        // account2.setId(account.getId());    this does not work , it create a new account instance with system generated id , we want to update the existing one

        Account existingAccount = optionalAccount.get();
        existingAccount.setAccountNumber(account.getAccountNumber());
        existingAccount.setBalance(account.getBalance());
        System.out.println(
    "Existing account ID = " + existingAccount.getId()
);
        return accountRepository.save(existingAccount);
      }
      else throw new AccountNotFound("Account does not exist, update operation not allowed");
    }

}
