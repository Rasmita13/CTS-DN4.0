package com.example.mockito_matcher;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MessageServiceTest {

    @Test
    public void testSendWithAnyString() {
        
        MessageApi mockApi = Mockito.mock(MessageApi.class);

        
        MessageService service = new MessageService(mockApi);
        service.sendGreeting();

        
        verify(mockApi).send(anyString()); 
    }

    @Test
    public void testSendWithStringStartingWithHi() {
        MessageApi mockApi = Mockito.mock(MessageApi.class);
        MessageService service = new MessageService(mockApi);
        service.sendGreeting();

        // Use custom argument matcher (lambda)
        verify(mockApi).send(argThat(msg -> msg.startsWith("Hi")));
    }
}

