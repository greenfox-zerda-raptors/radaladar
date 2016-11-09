/**
 * Created by BB on 2016-11-09.
 */
public class Workshop10{

    public static void main(String  args[]) {

        // you'll be putting these in try/catch and looking at the exception message; then figuring
        // out how to trap for that specific exception to continue through the code.

        String strTest=null;
        System.out.println("Hurdle 01");
        try {
            System.out.println(strTest.length());
        } catch (NullPointerException e1) {
            System.out.println("Don't try me, boy.");
        }

        strTest="The quick brown fox jump over the lazy dog";
        System.out.println("Hurdle 02: Setup");
        System.out.println(strTest.length());

        char c = strTest.charAt(0);
        System.out.println("Char 0 = " + c);
        System.out.println("Hurdle 02: Catch");

        try {
            c = strTest.charAt(strTest.length()); // I'm numerically challenged here
        } catch (StringIndexOutOfBoundsException e2) {
            System.out.println("You're testing my patience.");
        }

        System.out.println("Hurdle 03");

        try {
            int num = Integer.parseInt(strTest);
        } catch (NumberFormatException e3) {
            System.out.println("That's it, I'm out.");
        }
        System.out.println("--- AGAIN ---");
        try {
            strTest = null;
            System.out.println("Hurdle 01");
            System.out.println(strTest.length());

            strTest = "The quick brown fox jump over the lazy dog";
            System.out.println("Hurdle 02: Setup");
            System.out.println(strTest.length());

            c = strTest.charAt(0);
            System.out.println("Char 0 = " + c);

            System.out.println("Hurdle 02: Catch");
            c = strTest.charAt(strTest.length()); // I'm numerically challenged here

            System.out.println("Hurdle 03");
            int num = Integer.parseInt(strTest);
        } catch (Exception e4) {
            System.out.println("Stop it. This is silly.");
        }
    }
}
