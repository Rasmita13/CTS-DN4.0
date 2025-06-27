package com.example.mockito_demo;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {

    @Test
    public void testSendNotificationCalledWithCorrectArgument() {
       
        NotificationApi mockApi = Mockito.mock(NotificationApi.class);

        
        NotificationService service = new NotificationService(mockApi);
        service.sendNotification("Hello");

        
        verify(mockApi).send("Hello");
    }
}

