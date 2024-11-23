package com.example.bank;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String transaction_type; // credit sau debit
    private Date date;
    private String category;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction() {
    }

    public Transaction(Long id, double amount, String transaction_type, Date date, String category, Account account) {
        this.id = id;
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.date = date;
        this.category = category;
        this.account = account;
    }

    public Transaction(double amount, String transaction_type, Date date, String category, Account account) {
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.date = date;
        this.category = category;
        this.account = account;
    }

    public Transaction(double amount, String transaction_type, Date date, String category) {
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.date = date;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }
}
