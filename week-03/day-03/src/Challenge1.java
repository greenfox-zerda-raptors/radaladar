/**
 * Created by BB on 2016-11-04.
 */
import java.util.Arrays;

public class Challenge1 {
    public static void main(String... args) {
        int number = 783329;
        int len = Integer.toString(number).length();
        int[] digits = new int[len];
        long revNum = 0;

        for (int i = 0; i < len; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        for(int i=0;i<digits.length;i++){
            System.out.print(digits[i]+" ");
        }
        System.out.println("");
        System.out.println("---");

        Arrays.sort(digits);
        for(int i=0;i<digits.length;i++){
            System.out.print(digits[i]+" ");
        }
        System.out.println("");
        System.out.println("---");

        for(int i = 0; i < digits.length / 2; i++)
        {
            int temp = digits[i];
            digits[i] = digits[digits.length - i - 1];
            digits[digits.length - i - 1] = temp;
        }

        for(int i=0;i<digits.length;i++){
            System.out.print(digits[i]+" ");
        }
        System.out.println("");
        System.out.println("---");

        for(int i=0;i<digits.length;i++){
            long temp = digits[i];
            for(int j = len- i -1; j >= 0; j--) {
                if (j > 0 ){
                    temp *= 10;
                }
                System.out.println(temp);
            }
            revNum += temp;
            System.out.println("végeszám: "+ revNum);
        }
    }
}
