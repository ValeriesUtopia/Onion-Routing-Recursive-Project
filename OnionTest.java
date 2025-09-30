import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OnionTest {

    /** Tests flipping a single binary digit. */
    @Test
    public void testSingleDigit() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1));
        Algorithms algo = new Algorithms(input);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
        assertTrue(algo.equals(expected));
    }

    /** Tests flipping three binary digits. */
    @Test
    public void testThreeDigits() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 0, 1));
        Algorithms algo = new Algorithms(input);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 0));
        assertTrue(algo.equals(expected));
    }

    /** Tests flipping five binary digits. */
    @Test
    public void testFiveDigits() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1));
        Algorithms algo = new Algorithms(input);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0));
        assertTrue(algo.equals(expected));
    }
}