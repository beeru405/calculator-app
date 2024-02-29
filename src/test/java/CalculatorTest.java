// CalculatorTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(4, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.divide(6, 3), 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        // Expecting an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }
}
