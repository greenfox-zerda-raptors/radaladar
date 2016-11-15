/**
 * Created by BB on 2016-11-15.
 */
public class Bird extends Animal {

    public Bird() {
       super("Bird", 2, false);

    }
    public void fly() {
        System.out.println("This bird is flying.");
    }

    public void sleep() {
        System.out.println("This bird is sleeping.");
        super.sleep();
    }

    public void eat() {
        System.out.println("This bird is eating.");
    }

    public void nightyNight() {
        super.eat();
        this.sleep();
    }
}
