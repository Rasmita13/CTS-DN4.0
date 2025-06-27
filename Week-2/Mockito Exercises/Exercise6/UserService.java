package com.example.mockito_order;

public class UserService {
    private final UserActions actions;

    public UserService(UserActions actions) {
        this.actions = actions;
    }

    public void executeSession() {
        actions.login();
        actions.loadDashboard();
        actions.logout();
    }
}

