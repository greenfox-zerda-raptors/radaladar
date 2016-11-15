/**
 * Created by BB on 2016-11-15.
 */
public class Workshop03 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird();
        Dog dog = new Dog();

        System.out.println("Testing Animal");
        animal.speak();
        animal.sleep();
        System.out.println(animal.toString());

        System.out.println("\nTesting Bird");
        bird.speak();
        bird.sleep();
        bird.fly();
        System.out.println("And a bird: " + animal.toString());

        System.out.println("\nTesting Dog");
        dog.speak();
        dog.sleep();
        dog.beg();
        System.out.println("And a dog: " + animal.toString());


        System.out.println("\nTesting Dog2");
        Animal dog2 = new Dog();
        dog2.speak();
        dog2.sleep();
        ((Dog)dog2).beg();
        ((Dog) dog2).hasTail = false;
        dog2.lifeExpectancy = 22;
        System.out.println("And this dog2: " + dog2.toString() +", and hasTail=" + ((Dog) dog2).hasTail);

        System.out.println("\nTesting Dog 'd'");
        Dog d = new Dog();
        d.speak();
        d.sleep();
        d.lifeExpectancy = 15;
        System.out.println("And this dog2: " + d.toString());
    }
}