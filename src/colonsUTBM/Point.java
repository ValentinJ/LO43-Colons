package colonsUTBM;
import java.text.DecimalFormat;
/**
 * Created by val on 26/11/14.
 */
public class Point {
    protected double x;
    protected double y;
    /**
     * Constructeur par défaut, initialise un point de coordonnées (0,0).
     */
    public Point(){
        this.x=0;
        this.y=0;
    }
    /**
     * Constructeur par coordonnées, crée un point de coordonnées (x,y).
     * @param x
     * @param y
     */
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    /**
     * Constructeur par copie.
     * @param p
     */
    public Point(Point p){
        this.x=p.x;
        this.y=p.y;
    }
    public double getX() {return x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}
    /**
     * transformer coordonnées du repère "hexagonal" à orthonormé.
     */
    public void transformer(){
        x=x-0.5*y;
        y=y*2/Math.sqrt(3);
    }
    /**
     * Retourne x sous repère orthonormé.
     * @return
     */
    public double transformerX(){
        return (x-0.5*y)*1.35;
    }
    /**
     *Retourne y sous repère orthonormé.
     * @return
     */
    public double transformerY(){
        return y*2/Math.sqrt(3);
    }
    /**
     * Retourne une chaine des coordonnées du type i[x]j[y].
     * @return
     */
    public String getStringPointID(){
        DecimalFormat df = new DecimalFormat("#.##");
        return "i"+df.format(x)+"j"+df.format(y);
    }
}