import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testUserNotFoundThrowsException() {
       
        Long userId = 99L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

       
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(userId);
        });

        assertEquals("User not found with id: 99", exception.getMessage());
    }
}

