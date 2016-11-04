/**
 * Created by BB on 2016-11-04.
 */
public class Workshop12 {
    public static void main(String[] args) {
        // Swap the first element of the array
        // Expected outpt: third second first
        String[] abc = new String[] { "first", "second", "third" };
        String swapper = "";
        swapper = abc[1];
        abc[1] = abc[3];
        abc[3] = swapper;

        for(int i = 0; i < abc.length; i++){
            System.out.print(abc[i] + " ");
        }
    }
}
