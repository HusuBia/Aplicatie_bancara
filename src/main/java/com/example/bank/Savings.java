package com.example.bank;

import jakarta.persistence.*;

@Entity
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double targetAmount;
    private double currentBalance;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Savings() {
    }

    public Savings(Long id, double targetAmount, double currentBalance, Account account) {
        this.id = id;
        this.targetAmount = targetAmount;
        this.currentBalance = currentBalance;
        this.account = account;
    }

    public Savings(Account account, double targetAmount) {
        this.account = account;
        this.targetAmount = targetAmount;
        this.currentBalance = 0.0;
    }
    public void deposit(double amount){
        currentBalance +=amount;
    }
    public double getProgrees(){
        return (currentBalance / targetAmount) * 100;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
