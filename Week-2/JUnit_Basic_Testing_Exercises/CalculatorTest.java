import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        int result = 2 + 3;
        Assert.assertEquals(5, result);
    }
}

