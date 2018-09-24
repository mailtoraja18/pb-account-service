package com.piggybank.AccountService;

import com.piggybank.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, BigDecimal> {

    Flux<Customer> findByLastName(String lastName);

    Flux<Customer> findByEmailAddress(String email);

}

