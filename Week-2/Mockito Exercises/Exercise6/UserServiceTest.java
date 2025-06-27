package com.example.mockito_order;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class UserServiceTest {

    @Test
    public void testInteractionOrder() {
     
        UserActions mockActions = Mockito.mock(UserActions.class);

    
        UserService service = new UserService(mockActions);
        service.executeSession();

       
        InOrder inOrder = inOrder(mockActions);
        inOrder.verify(mockActions).login();
        inOrder.verify(mockActions).loadDashboard();
        inOrder.verify(mockActions).logout();
    }
}

