/**
 * Created by BB on 2016-11-14.
 */

public class Workshop01 {
    public static void main(String[] args) {
        Car myCar1 = new Car("Mazda", "red", 6800, 12312);
        Car myCar2 = new Car("Ford", "silver", 2500, 152312);
        Car myCar3 = new Car("Beamer", "green", 2800, 42521);

        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar1.getType(),
                myCar1.getColor() , myCar1.getEngine(), myCar1.getKmOdometer());
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar2.getType(),
                myCar2.getColor() , myCar2.getEngine(), myCar2.getKmOdometer());
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's\n", myCar3.getType(),
                myCar3.getColor() , myCar3.getEngine(), myCar3.getKmOdometer());

        myCar2.drive(1200);
        myCar3.drive(49);

        Car myCar4 = new Car("Trabi", "roncs");
        myCar4.drive(6);
        System.out.println(myCar4.toString());

        Car myCar05 = new Car("Opel", "white", 1400, 25);
        Car myCar06 = new Car("VW", "grey");
        Car myCar07 = new Car(1100, 15);
        System.out.println(myCar05.toString());
        System.out.println(myCar06.toString());
        System.out.println(myCar07.toString());
    }
}
