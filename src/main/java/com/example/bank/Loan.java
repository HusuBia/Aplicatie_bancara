package com.example.bank;

public class Loan {
    private String loanId;
    private double amount;
    private double monthlyRate;
    private String dueDate;

    public Loan(String loanId, double amount, double monthlyRate, String dueDate) {
        this.loanId = loanId;
        this.amount = amount;
        this.monthlyRate = monthlyRate;
        this.dueDate = dueDate;
    }
    public String getLoanDetails(){
        return "Loan ID: " + loanId + ", Amount: " + amount + ", Monthly Rate: " + monthlyRate + ", Due Date: " + dueDate;
    }
}
