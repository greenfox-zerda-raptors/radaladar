package guava;

import java.util.Collection;
import java.util.List;

/**
 * Created by kicsen on 2016. 11. 30..
 */
public class GuavaTasks {

    List<Car> cars;
    Collection<String> carTitles;

    public GuavaTasks() {
        initCars();
    }

    private void initCars() {
        Car car1 = new Car(1, "Audi", 52642, "A4");
        Car car2 = new Car(2, "Mercedes", 57127, "");
        Car car3 = new Car(3, "Skoda", 9000, null);
        Car car4 = new Car(4, "Volvo", 29000, "XC90");
        Car car5 = new Car(4, "Volvo", 12900, "V40");

        // TODO: Initialize cars list with car variables above. You should use Lists.newArrayList() utils of Guava.

        // END of your implementation part
        this.carTitles = generateCarTitles();
    }

    String printCar(Car car) {
        // TODO: Print cars in human readable format without toString implementation. "
        // Hint: MoreObjects.toStringHelper
        return null;
    }

    Collection<String> generateCarTitles() {
        // TODO: Create String collection from title of cars. Title format: name (model) e.g.: Volvo (XC90)
        // Hint: You should use Lists.newArrayList() utils of Guava.
        // Advanced hint: You may try Guava Function/Predicate and Collections2.transform too.
        return null;
    }

    String concatCarTitles(Collection<String> carTitles) {
        // TODO: Build string from carTitles like: "Audi (A4), Mercedes (), Skoda (null), Volvo (XC90), Volvo (V40)"
        // Hint: You should use Guava Joiner.
        return null;
    }

    Collection<String> generateCarTitlesWithoutEmpty(Collection<Car> cars) {
        // TODO: You should upgrade generateCarTitles functionality here to skip model if it is empty or null.
        // "Audi (A4), Mercedes, Skoda, Volvo (XC90), Volvo (V40)"
        // Hint: You should use Guava Strings.isNullOrEmpty()
        return null;
    }

    Collection<Car> findCar(final String name, final Integer priceLimit) {
        // TODO: Check name is not null or empty and throw IllegalArgumentException if it is.
        // TODO: Check priceLimit is not null and throw NullPointerException if it is.
        // TODO: Check priceLimit is greater than 0 and throw IllegalArgumentException if it is not.
        // Hint: Use Guava Preconditions utilities.
        // TODO: Retrieve all cars which name contains name parameter and price is less than priceLimit.
        return null;
    }

    private void print(String line) {
        System.out.println(line);
    }

    public static void main(String[] args) {
        new GuavaTasks().run();
    }

    private void run() {

        // Print cars
        for (Car car : cars) {
            print(printCar(car));
        }

        print(concatCarTitles(generateCarTitles()));

        print(concatCarTitles(generateCarTitlesWithoutEmpty(cars)));

        print("We offer these cars for you: " + concatCarTitles(generateCarTitlesWithoutEmpty(findCar("Volvo", 30000))));
    }
}
