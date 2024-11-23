package com.example.bank;

public class Card {
    private String cardNumber;
    private Account account;
    private double limit;
    private boolean isActive;

    public Card(String cardNumber, Account account, double limit) {
        this.cardNumber = cardNumber;
        this.account = account;
        this.limit = limit;
        isActive = true;
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
}
