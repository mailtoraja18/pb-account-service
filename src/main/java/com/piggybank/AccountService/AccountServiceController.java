package com.piggybank.AccountService;

import com.piggybank.model.Account;
import com.piggybank.model.Customer;
import com.piggybank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AccountServiceController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/customers")
    public Flux<Customer> customers () {
        return customerRepository.findAll();
    }

    @GetMapping("/accounts")
    public Flux<Account> accounts () {
        return accountRepository.findAll();
    }

    @GetMapping("/transactions")
    public Flux<Transaction> transactions () {
        return transactionRepository.findAll();
    }


}
