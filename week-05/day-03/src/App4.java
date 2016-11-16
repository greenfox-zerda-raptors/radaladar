import com.greenfox.bx.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by BB on 2016-11-16.
 */

public class App4 {
    final static String[] lsDow = { "MON","TUE","WED","THU","FRI","SAT","SUN"};

    public static void main (String[] args) {
        ArrayList<CreditCardReservation> bookings = new ArrayList<CreditCardReservation>();
        int ct = 10;

        for (int i = 0; i<ct; i++) {
            bookings.add(new CreditCardReservation(randomDow(10),"DEF" + i , random16()));
        }

        for (CreditCardReservation iBooking: bookings){
            System.out.println(iBooking.toString());
        }

        CreditCardReservation[] reservations = new CreditCardReservation[10];
        for (int i = 0; i<ct; i++) {
            reservations[i] = (new CreditCardReservation(randomDow(10),"DEF" + i , random16()));
        }
        System.out.printf("\nSort by reservation code ascending ---------------------\n");
        Arrays.sort(reservations, ReservedByCode);
        for (CreditCardReservation iBooking: reservations){
            System.out.println(iBooking.toString());
        }
        System.out.printf("\nSort by reservation code descending ---------------------\n");
        Arrays.sort(reservations, ReservedByCodeDesc);
        for (CreditCardReservation iBooking: reservations){
            System.out.println(iBooking.toString());
        }
        System.out.printf("\nSort by credit card code ascending ---------------------\n");
        Arrays.sort(reservations, ReservedByNum);
        for (CreditCardReservation iBooking: reservations){
            System.out.println(iBooking.toString());
        }
        System.out.printf("\nSort by credit card code descending ---------------------\n");
        Arrays.sort(reservations, ReservedByNumDesc);
        for (CreditCardReservation iBooking: reservations){
            System.out.println(iBooking.toString());
        }
        System.out.printf("\nSort by Day of Week ascending ---------------------\n");
        Arrays.sort(reservations, ReservedByDoW);
        for (CreditCardReservation iBooking: reservations){
            System.out.println(iBooking.toString());
        }
        System.out.printf("\nSort by Day of Week descending ---------------------\n");
        Arrays.sort(reservations, ReservedByDoWDesc);
        for (CreditCardReservation iBooking: reservations){
            System.out.println(iBooking.toString());
        }
    }

    static String randomDow(int ct) {
        return lsDow[(int) (Math.random() * 6)];
    }

    static String random16() {
        String out ="";
        for(int i = 0; i<16; i++) {
            out += Integer.toString( (int) ( Math.random() * 9));
        }
        return out;
    }

    public static Comparator<CreditCardReservation> ReservedByCode = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String left = res1.getCodeBooking().toUpperCase();
            String right = res2.getCodeBooking().toUpperCase();
            return left.compareTo(right);
        }
    };

    public static Comparator<CreditCardReservation> ReservedByCodeDesc = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String right = res1.getCodeBooking().toUpperCase();
            String left = res2.getCodeBooking().toUpperCase();
            return left.compareTo(right);
        }
    };

    public static Comparator<CreditCardReservation> ReservedByNum = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String left = res1.getCodeAccount().toUpperCase();
            String right = res2.getCodeAccount().toUpperCase();
            return left.compareTo(right);
        }
    };
    public static Comparator<CreditCardReservation> ReservedByNumDesc = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String right = res1.getCodeAccount().toUpperCase();
            String left = res2.getCodeAccount().toUpperCase();
            return left.compareTo(right);
        }
    };
    public static Comparator<CreditCardReservation> ReservedByDoW = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String left = Integer.toString(Arrays.asList(lsDow).indexOf(res1.getDowBooking()));
            String right = Integer.toString(Arrays.asList(lsDow).indexOf(res2.getDowBooking()));
            return left.compareTo(right);
        }
    };
    public static Comparator<CreditCardReservation> ReservedByDoWDesc = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String right = Integer.toString(Arrays.asList(lsDow).indexOf(res1.getDowBooking()));
            String left = Integer.toString(Arrays.asList(lsDow).indexOf(res2.getDowBooking()));
            return left.compareTo(right);
        }
    };

}
