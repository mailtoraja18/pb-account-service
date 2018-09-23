package com.piggybank.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Data
@Document
public class Transaction extends AbstractDocument {

    private BigInteger accountId;
    private BigDecimal amount;
    private TrasactionType type;
    private Category category;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate txnDate;

    public Transaction(BigInteger accountId, BigDecimal amount, Category category, LocalDate txnDate) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = category.getTransactiontype(category);
        this.category = category;
        this.txnDate = txnDate;
    }
}
