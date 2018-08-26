package com.piggybank.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Document
public class Transaction extends AbstractDocument {

     @DBRef
     private Account account;
     private BigDecimal amount;
     private TrasactionType type;
     private Category category;
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
     private LocalDate txnDate;

     public Transaction(Account account, BigDecimal amount, Category category , LocalDate txnDate) {
          this.account = account;
          this.amount = amount;
          this.type = category.getTransactiontype(category);
          this.category = category;
          this.txnDate = txnDate;
     }
}
