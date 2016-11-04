/**
 * Created by BB on 2016-11-04.
 */
public class Workshop18 {
    public static void main(String[] args) {
        int lim = 16;
        System.out.println(sums(lim));
    }
        // write a function that sum all the numbers until the given parameter
    public static int sums(int i) {
        int out = 0;
        for (int j = 1; j <= i; j++) {
            out += j;
        }
        return out;

    }
}
