/**
 * Created by BB on 2016-11-16.
 */
import java.util.ArrayList;
import com.greenfox.bx.*;
//there's another import missing (if you set this up right

public class App3 {

    public static void main(String[] args) {


        ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
        int ct = 10;

        for (int i = 0; i<ct; i++) {
            cards.add(new CreditCard("ABC" + i, random16()));
        }

        for (CreditCard iCard: cards) {
            System.out.println(iCard.toString());
        }

    }

    static String random16() {
        String out ="";
        for(int i = 0; i<16; i++) {
            out += Integer.toString( (int) ( Math.random() * 9));
        }

        return out;
    }
}