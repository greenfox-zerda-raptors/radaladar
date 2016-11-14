/**
 * Created by BB on 2016-11-14.
 */

public class Car {
    private static int carCount = -1;
    private String type;
    private String color;
    private int engine;
    private int kmOdometer;

    public Car(String type, String color, int engine, int kmOdometer) {
        this.type = type;
        this.color = color;
        this.engine = engine;
        this.kmOdometer = kmOdometer;
        carCount += 1;
    }

    public Car(String type, String color) {
        this.type = type;
        this.color = color;
        this.engine = 1600;
        this.kmOdometer = 10;
        carCount += 1;
    }

    public Car(int engine, int kmOdometer) {
        this.type = "Mazda";
        this.color = "red";
        this.engine = engine;
        this.kmOdometer = kmOdometer;
        carCount += 1;
    }

    public String getType() {
        return type;
    }
    public String getColor() {
        return color;
    }
    public int getEngine() {
        return engine;
    }
    public int getKmOdometer() {
        return kmOdometer;
    }
    public static int getCarCount() {
        return carCount;
    }

    public String toString(){
        return "This " + type + " is " + color + ", has a " + engine + "cc engine and clocked " + kmOdometer+ "km's";
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setEngine(int engine) {
        this.engine = engine;
    }
    public void setKmOdometer(int kmOdometer) {
        this.kmOdometer = kmOdometer;
    }

    public void drive(int x) {
        kmOdometer += x;
        if (x > 50) {
            System.out.printf("Brrm, screech, brrm, screech; the %s %s commuted %d clicks.\n", color, type, x);
        } else if (x > 20) {
            System.out.printf("Brrm, the %s %s just drove around town %d clicks.\n", color, type, x);
        } else {
            System.out.printf("Whee, the %s %s drove %d clicks.\n", color, type, x);
        }
        System.out.printf("The %s %s's odometer shows %d km's\n", color, type, kmOdometer);
    }
}
