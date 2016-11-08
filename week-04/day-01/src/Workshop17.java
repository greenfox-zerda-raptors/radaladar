/**
 * Created by BB on 2016-11-08.
 */
import java.util.*;

public class Workshop17 {

    // Implement trimAll(..)
    // Expected output:
    // "first"
    // "second"
    // "third"
    // "fourth"
    // "fifth"

     public static void main(String... args) {
        List<String> strList = new ArrayList<String>(Arrays.asList("   first", "second   ", "  third ", "fourth", "    fifth "));
        trimAll(strList);
        for (String str : strList) {
            System.out.format("\"%s\"%n", str);
        }
    }

    public static void trimAll(List<String> strings) {
        ListIterator<String> it = strings.listIterator();
        while (it.hasNext()) {
            String trimThis = it.next();
            it.set(trimThis.trim());
        }
    }
}