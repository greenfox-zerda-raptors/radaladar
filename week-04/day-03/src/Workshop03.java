/**
 * Created by BB on 2016-11-09.
 */

import java.util.*;

public class Workshop03 {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){
        Integer number = 1;
        while (number != 0) {
            number = divideTwo();
        }
        System.out.println("::: END :::");
    }

    public static Integer divideTwo() {
        System.out.print("INPUT or 0 to end?    > ");
        Integer num = 1;

        try {
            num = userInput.nextInt();
            Integer c = Math.addExact(num, 1);
        } catch (InputMismatchException e){
            System.out.println("I'm sorry Dave, I'm afraid that is not a number.");
            System.out.println(e);
            return 2;
        } catch (ArithmeticException e) {
            System.out.println("I'm sorry Dave, I'm afraid the number you gave me is invalid.");
            System.out.println(e);
            return 2;
        } catch (Exception e) {
            System.out.println("I'm sorry Dave, I'm afraid you are trying to mess with me.");
            System.out.println(e);
            return 2;
        }

            if (num == 0) {
                System.out.println("Bye!");
                return 0;
            } else if (num < 0) {
                System.out.println("I don't like negative numbers.");
                return 2;
            } else {
                System.out.print("Yum   ");
                System.out.println(num/2);
                return 2;
            }

    }
}

// I swear these worked at one point.
