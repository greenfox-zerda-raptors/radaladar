/**
 * Created by BB on 2016-11-07.
 */
import java.util.*;

public class Workshop08{
    public static void main(String... args){
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        // Check if the arrayList contains "7" if it contains print "Hoorray" otherwise print "Noooooo"
        String out = (arrayList.contains(7)) ? "Hoorray" : "Noooooo";
        System.out.println(out);
        }
        }