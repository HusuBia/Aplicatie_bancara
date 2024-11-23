package com.example.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
        balance += transaction.getAmount();
    }
    public List<Transaction> getTransactionsHistory(Date startDate, Date endDate){
        List<Transaction> result = new ArrayList<>();
        for(Transaction transaction: transactions)
            if ((startDate == null || transaction.getDate().after(startDate)) && (endDate == null || transaction.getDate().before(endDate))) {
                result.add(transaction);
            }
        return result;
    }
}
