package com.piggybank.AccountService;

import com.piggybank.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

}

