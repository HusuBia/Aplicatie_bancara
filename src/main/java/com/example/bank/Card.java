package com.example.bank;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private String card_Type;
    private double limit;
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Card() {
    }

    public Card(Long id, String cardNumber, String card_Type, double limit, boolean isActive, Account account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.card_Type = card_Type;
        this.limit = limit;
        this.isActive = isActive;
        this.account = account;
    }

    public Card(String cardNumber, String card_Type, double limit, boolean isActive, Account account) {
        this.cardNumber = cardNumber;
        this.card_Type = card_Type;
        this.limit = limit;
        this.isActive = isActive;
        this.account = account;
    }

    public void blockCard(){
        isActive = false;
    }
    public void unblockCard(){
        isActive = true;
    }
    public void setSpendingLimit(double limit){
        this.limit = limit;
    }
    public boolean isActive(){
        return isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCard_Type() {
        return card_Type;
    }

    public void setCard_Type(String card_Type) {
        this.card_Type = card_Type;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
