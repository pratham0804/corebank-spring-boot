package com.corebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.corebank.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

  
}
