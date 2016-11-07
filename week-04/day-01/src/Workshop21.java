/**
 * Created by BB on 2016-11-07.
 */
public class Workshop21{
    public static void main(String... args){
        StringBuilder sb = new StringBuilder("first third fourth");
        // Add "second" to the StringBuilder (sb) between the words "first" and "third"
        // Expected output: first second third fourth
        sb.insert("first".length(), " second");


        System.out.println(sb.toString());
    }
}