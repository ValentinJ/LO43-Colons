package colonsUTBM;

/**
 * Created by Guillaume on 02/12/2014.
 */
public class Point {
    protected double x;
    protected double y;

    public Point() {
    }

    public Point(double _x, double _y) {
    }

    public Point(Point p) {
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String getStringPointID(){
        return "(" + x + ";" + y + ")";
    }

    public double transformerX() {
        return 0;
    }

    public double transformerY() {
        return 0;
    }
}
