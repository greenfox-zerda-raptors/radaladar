import com.greenfox.bx.*;
import java.util.ArrayList;

public class App2 {

    final static String[] lsDow = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        ArrayList<Reservation> bookings = new ArrayList<Reservation>();
        int ct = 10;

        for (int i = 0; i < ct; i++) {
            bookings.add(new Reservation(randomDow(10)));
        }

        for (Reservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }
    }

    static String randomDow(int ct) {
        return lsDow[(int) (Math.random() * 6)];
    }
}
