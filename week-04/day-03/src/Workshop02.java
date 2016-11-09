/**
 * Created by BB on 2016-11-09.
 */
import java.util.*;

public class Workshop02 {
    public static void main(String[] args) {
        String[] numbers = new String[] { "one", "two", "three", "four", "five"};

        try {
            for (int i = 0; i <= numbers.length; i++) {
                System.out.print(i + "=" + numbers[i] + "\n");

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("I'm sorry Dave, I'm afraid your array index is out of bounds.");
        }
        System.out.println("::::FINISH LINE::::");
    }
}
