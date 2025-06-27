import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
 
public class CalculatorTestWithSetup {

    private Calculator calculator;

    // This method will run BEFORE EACH test
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup Complete");
    }

    // This method will run AFTER EACH test
    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Teardown Complete");
    }

    @Test
    void testAdd() {
        // Arrange
        int a = 2, b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testAddWithNegativeNumber() {
        // Arrange
        int a = -1, b = 1;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(0, result);
    }
}
