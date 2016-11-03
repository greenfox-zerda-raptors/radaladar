/**
 * Created by BB on 2016-11-03.
 */
public class Workshop36 {
    public static void main(String[] args) {
        // Write a program which has this output
        // # # # # #
        // # # # # #
        // # # # # #
        // # # # # #
        // # # # # #
        // The # character should be replacable, hence store it in a variable

        String a = "#";
        int l = 5;
        for (int i = 0; i < l; i++) {
            String out = a;
            for (int j = 0; j < l; j++){
                out += " " + a;
            }
            System.out.println(out);
        }
    }
}
