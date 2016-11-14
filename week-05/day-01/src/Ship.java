import java.util.ArrayList;
import java.util.Random;

/**
 * Created by BB on 2016-11-14.
 */

public class Ship {
    public ArrayList<Pirate> ship = new ArrayList<Pirate>();


    public void fillShip(int x) {
        this.ship.add(new Pirate());
        this.ship.get(0).giveParrot();

        Random rand = new Random();
        for (int i = 1; i <rand.nextInt(x); i++){
            this.ship.add(new Pirate());
        }
    }

    public void status() {
        if (this.ship.get(0).isDead) {
            System.out.println("The captain is dead.");
        } else if (this.ship.get(0).isSleeping) {
            System.out.println("The captain is sleeping.");
        } else {
            System.out.printf("The captain is alive and has consumed %d units of rum\n", this.ship.get(0).intoxication);
        }
        int counter = 0;
        for (Pirate p : this.ship) {
            if (!(p.isDead)) {
                counter++;
            }
        }
        System.out.printf("%d crewmembers are alive\n", counter);
    }
    public boolean battle(Ship enemyShip) {
        int power = 0 - this.ship.get(0).intoxication;
        for (Pirate p : this.ship) {
            if (!(p.isDead)) {
                power++;
            }
        }
        int enemyPower = 0 - enemyShip.ship.get(0).intoxication;
        for (Pirate p : enemyShip.ship) {
            if (!(p.isDead)) {
                enemyPower++;
            }
        }
        if (power >= enemyPower) {
            Random rand = new Random();
            for (int i = 0; i <rand.nextInt(enemyShip.ship.size()); i++){
                enemyShip.ship.get(i).die();
            }
            for (int i = 0; i <rand.nextInt(); i++){
                this.ship.get(0).drinkSomeRum();
            }
            System.out.printf("We won!\n");
            return true;
        } else {
            Random rand = new Random();
            for (int i = 0; i <rand.nextInt(this.ship.size()); i++){
                this.ship.get(i).die();
            }
            for (int i = 0; i <rand.nextInt(); i++){
                enemyShip.ship.get(0).drinkSomeRum();
            }
            System.out.printf("The enemy won!\n");
            return false;
        }
    }

}
