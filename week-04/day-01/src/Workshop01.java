/**
 * Created by BB on 2016-11-07.
 */

import java.util.*;

public class Workshop01 {
    public static void main(String... args) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        // Add multiple elements to the list and print the number of the elements>
        for (int i = 0; i < 10; i++){
            arrayList.add(i);
        }
        arrayList.add("sfégkl");
        System.out.println(arrayList.size());
    }
}

