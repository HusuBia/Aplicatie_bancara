package com.example.bank;

import java.util.Date;

public class Transaction {
    private double amount;
    private String transaction_type; // credit sau debit
    private Date date;
    private String location;
    private String category;

    public Transaction(double amount, String transaction_type, Date date, String location, String category) {
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.date = date;
        this.location = location;
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
