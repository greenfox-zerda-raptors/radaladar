/**
 * Created by BB on 2016-11-03.
 */
public class Workshop35 {
    public static void main(String[] args) {
        // Write a program which has this output
        // 1******
        // 12*****
        // 123****
        // 1234***
        // 12345**
        // 123456*
        // 1234567
        String num = "1234567";
        for (int i = 1; i < num.length()+1; i++) {
            String out = num.substring(0, i);

            for (int j = num.length()-i; j > 0; j--) {
                out = out + "*";
            }
            System.out.println(out);
        }
    }
}
