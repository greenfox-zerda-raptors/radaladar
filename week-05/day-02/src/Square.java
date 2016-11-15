/**
 * Created by BB on 2016-11-15.
 */
public class Square extends Rectangle {

    public Square() {
    super();
    }

    public Square(double side) {
        super(side, side);
    }

    public double getArea() {
        return super.getArea();
    }

    public String toString() {
        return "Square["+this.getHeight()+"]";
    }
}
