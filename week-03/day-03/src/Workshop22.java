/**
 * Created by BB on 2016-11-04.
 */
public class Workshop22 {
    public static void main(String... args) {
    printStrings("klj", "soidjf", "lskdjgl", "ldfkjg", "dféokh");
    }
        // create a function which prints the input String parameters (can have multiple number of arguments)
    public static void printStrings(String... args) {
        String out = "";
        for (int i = 0; i < args.length; i++) {
            out += args[i] + " ";
        }
        System.out.println(out);
    }
}
