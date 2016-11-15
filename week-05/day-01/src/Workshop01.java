import java.util.ArrayList;
import java.util.Random;

/**
 * Created by BB on 2016-11-14.
 */

public class Workshop01 {
    public static void main(String[] args) {
        System.out.println("Number of Cars Available = " + Car.getCarCount());
        Car myCar1 = new Car("Mazda", "red", 6800, 12312);
        System.out.println("Number of Cars Available = " + Car.getCarCount());
        Car myCar2 = new Car("Ford", "silver", 2500, 152312);
        Car myCar3 = new Car("Beamer", "green", 2800, 42521);

        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar1.getType(),
                myCar1.getColor() , myCar1.getEngine(), myCar1.getKmOdometer());
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar2.getType(),
                myCar2.getColor() , myCar2.getEngine(), myCar2.getKmOdometer());
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar3.getType(),
                myCar3.getColor() , myCar3.getEngine(), myCar3.getKmOdometer());
        System.out.println("Number of Cars Available = " + Car.getCarCount());

        System.out.println("------------------------------------------------------");

        myCar2.drive(1200);
        myCar3.drive(49);

        System.out.println("------------------------------------------------------");

        Car myCar4 = new Car("Trabi", "roncs");
        myCar4.drive(6);
        System.out.println(myCar4.toString());

        System.out.println("------------------------------------------------------");

        Car myCar05 = new Car("Opel", "white", 1400, 25);
        Car myCar06 = new Car("VW", "grey");
        Car myCar07 = new Car(1100, 15);
        System.out.println(myCar05.toString());
        System.out.println(myCar06.toString());
        System.out.println(myCar07.toString());

        System.out.println("------------------------------------------------------");

        String[] colors = new String[]{"white", "blue", "red", "silver", "black", "green", "banana"};
        String[] makes = new String[]{"Toyota", "Mazda", "BMW", "VW", "Opel", "Suzuki", "Ford", "Mercedes"};
        int[] engineSizes = new int[]{1100, 1400, 1600, 1800, 2500};

        ArrayList<Car> lsCars = new ArrayList<Car>();
        Random rand = new Random();

        for (int i = 0; i < 40; i++){
        lsCars.add(i,new Car(makes[rand.nextInt(makes.length)], colors[rand.nextInt(colors.length)], engineSizes[rand.nextInt(engineSizes.length)], 0));
        }
        for (Car thisCar: lsCars) {
            System.out.println(thisCar.toString());
        }

        lsCars.get(0).drive(65);
        lsCars.get(1).drive(9);

        System.out.println("Number of Cars Available = " + Car.getCarCount());

        Garage garage01 = new Garage();

        for (Car thisCar: garage01.cars) {
            System.out.println(thisCar.toString());
        }

        garage01.addRandomCar();
        garage01.addCar(new Car("Beamer", "green", 2800, 42521));

        for (Car thisCar: garage01.cars) {
            System.out.println(thisCar.toString());
        }
    }
}
