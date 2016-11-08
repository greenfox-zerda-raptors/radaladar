/**
 * Created by BB on 2016-11-08.
 */
import java.util.*;

public class Workshop15 {
    public static void main(String... args) {
        ArrayList<String> al = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7" ));
        // Add "a" to every string in al. Use a for(each) loop
        for (String str : al) {
            System.out.println(str+"a");
        }
        //can a for(each) loop modify the arraylist?

    }
}