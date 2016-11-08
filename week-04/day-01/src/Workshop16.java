/**
 * Created by BB on 2016-11-08.
 */
import java.util.*;

public class Workshop16 {
    public static void main(String... args) {
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7 ));
        // Fix this code fragment! It should remove every even number from the list.

        for(int i = 0; i < al.size(); i++) {
            if(al.get(i) % 2 == 0){
                al.remove(i);
            }
        }
        System.out.println(al);
    }
}

