/**
 * Created by BB on 2016-11-14.
 */
public class Circle {
    private int r;
    private static int count = 0;

    public Circle() {
        this.r = 1;
        count++;
    }
    public Circle(int r) {
        this.r = r;
        count++;
    }
    public double getPerimeter() {
        return 2 * r * Math.PI;
    }
    public double getArea() {
        return Math.pow(r,2)*Math.PI;
    }
    public static int countObjects() {
        return count;
    }
}
