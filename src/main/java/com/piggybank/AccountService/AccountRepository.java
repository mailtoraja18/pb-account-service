package com.piggybank.AccountService;

import com.piggybank.model.Account;
import com.piggybank.model.EmailAddress;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

public interface AccountRepository extends ReactiveCrudRepository<Account, Integer> {

    Flux<Account> findAllByCustomer_LastName(String lastName);

    Flux<Account> findAllByCustomer_EmailAddress(EmailAddress emailAddress);
}

