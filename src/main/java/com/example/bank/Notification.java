package com.example.bank;

import java.util.Date;
public class Notification {
    private String message;
    private Date date;
    private String notificationType;

    public Notification(String message, Date date, String notificationType) {
        this.message = message;
        this.date = date;
        this.notificationType = notificationType;
    }
    public void sendNotification(User user){
        System.out.println("Sending notification to " + user.getUsername() + ": " + message);
    }
}
