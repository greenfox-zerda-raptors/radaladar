/**
 * Created by BB on 2016-11-15.
 */

public class Animal {
    public int lifeExpectancy;
    public boolean isCarnivore;

    public Animal() {
        this.lifeExpectancy = 10;
        this.isCarnivore = false;
        System.out.println("Animal created.");
    }

    public Animal(String type, int lifeExpectancy, boolean isCarnivore) {
        this.lifeExpectancy = lifeExpectancy;
        this.isCarnivore = isCarnivore;
        System.out.printf("%s animal created.\n", type);
    }

    public Animal(int lifeExpectancy, boolean isCarnivore) {
        this.lifeExpectancy = lifeExpectancy;
        this.isCarnivore = isCarnivore;
        System.out.println("Animal created.");
    }

    public void eat() {
        System.out.println("This animal is eating.");
    }

    public void sleep() {
        System.out.println("This animal is sleeping.");
    }

    public void speak() {
        System.out.println("This animal speaks.");
    }

    public String toString(){
        return  "isCarnivore="+isCarnivore+", lifeExpectancy="+lifeExpectancy;
    }
}
