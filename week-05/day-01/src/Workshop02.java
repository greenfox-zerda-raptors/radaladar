/**
 * Created by BB on 2016-11-14.
 */
public class Workshop02 {
    public static void main(String[] args) {
        System.out.println(Circle.countObjects());
        Circle a = new Circle();
        Circle b = new Circle(5);

        System.out.println(a.getArea());
        System.out.println(a.getPerimeter());
        System.out.println(b.getArea());
        System.out.println(b.getPerimeter());

        System.out.println(Circle.countObjects());

    }
}
