package com.example.bank;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Date date;
    private String notificationType;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public Notification() {
    }

    public Notification(Long id, String message, Date date, String notificationType, User user) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.notificationType = notificationType;
        this.user = user;
    }

    public Notification(String message, Date date, String notificationType) {
        this.message = message;
        this.date = date;
        this.notificationType = notificationType;
    }
    public void sendNotification(User user){
        System.out.println("Sending notification to " + user.getUsername() + ": " + message);
    }
}
