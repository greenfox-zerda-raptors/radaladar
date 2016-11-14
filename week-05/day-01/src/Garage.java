import java.util.ArrayList;
import java.util.Random;

/**
 * Created by BB on 2016-11-14.
 */
public class Garage {
    public ArrayList<Car> cars = new ArrayList<Car>();
    private static String[] colors = new String[]{"white", "blue", "red", "silver", "black", "green", "banana"};
    private static String[] makes = new String[]{"Toyota", "Mazda", "BMW", "VW", "Opel", "Suzuki", "Ford", "Mercedes"};
    private static int[] engineSizes = new int[]{1100, 1400, 1600, 1800, 2500};

    public Garage(){
        Random rand = new Random();
        for (int i = 0; i < 5; i++){
        cars.add(i,new Car(makes[rand.nextInt(makes.length)], colors[rand.nextInt(colors.length)],                       engineSizes[rand.nextInt(engineSizes.length)], 0));
        }
    }
    public void addRandomCar() {
        Random rand = new Random();
        cars.add(new Car(makes[rand.nextInt(makes.length)], colors[rand.nextInt(colors.length)],                           engineSizes[rand.nextInt(engineSizes.length)], 0));
    }

    public void addCar(Car newcar){
        cars.add(newcar);
    }
}
