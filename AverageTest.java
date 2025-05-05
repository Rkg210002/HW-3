import static org.junit.Assert.*;
import org.junit.Test;

public class AverageTest {

    @Test
    public void testNormalCase() {
        assertEquals(20, new Average().average(3, new int[]{10, 20, 30, 40, 50}));
    }

    @Test
    public void testKZero() {
        assertEquals(0, new Average().average(0, new int[]{1, 2, 3}));
    }

    @Test
    public void testKGreaterThanList() {
        assertEquals(5, new Average().average(6, new int[]{5, 5, 5}));
    }

    @Test
    public void testEmptyList() {
        assertEquals(0, new Average().average(3, new int[]{}));
    }

    @Test
    public void testNegativeK() {
        assertEquals(0, new Average().average(-1, new int[]{1, 2, 3}));
    }
}