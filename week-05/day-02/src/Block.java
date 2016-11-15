import java.util.List;

/**
 * Created by BB on 2016-11-15.
 */
public class Block extends Rectangle{
    private double length;

    public Block() {
        super();
        this.length = 1;
    }

    public Block(double width, double height, double length){
        super(width, height);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        System.out.printf("The three sides' areas are: %.1f, %.1f, %.1f\n", this.getWidth() * this.getHeight(), this.getWidth() * this.length, this.getHeight() * this.length);
        return (this.getWidth() * this.getHeight() + this.getWidth() * this.length + this.getHeight() * this.length) *2;
    }
    public double getVolume() {
        return this.getHeight() * this.getWidth() * this.length;
    }
}
