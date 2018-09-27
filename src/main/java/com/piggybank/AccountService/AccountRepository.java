package com.piggybank.AccountService;

import com.piggybank.model.Account;
import com.piggybank.model.EmailAddress;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface AccountRepository extends ReactiveCrudRepository<Account, BigInteger> {

    Flux<Account> findAllByCustomer_LastName(String lastName);

    Flux<Account> findAllByCustomer_EmailAddress(EmailAddress emailAddress);

    Mono<Account> findAccountById(BigInteger accountId);
}

