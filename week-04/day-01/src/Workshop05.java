/**
 * Created by BB on 2016-11-07.
 */
import java.lang.reflect.Array;
import java.util.*;

public class Workshop05 {
    public static void main(String... args) {
        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(12, 1, 532, 23, 0, 7, 54, 32));
        // Copy every element of "numList" to an Array
        Integer[] numArray = new Integer[numList.size()];
        numArray = numList.toArray(numArray);

        for (Integer i : numArray) {
            System.out.println(i);
        }
    }
}