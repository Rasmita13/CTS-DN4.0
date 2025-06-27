import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void testFirst() {
        System.out.println("Executing Test 1");
        assertTrue(true);
    }

    @Test
    @Order(2)
    void testSecond() {
        System.out.println("Executing Test 2");
        assertTrue(true);
    }

    @Test
    @Order(3)
    void testThird() {
        System.out.println("Executing Test 3");
        assertTrue(true);
    }
}

