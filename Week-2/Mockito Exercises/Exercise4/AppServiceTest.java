package com.example.mockito_void;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AppServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        
        Logger mockLogger = Mockito.mock(Logger.class);
        AppService service = new AppService(mockLogger);
        service.startProcess();
        verify(mockLogger).log("Starting process...");
    }
}

