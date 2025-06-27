package com.example.mockito_void_exception;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        MailSender mockSender = Mockito.mock(MailSender.class);

       
        doThrow(new RuntimeException("Email server down"))
                .when(mockSender).sendEmail("Important update");

       
        NotificationService service = new NotificationService(mockSender);

      
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.notifyUser("Important update");
        });

        assertEquals("Email server down", exception.getMessage());

       
        verify(mockSender).sendEmail("Important update");
    }
}

