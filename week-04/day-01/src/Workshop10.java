/**
 * Created by BB on 2016-11-07.
 */
import java.util.*;

public class Workshop10{
    public static void main(String... args){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("first", "sixth", "third", "fourth", "fifth"));
        // Accidentally I added "sixth" instead of "second"! Your task is to swap "sixth" with "second"
        list.remove(1);
        list.add(1, "second");
        System.out.println(list);
    }
}
