package com.example.bank;

public class Savings {
    private Account account;
    private double targetAmount;
    private double currentBalance;

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
}
