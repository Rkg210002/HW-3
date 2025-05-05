# HW-3
(a) Functional Description 
The average function calculates the average of the first k elements of an integer array list. If k is larger than the size of the array, the function considers only list.length elements. If k (or list.length) is zero or negative, the function returns 0.

(b) Functional Test Case
Test Case:
average(3, new int[]{10, 20, 30, 40, 50}) → returns 20

Explanation: It sums the first 3 elements (10 + 20 + 30 = 60) and divides by 3 → 60 / 3 = 20.

(c) Partition Test Cases

Partitions:

k <= 0



k > list.length



0 < k <= list.length



list.length == 0



Partition Test Cases:

average(0, new int[]{1, 2, 3}) → 0   // Partition 1

average(6, new int[]{5, 5, 5}) → 5   // Partition 2

average(2, new int[]{4, 6, 8}) → 5   // Partition 3

average(3, new int[]{}) → 0         // Partition 4




(d) Boundary Value Test Cases 
Test Cases:
average(1, new int[]{100}) → 100        // Minimum non-zero list
average(1, new int[]{50, 60}) → 50      // Minimum k = 1
average(Integer.MAX_VALUE, new int[]{1, 2, 3}) → 2 // Check capping at list.length
average(-1, new int[]{1, 2, 3}) → 0     // Negative k
average(3, new int[]{0, 0, 0}) → 0      // All zero values

(e) JUnit Test Code 
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


(f) Fault Injection and Analysis
Injected Fault: Change int n = Math.min(k, list.length); to int n = Math.max(k, list.length);
Expected Failures:
assertEquals(5, new Average().average(6, new int[]{5, 5, 5})); // Will likely throw ArrayIndexOutOfBoundsException

Fix: Revert Math.max to Math.min.
Analysis: The injected fault causes the function to try accessing more elements than exist in the list, leading to a runtime exception. This demonstrates that test cases effectively catch such boundary errors.

(g) Code Coverage 
To measure coverage using EclEmma in Eclipse:
Open Eclipse → Right-click on the test file → Choose Coverage As → JUnit Test.


Look at the coverage view:


Ensure 100% branch coverage: All if, for and error-handling paths are tested.


If not 100%, add cases like:


k < 0


list.length == 0


k == list.length



