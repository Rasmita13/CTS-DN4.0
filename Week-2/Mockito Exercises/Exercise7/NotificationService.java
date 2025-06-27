package com.example.mockito_void_exception;

public class NotificationService {
    private final MailSender sender;

    public NotificationService(MailSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String msg) {
        sender.sendEmail(msg);
    }
}

