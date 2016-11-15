/**
 * Created by BB on 2016-11-15.
 */
public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1;
        this.color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Circle["+this.radius+", "+ this.color + "]";
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public double getCircumference() {
        return radius * 2 * Math.PI;
    }
}
