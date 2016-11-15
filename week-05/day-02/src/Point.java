/**
 * Created by BB on 2016-11-15.
 */
public class Point {
    private int x;
    private int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y +")";
    }

    public int[] getXY() {
        int[] xy = {this.x,this.y};
        return xy;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(int x, int y) {
        return Math.sqrt(((double)(Math.pow((x - this.x), 2) + Math.pow((y - this.y),2))));
    }

    public double distance(Point p) {
        return Math.sqrt(((double)(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y),2))));
    }
    public double distance() {
        return Math.sqrt(((double)(Math.pow((0 - this.x), 2) + Math.pow((0 - this.y),2))));
    }
}
