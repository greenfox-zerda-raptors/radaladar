/**
 * Created by BB on 2016-11-15.
 */
public class Workshop05 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4, 7);
        Block b1 = new Block(4,7,5);
        Square s1 = new Square(3);

        System.out.println(r1.getArea());
        System.out.println(r2.getArea());
        System.out.println(b1.getArea());
        System.out.println(b1.getVolume());
        System.out.println(s1.getArea());

    }
}
