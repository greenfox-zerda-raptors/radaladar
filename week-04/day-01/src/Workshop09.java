/**
 * Created by BB on 2016-11-07.
 */
import java.util.*;

public class Workshop09{
    public static void main(String... args){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("second", "third", "fourth"));
        // Add "first" to the beginning of the list and add "fifth" to the end of the list
        // Expected output: [first, second, third, fourth, fifth]
        list.add(0, "first");
        list.add("fifth");
        System.out.println(list);
    }
}
