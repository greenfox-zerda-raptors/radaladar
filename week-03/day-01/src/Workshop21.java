/**
 * Created by BB on 2016-11-02.
 */

public class Workshop21{
    public static void main(String... args){
        String proverb = "If it ain't broke, don't fix it.";
        // Print the "don't fix it" part using the proverb variable
//        int a = proverb.indexOf("don't");
//        int b = proverb.indexOf(".");
//        System.out.println(proverb.substring(a, b));
        System.out.println(proverb.substring(proverb.indexOf("don't"), proverb.indexOf(".")));
    }
}