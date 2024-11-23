package com.example.bank;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();
    public Account() {
    }

    public Account(Long id, String accountNumber, double balance, User user, List<Transaction> transactions, List<Card> cards) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
        this.transactions = transactions;
        this.cards = cards;
    }

    public Account(String accountNumber, double balance, User user) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
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
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
