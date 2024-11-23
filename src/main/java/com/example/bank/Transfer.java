package com.example.bank;

import java.util.Date;

public class Transfer {
    private Account sourseAccount;
    private Account destinationAccount;
    private double amount;

    public Transfer(Account sourseAccount, Account destinationAccount, double amount) {
        this.sourseAccount = sourseAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }
    public boolean executeTransfer(){
        if(sourseAccount.getBalance() >= amount){
            sourseAccount.addTransaction(new Transaction(-amount, "debit", new Date(), null, "Transfer"));
            destinationAccount.addTransaction(new Transaction(amount, "credit", new Date(),null, "Transfer"));
            return true;
        }
        return false;
    }
}
