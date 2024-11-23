package com.example.bank;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "source_account_id", nullable = false)
    private Account sourceAccount;
    @ManyToOne
    @JoinColumn(name = "destination_account_id", nullable = false)
    private Account destinationAccount;
    private double amount;
    private Date transferDate;

    public Transfer() {
    }

    public Transfer(Long id, Account sourseAccount, Account destinationAccount, double amount, Date transferDate) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.transferDate = transferDate;
    }

    public Transfer(Account sourceAccount, Account destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }
    public boolean executeTransfer(){
        this.transferDate = new Date();
        if(sourceAccount.getBalance() >= amount){
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);

            sourceAccount.addTransaction(new Transaction(-amount, "debit", new Date(), "Transfer către " + destinationAccount.getAccountNumber()));
            destinationAccount.addTransaction(new Transaction(amount, "credit", new Date(), "Transfer de la " + sourceAccount.getAccountNumber()));

            return true;
        }else{
            throw new IllegalArgumentException("Sold insuficient în contul sursă.");
        }
    }
}
