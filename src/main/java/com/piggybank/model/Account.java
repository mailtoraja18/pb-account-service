package com.piggybank.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Account extends AbstractDocument {

    public final static Customer NULL_B = new Customer(null,null);


    private Customer customer ;

    private String accountType;

    public Account(Customer customer, String accountType) {
        this.customer = customer;
        this.accountType = accountType;
    }
}
