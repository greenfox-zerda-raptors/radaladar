package primeFactors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BB on 2016-11-22.
 */

public class Primefactors {

    public static List<Integer> generate(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    result.add(i);
                    n /= i;
                }
            }
        }
        return result;
    }
}
