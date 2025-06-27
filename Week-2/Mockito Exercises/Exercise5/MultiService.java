package com.example.mockito_multi;

public class MultiService {
    private final ExternalApi api;

    public MultiService(ExternalApi api) {
        this.api = api;
    }

    public String getFullStatus() {
        // Calls the API twice and combines the results
        String first = api.fetchStatus();
        String second = api.fetchStatus();
        return first + " & " + second;
    }
}

