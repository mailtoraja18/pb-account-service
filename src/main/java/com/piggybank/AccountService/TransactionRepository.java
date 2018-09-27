package com.piggybank.AccountService;

import com.piggybank.model.Account;
import com.piggybank.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, BigInteger> {

    Flux<Transaction> findAllByAccountIdOrderByTxnDateDesc(BigInteger accountId);

}

