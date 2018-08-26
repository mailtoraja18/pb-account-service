package com.piggybank.AccountService;

import com.piggybank.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction,String> {

}

