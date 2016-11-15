/**
 * Created by BB on 2016-11-15.
 */

public class Animal {

    public Animal() {
        System.out.println("Animal created.");
    }

    public Animal(String type) {
        System.out.printf("%s animal created.\n", type);
    }


    public void eat() {
        System.out.println("This animal is eating.");
    }

    public void sleep() {
        System.out.println("This animal is sleeping.");
    }


}
