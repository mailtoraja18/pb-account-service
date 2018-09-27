package com.piggybank.AccountService;

import com.piggybank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1")
public class AccountServiceController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/search-accounts")
    public Flux<Account> searchAccounts(@RequestParam(value = "email" , required = false) String email ,
                                        @RequestParam(value = "lastName" , required = false) String lastName) {
        if(lastName != null) {
            return accountRepository.findAllByCustomer_LastName(lastName);
        } else {
            return accountRepository.findAllByCustomer_EmailAddress(new EmailAddress(email));
        }
    }

    @GetMapping("/customers")
    public Flux<Customer> customers() {
        return customerRepository.findAll();
    }


    @GetMapping("/account")
    public Mono<Account> account(@RequestParam(value = "accountId" , required = true) BigInteger accountId) {
        return accountRepository.findAccountById(accountId);
    }

    @GetMapping("/accounts")
    public Flux<Account> accounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/transactions")
    public Flux<Transaction> transactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/account/transactions")
    public Flux<Transaction> transactionOfAccount(@RequestParam(value = "accountId" , required = true) BigInteger accountId) {
        return transactionRepository.findAllByAccountIdOrderByTxnDateDesc(accountId);
    }

    @GetMapping("/ref/transaction-types")
    public  TrasactionType[] transactionTypes() {
        return TrasactionType.values();
    }

    @GetMapping("/ref/transaction-categories")
    public  Category[] trasactionCategory() {
        return Category.values();
    }

}
