import java.util.ArrayList;

/**
 * Created by BB on 2016-11-14.
 */
public class Workshop03 {
    public static void main(String[] args) {
        ArrayList<Pirate> Pirates = new ArrayList<Pirate>();

        for (int i = 0; i < 5; i++) {
            Pirates.add(new Pirate());
        }

        for (int i = 0; i <6; i++) {
            Pirates.get(0).drinkSomeRum();
            Pirates.get(0).howsItGoingMate();
        }

        Pirates.get(1).die();
        Pirates.get(2).brawl(Pirates.get(1));
        Pirates.get(2).brawl(Pirates.get(3));

        System.out.println("------------------------------------------------------");

        Ship pirateShip01 = new Ship();
        Ship pirateShip02 = new Ship();
        pirateShip01.fillShip(200000);
        pirateShip02.fillShip(200000);
        pirateShip01.status();
        pirateShip02.status();
        pirateShip01.battle(pirateShip02);
        pirateShip01.status();
        pirateShip02.status();

    }
}
