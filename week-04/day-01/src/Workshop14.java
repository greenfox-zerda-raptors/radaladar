/**
 * Created by BB on 2016-11-08.
 */
import java.util.*;

public class Workshop14 {
    public static void main(String... args) {
        ArrayList<String> al = new ArrayList<String>(Arrays.asList("kuty", "macsk", "kacs", "rók"));
        // Add "a" to every string in al. Use an iterator!
        ListIterator it = al.listIterator();
        while (it.hasNext()) {
            Object addTo = it.next();
            it.set(addTo +"a");
        }
        System.out.println(al);
    }
}