package colonsUTBM;

import java.util.ArrayList;

/**
 * Created by val on 30/11/14.
 */
public class CaseInterne extends Case{

    protected int valeurDes;
    protected boolean binomeGlandeur;
    protected TypeRessource tr;

    public CaseInterne() {
        this(0,0,TypeCase.BIERE,0);
    }

    public CaseInterne(Point p, TypeCase r, int valeurDes) {
        pts = new Point(p);
        id = p.getStringPointID();
        this.valeurDes = valeurDes;
        binomeGlandeur=false;
        if(this.valeurDes==0) {
            binomeGlandeur = true;
        }
        tc = r;
        setTypeCSS();
        setTypeRessource();
    }

    public void setTypeRessource(){
        switch(tc){
            case BIERE:
                tr = TypeRessource.BIERE;
                break;
            case CAFE:
                tr = TypeRessource.CAFE;
                break;
            case COURS:
                tr = TypeRessource.COURS;
                break;
            case SOMMEIL:
                tr = TypeRessource.SOMMEIL;
                break;
            case NOURRITURE:
                tr = TypeRessource.NOURRITURE;
                break;
            default:
                tr = TypeRessource.BIERE;
        }
    }

    public CaseInterne(double x, double y, TypeCase r, int valeurDes) {
        this(new Point(x,y),r,valeurDes);
    }

    public boolean isBinomeGlandeur() {
        return binomeGlandeur;
    }

    public void setBinomeGlandeur(boolean binomeGlandeur) {
        this.binomeGlandeur = binomeGlandeur;
        setTypeCSS();
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

    public void setTypeCSS(){
        if(binomeGlandeur) {
            if(tc==TypeCase.BIERE) typeCSS=TypeCaseCSS.BIEREGLANDEUR.toString();
            if(tc==TypeCase.CAFE) typeCSS=TypeCaseCSS.CAFEGLANDEUR.toString();
            if(tc==TypeCase.COURS) typeCSS=TypeCaseCSS.COURSGLANDEUR.toString();
            if(tc==TypeCase.NOURRITURE) typeCSS=TypeCaseCSS.NOURRITUREGLANDEUR.toString();
            if(tc==TypeCase.SOMMEIL) typeCSS=TypeCaseCSS.SOMMEILGLANDEUR.toString();
            if(tc==TypeCase.SEVENANS) typeCSS=TypeCaseCSS.SEVENANSGLANDEUR.toString();
        }
        else{
            if(tc==TypeCase.BIERE) typeCSS=TypeCaseCSS.BIERE.toString();
            if(tc==TypeCase.CAFE) typeCSS=TypeCaseCSS.CAFE.toString();
            if(tc==TypeCase.COURS) typeCSS=TypeCaseCSS.COURS.toString();
            if(tc==TypeCase.NOURRITURE) typeCSS=TypeCaseCSS.NOURRITURE.toString();
            if(tc==TypeCase.SOMMEIL) typeCSS=TypeCaseCSS.SOMMEIL.toString();
            if(tc==TypeCase.SEVENANS) typeCSS=TypeCaseCSS.SEVENANS.toString();
        }
    }

    public String getTypeCSS() {
        return typeCSS;
    }

    public int getValeurDes(){ return valeurDes;}

    public TypeRessource getTr(){ return tr; }
}
