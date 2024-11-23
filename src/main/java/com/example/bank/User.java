package com.example.bank;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean twoFactor_Auth;
    private boolean isAuthenticated;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts =  new ArrayList<>();

    public User(){}
    public User(String username, String password, String email, List<Account> accounts) {
        this.username = username;
        this.password = password;
        this.email = email;
        twoFactor_Auth = false;
        isAuthenticated = false;
        this.accounts = accounts;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean authenticate(String password, String oneTime_pass){
        if(this.password.equals(password)) {
            if (twoFactor_Auth) {
                return oneTime_pass != null && oneTime_pass.equals("12345");
            }
            isAuthenticated = true;
            return true;
        }
        return false;
    }
    //pornim autentifcicarea in 2 factori
    public void enable_twoFactor_Auth(){
        this.twoFactor_Auth = true;
    }
    //oprim autentificarea in 2 factori
    public void disable_twoFactor_Auth(){
        this.twoFactor_Auth = false;
    }
    public boolean isAuthenticated(){
        return isAuthenticated;
    }
    public void addAccount(Account account) {
        accounts.add(account);
        account.setUser(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTwoFactor_Auth() {
        return twoFactor_Auth;
    }

    public void setTwoFactor_Auth(boolean twoFactor_Auth) {
        this.twoFactor_Auth = twoFactor_Auth;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
