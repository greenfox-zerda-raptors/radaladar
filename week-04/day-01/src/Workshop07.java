/**
 * Created by BB on 2016-11-07.
 */
import java.util.*;

public class Workshop07{
    public static void main(String... args){
        ArrayList<String> arrayList = new ArrayList<String>();
        int random = new Random().nextInt(20);
        for(int i=0;i<20;i++){
            if(i == random){
                arrayList.add("removable");
            }
            arrayList.add("" + i);
        }
        // Remove "removable" from the list, but without using the index of the element.
        arrayList.remove("removable");
        System.out.println(arrayList);
    }
}
