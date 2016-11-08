/**
 * Created by BB on 2016-11-08.
 */
import java.util.*;

public class Workshop13 {
    public static void main(String... args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("first", "second", "third", "fourth", "fifth"));
        // Print all elements of the list using a for loop and an Iterator
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("---");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}