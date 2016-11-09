/**
 * Created by BB on 2016-11-09.
 */
import java.util.*;

public class Workshop04{
    public static void main(String[] args){

        int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8};
        String two = "2";

        System.out.println("Testing ...");
        try {a[2] = a[3]/a[0];} catch (ArithmeticException e1)  {System.out.println(e1);}
        System.out.println("Past hurdle 1");
        try {a[9] = Integer.parseInt(two);} catch (Exception e2) {System.out.println(e2);}
        System.out.println("Past hurdle 2");
        try {a[10] = Integer.parseInt("ten");} catch (Exception e3) {System.out.println(e3);}
        System.out.println("Past hurdle 3...  And I realized perhaps I'm wrong");
        try {a[10] = 10;} catch (Exception e4) {System.out.println(e4);}
        System.out.println("Past hurdle 4");
        try {two = "two";} catch (Exception e5) {System.out.println(e5);}
        System.out.println("Past hurdle 5");
        try {a[9] = Integer.parseInt(two);} catch (Exception e6) {System.out.println(e6);}


        System.out.println("*** FINISH LINE ***");
    }
}