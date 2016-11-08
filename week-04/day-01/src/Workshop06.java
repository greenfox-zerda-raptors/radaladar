/**
 * Created by BB on 2016-11-07.
 */
import java.util.*;

public class Workshop06{
    public static void main(String... args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        // Accidentally we added number 3 twice. Your task is to remove it from the list
        arrayList.remove(2);
        System.out.println(arrayList);
    }
}