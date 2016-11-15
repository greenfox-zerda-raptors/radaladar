/**
 * Created by BB on 2016-11-15.
 */
public class Workshop07 {
    public static void main(String[] args) {
        // Test constructors and toString()
        Point p1 = new Point(1, 2);
        System.out.println(p1);  // toString()
        Point p2 = new Point();  // default constructor
        System.out.println(p2);

        // Test Setters and Getters
        p1.setX(3);
        p1.setY(4);
        System.out.println(p1);  // run toString() to inspect the modified instance
        System.out.println("X is: " + p1.getX());
        System.out.println("Y is: " + p1.getY());

        // Test setXY() and getXY()
        p1.setXY(5, 6);
        System.out.println(p1);  // toString()
        System.out.println("X is: " + p1.getXY()[0]);
        System.out.println("Y is: " + p1.getXY()[1]);

        // Test the 3 overloaded versions of distance()
        p2.setXY(10, 11);
        System.out.printf("Distance is: %.2f%n", p1.distance(10, 11));
        System.out.printf("Distance is: %.2f%n", p1.distance(p2));
        System.out.printf("Distance is: %.2f%n", p2.distance(p1));
        System.out.printf("Distance is: %.2f%n", p1.distance());

        Point p = new Point(10,15);
        Point q = new Point(12,18);
        Line n = new Line(p,q);
        System.out.println(n.getLength());
        Line m = new Line (10,15,12,18);
        System.out.println(m.getLength()); // should be the same
        Point v = new Point();
        Line a = new Line (v,p);
        System.out.println(a.getLength());
        System.out.println(p.distance()); // should be the same

    }
}
