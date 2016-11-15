/**
 * Created by BB on 2016-11-15.
 */
public class Line {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int sx, int sy, int ex, int ey) {
        Point start = new Point(sx,sy);
        Point end = new Point(ex,ey);
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setStart(int x, int y) {
        Point start = new Point(x,y);
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setEnd(int x, int y) {
        Point end = new Point(x,y);
        this.end = end;
    }

    public double getLength(){
        return this.start.distance(this.end);
    }
}
