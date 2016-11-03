/**
 * Created by BB on 2016-11-03.
 */
public class Workshop37 {
    public static void main(String[] args) {
        // Write a program which has this output
        //# # # # # # #
        //  # # # # # # #
        // # # # # # # #
        //  # # # # # # #
        // # # # # # # #
        //  # # # # # # #
        // # # # # # # #
        // The # character should be replacable, hence store it in a variable

        String a = "#";
        int l = 7;
        for (int i = 1; i < l + 1; i++) {
            String out = a;
            if (i % 2 == 0) {
                out = "  " + a;
            } // else {
              //  String out = "  " + a;
            //}
            for (int j = 1; j < l; j++) {
                out += " " + a;
            }
            System.out.println(out);
        }
    }
}
