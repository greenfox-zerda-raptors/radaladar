/**
 * Created by BB on 2016-11-03.
 */
public class Challenge2 {
    public static void main(String[] args) {
        //Loop printing out prime numbers from 2 to 100
        for (int i = 2; i < 100; i++) {
            Boolean is_prime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime == true) {
                System.out.println(i);
            }
        }
    }
}
