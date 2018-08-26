package com.piggybank.AccountService;

import com.piggybank.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AccountRepository extends ReactiveCrudRepository<Account,String> {

}

