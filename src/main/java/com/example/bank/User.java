package com.example.bank;

public class User {
    private String username;
    private String password;
    private boolean twoFactor_Auth;
    private boolean isAuthenticated;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        twoFactor_Auth = false;
        isAuthenticated = false;
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

}
