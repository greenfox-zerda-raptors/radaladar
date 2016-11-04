/**
 * Created by BB on 2016-11-04.
 */
public class Workshop17 {
    public static void main(String[] args) {
        String ag = "kuty";
        ag = endA(ag);
        System.out.println(ag);
    }
        // write a function that gets a string as an input
        // and appends an 'a' character to its end
    public static String endA(String i) {
        i += "a";
        return i;
    }
}
