package com.example.mockito_multi;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MultiServiceTest {

    @Test
    public void testMultipleReturns() {
        
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchStatus()).thenReturn("READY", "PROCESSING");
        MultiService service = new MultiService(mockApi);
        String result = service.getFullStatus();
        assertEquals("READY & PROCESSING", result);
    }
}

