package primeFactors;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by BB on 2016-11-22.
 */

public class PrimeFactorsTests {

    private List<Integer> list(int... inputs) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i : inputs) {
            result.add(i);
        }
        return result;
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(list(), Primefactors.generate(1));
    }

    @Test
    public void testTwo() throws Exception {
        assertEquals(list(2), Primefactors.generate(2));
    }

    @Test
    public void testThree() throws Exception {
        assertEquals(list(3), Primefactors.generate(3));
    }

    @Test
    public void testFour() throws Exception {
        assertEquals(list(2, 2), Primefactors.generate(4));
    }

    @Test
    public void testSix() throws Exception {
        assertEquals(list(2, 3), Primefactors.generate(6));
    }

    @Test
    public void testEight() throws Exception {
        assertEquals(list(2, 2, 2), Primefactors.generate(8));
    }

    @Test
    public void testNine() throws Exception {
        assertEquals(list(3, 3), Primefactors.generate(9));
    }

    @Test
    public void testLast() throws Exception {
        assertEquals(list(3, 5, 823), Primefactors.generate(12345));
    }

}
