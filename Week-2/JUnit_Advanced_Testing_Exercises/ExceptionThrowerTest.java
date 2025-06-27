import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {

    @Test
    void testThrowException() {
        // Arrange
        ExceptionThrower exceptionThrower = new ExceptionThrower();

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
            () -> exceptionThrower.throwException());

        // Assert (check the exception message if needed)
        assertEquals("This is an illegal argument!", thrown.getMessage());
    }
}

