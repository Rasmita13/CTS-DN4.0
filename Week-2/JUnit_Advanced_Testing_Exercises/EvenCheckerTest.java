import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 10, 100})
    void testIsEven_forEvenNumbers(int number) {
        // Arrange
        EvenChecker evenChecker = new EvenChecker();

        // Act
        boolean result = evenChecker.isEven(number);

        // Assert
        assertTrue(result, number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 9, 99})
    void testIsEven_forOddNumbers(int number) {
        // Arrange
        EvenChecker evenChecker = new EvenChecker();

        // Act
        boolean result = evenChecker.isEven(number);

        // Assert
        assertFalse(result, number + " should be odd");
    }
}
