/**
 * Created by BB on 2016-11-09.
 */
import java.util.*;

public class Workshop08{

    public static void myMethod(int testnum) throws Exception {
        if (testnum == 7) {
            throw new Exception();
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int age;
        String prompt = "Enter any number, 0 to exit? > ";

        System.out.print(prompt);
        while (userInput.hasNextInt()) {
            age = userInput.nextInt();
            if (age == 0) {
                break;
            } else {
                try {
                    System.out.println("trying number");
                    myMethod(age);
                    System.out.println(age);
                    System.out.println("valid number");
                } catch (Exception ex) {
                    System.out.println("an exception occurred");
                    System.out.println("seven is a shit number");
                } finally {
                    System.out.print(prompt);
                }
            }
        }
        System.out.println("::::FINISH LINE::::");
    }
}
