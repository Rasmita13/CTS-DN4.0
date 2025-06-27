import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS) 
    void testPerformTask() {
        // Arrange
        PerformanceTester tester = new PerformanceTester();

        // Act
        tester.performTask();

        // Assert
        assertTrue(true, "Task completed within the time limit.");
    }
}

