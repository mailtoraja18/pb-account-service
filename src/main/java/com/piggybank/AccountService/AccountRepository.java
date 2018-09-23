package com.piggybank.AccountService;

import com.piggybank.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface AccountRepository extends ReactiveCrudRepository<Account, BigInteger> {

}

