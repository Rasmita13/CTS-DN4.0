package com.example.mockito_matcher;

public class MessageService {
    private final MessageApi api;

    public MessageService(MessageApi api) {
        this.api = api;
    }

    public void sendGreeting() {
        api.send("Hi there!");
    }
}

