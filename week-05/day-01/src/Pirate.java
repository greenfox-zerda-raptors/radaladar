import java.util.Random;

/**
 * Created by BB on 2016-11-14.
 */

public class Pirate {
    int intoxication;
    boolean isDead;
    boolean isSleeping;
    boolean hasParrot;
    boolean isCaptain;

    public Pirate(){
        this.intoxication = 0;
        this.isDead = false;
        this.isSleeping = false;
        this.hasParrot = false;
    }
    public void drinkSomeRum(){
        if (this.isDead) {
            System.out.println("He's dead, Jim.");
        } else if (!(this.isSleeping)){
            intoxication++;
        } else {
            System.out.println("This pirate is sleeping. Bad pirate, no drinks for you!");
        }
    }
    public void howsItGoingMate(){
        if (this.isDead) {
            System.out.println("He's dead, Jim.");
        } else if (this.isSleeping) {
            System.out.println("This pirate is sleeping, he cannot respond.");
        } else if (this.intoxication < 5) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            System.out.println("The pirate passes out.");
            this.isSleeping = true;
        }
    }
    public void die() {
        this.isDead = true;
        System.out.println("This pirate is dead.");
    }
    public void brawl(Pirate enemy){
        if (this.isDead || enemy.isDead) {
            System.out.println("Dead pirates can't fight.");
        } else {
            Random rand = new Random();
            int arghhh = rand.nextInt(2);
            switch (arghhh) {
                case 0:
                    this.isDead = true;
                    System.out.println("Your pirate is dead.");
                    break;
                case 1:
                    enemy.isDead = true;
                    System.out.println("The enemy pirate is dead.");
                    break;
                case 2:
                    this.isSleeping = true;
                    this.isSleeping = true;
                    System.out.println("Both pirates passed out.");
            }
        }
    }

    public void giveParrot() {
        this.hasParrot = true;
        this.isCaptain = true;
    }
}
