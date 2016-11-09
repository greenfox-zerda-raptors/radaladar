/**
 * Created by BB on 2016-11-09.
 */
import java.util.*;

public class Workshop07 {

    public static void myMethod(int testnum) throws Exception {
        if (testnum == 7) {
            throw new Exception();
        }
    }


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int age;
        String prompt = "Enter any number, 0 to exit?";

        System.out.println(prompt);
        while (userInput.hasNextInt()) {
            age = userInput.nextInt();
            if (age == 0) {
                break;
            } else {
                try {
                    System.out.println("try - first statement");
                    myMethod(age);
                    System.out.println("try - last statement");
                } catch (Exception ex) {
                    System.out.println("An Exception");
                }
            }
        }
    }
}
