/**
 * Created by BB on 2016-11-04.
 */
public class Workshop19 {
    public static void main(String[] args) {
        int a = 31;
        System.out.println(factorial(a));
    }

    // create a function that returns it's input factorial

    public static int factorial(int a) {
        int out = 1;
        for (int i = 1; i <= a; i++) {
            out *= i;
        }
        return out;
    }
}
