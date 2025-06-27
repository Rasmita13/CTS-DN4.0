import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class CalculatorTes {

	@Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
    }

    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.multiply(3, 5));
        assertEquals(0, calculator.multiply(0, 10));
    }

    @Test
    void testIsEven() {
        Calculator calculator = new Calculator();
        assertTrue(calculator.isEven(4));
        assertFalse(calculator.isEven(5));
    }
}

