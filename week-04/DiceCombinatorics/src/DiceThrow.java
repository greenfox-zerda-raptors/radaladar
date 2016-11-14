import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by BB on 2016-11-10.
 */

public class DiceThrow {
        public static void main (String[] args) {
            int kockA = 6;
            int kockB = 6;

            int maxSum = kockA + kockB;
            int[] resultOccurrence = new int[maxSum-1];
            for (int i = 1; i <= kockA; i++) {
                for (int j = 1; j <= kockB; j++) {
                    resultOccurrence[i+j-2]++;
                }
            }
            int count = 2;
            System.out.println("sum     occurs      probab");
            for (int i:resultOccurrence) {
                System.out.print(count);
                System.out.print("      ");
                System.out.print(i);
                System.out.print("          ");
                System.out.print((float) i/(kockA * kockB) * 100);
                System.out.println("%");
                count++;
            }
        }
}
