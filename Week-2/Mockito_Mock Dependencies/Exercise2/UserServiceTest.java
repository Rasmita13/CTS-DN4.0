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
    public void testGetUserById_ReturnsUser() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("Alice");

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

       
        User result = userService.getUserById(userId);

      
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userRepository).findById(userId);
    }

    @Test
    public void testGetUserById_UserNotFound() {
        
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        
        User result = userService.getUserById(userId);

        // Assert
        assertNull(result);
        verify(userRepository).findById(userId);
    }
}

