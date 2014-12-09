import java.util.ArrayList;

/**
 * Created by val on 04/12/14.
 */
public class CaseExterne extends Case {

    boolean commerce;

    public CaseExterne() {
        this(0,0,TypeCase.BIERE,0);
    }

    public CaseExterne(Point p, TypeCase r) {
        pts = new Point(p);
        id = p.getStringPointID();
        tc = r;
        setCommerce();
        setTypeCSS();
    }

    public CaseExterne(double x, double y, TypeCase r, int valeurDes) {
        this(new Point(x,y),r);
    }

    public ArrayList<Point> getPointsCase(){
        ArrayList<Point> pts = new ArrayList<Point>();
        pts.add(new Point(this.pts.getX()+1,this.pts.getY()));
        pts.add(new Point(this.pts.getX(),this.pts.getY()-1));
        pts.add(new Point(this.pts.getX()-1,this.pts.getY()-1));
        pts.add(new Point(this.pts.getX()-1,this.pts.getY()));
        pts.add(new Point(this.pts.getX(),this.pts.getY()+1));
        pts.add(new Point(this.pts.getX()+1,this.pts.getY()+1));
        return pts;
    }

    public void setCommerce(){
    if(tc==TypeCase.BIERE || tc==TypeCase.CAFE || tc==TypeCase.COURS || tc==TypeCase.NOURRITURE
            || tc==TypeCase.SOMMEIL || tc==TypeCase.COMMERCETOUT)
        commerce=true;
    else
        commerce=false;
    }

    public boolean isCommerce(){
        return commerce;
    }

    public void setTypeCSS(){
        if(tc==TypeCase.BIERE) typeCSS=TypeCaseCSS.COMMERCEBIERE.toString();
        if(tc==TypeCase.CAFE) typeCSS=TypeCaseCSS.COMMERCECAFE.toString();
        if(tc==TypeCase.COURS) typeCSS=TypeCaseCSS.COMMERCECOURS.toString();
        if(tc==TypeCase.NOURRITURE) typeCSS=TypeCaseCSS.COMMERCENOURRITURE.toString();
        if(tc==TypeCase.SOMMEIL) typeCSS=TypeCaseCSS.COMMERCESOMMEIL.toString();
        if(tc==TypeCase.COMMERCETOUT) typeCSS=TypeCaseCSS.COMMERCETOUT.toString();
        if(tc==TypeCase.OCEAN) typeCSS=TypeCaseCSS.OCEAN.toString();
    }
    public String getTypeCSS(){
        return typeCSS;
    }
}
