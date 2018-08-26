package com.piggybank.dbloader;

import com.mongodb.MongoClient;
import com.piggybank.AccountService.AccountRepository;
import com.piggybank.AccountService.CustomerRepository;
import com.piggybank.AccountService.TransactionRepository;
import com.piggybank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
public class DBLoader {

    @Autowired
    MongoClient mongoClient;



    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, AccountRepository accountRepository , TransactionRepository transactionRepository){
        Customer aCustomer = new Customer("Rajaram","Kumar");
        EmailAddress aEmailAddress = new EmailAddress("a@b.com");
        aCustomer.setEmailAddress(aEmailAddress);
        Address aAddress = new Address("66 New Way","New York", "United States");
        aCustomer.setAddress(aAddress);
        Account aAccount = new Account(aCustomer,"CHECKING");


        Customer bCustomer = new Customer("Anu" ,"Venkat");
        EmailAddress bEmailAddress = new EmailAddress("b@c.com");
        bCustomer.setEmailAddress(bEmailAddress);
        Address bAddress = new Address("66 New Way","New York", "United States");
        bCustomer.setAddress(bAddress);
        Account bAccount = new Account(bCustomer,"CHECKING");

        List<Account> accounts = Arrays.asList(aAccount,bAccount);
        final Random RANDOM = new Random();
        final RandomDate randomDate = new RandomDate(LocalDate.now(),LocalDate.now().minusMonths(2));

        List<Transaction> randomTransactions = new ArrayList<Transaction>();

        //generate random 100 transactions records
        int recordSize = 100;
        while(recordSize -- > 0) {
            Account account = accounts.get(RANDOM.nextInt(accounts.size()));
            Category category = Category.randomCategory();
            BigDecimal amount = BigDecimal.valueOf(RandomCategoryLimits.getRandomForCategory(category));
            Transaction t = new Transaction(account,amount,category,randomDate.nextDate());
            randomTransactions.add(t);
        }


        return args -> {
            if(mongoClient.getDB("acct") == null || ! ( mongoClient.getDB("acct").getCollection("customer").count() > 0)) {
                Flux.just(aCustomer, bCustomer).flatMap(customerRepository::save)
                        .subscribe(System.out::println);
                Thread.sleep(1000);
                Flux.just(bAccount, aAccount).flatMap(accountRepository::save)
                        .subscribe(System.out::println);
                Thread.sleep(1000);
                Flux.fromArray(randomTransactions.toArray(new Transaction[100])).flatMap(transactionRepository::save)
                        .subscribe(System.out::println);
            }
        };
    }
}
