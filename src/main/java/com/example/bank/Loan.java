package com.example.bank;

import jakarta.persistence.*;

@Entity
public class Loan {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private double monthlyRate;
    private String dueDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Loan() {
    }

    public Loan(Long id, double amount, double monthlyRate, String dueDate, User user) {
        this.id = id;
        this.amount = amount;
        this.monthlyRate = monthlyRate;
        this.dueDate = dueDate;
        this.user = user;
    }

    public Loan(double amount, double monthlyRate, String dueDate) {
        this.amount = amount;
        this.monthlyRate = monthlyRate;
        this.dueDate = dueDate;
    }
    public String getLoanDetails(){
        return "Loan ID: " + id + ", Amount: " + amount + ", Monthly Rate: " + monthlyRate + ", Due Date: " + dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
