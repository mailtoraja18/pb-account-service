package com.piggybank.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document
public class Customer extends AbstractDocument {

    private String firstName , lastName;

    @Field("email")
    @Indexed(unique = true)
    private EmailAddress emailAddress;

    private Address address;

    public Customer(String firstName, String lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
