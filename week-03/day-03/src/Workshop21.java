/**
 * Created by BB on 2016-11-04.
 */
public class Workshop21 {

    public static void main(String[] args) {
        int a = 5;
        System.out.println(factorial(a));
    }

    /* create a recursive (!!!!!) function that returns it's input factorial */

    public static long factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n-1);
    }
}
