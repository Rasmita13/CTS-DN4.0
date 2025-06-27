package com.example.mockito_demo;

public class NotificationService {

    private final NotificationApi api;

    public NotificationService(NotificationApi api) {
        this.api = api;
    }

    public void sendNotification(String msg) {
        api.send(msg);
    }
}

