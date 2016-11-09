/**
 * Created by BB on 2016-11-09.
 */

import java.util.*;
public class Workshop03b {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        Integer number = 1;
        String s ;
        while (number !=0 ) {
            number = checkIfValid();
            s = number.toString();
            System.out.println("Yum  " +  s.substring(0,s.length()/2));
        }
    }
    public static Integer checkIfValid() {
        int i =0;
        boolean flLoop = true;
        while (flLoop) {
            System.out.print("Type in a number > ");
            i = userInput.nextInt();
            flLoop = false;
            userInput.nextLine();
        }
        return i;
    }
}

// I swear these worked at one point.
