package colonsUTBM;

/**
 * Created by val on 30/11/14.
 */
public class NoeudConstructible extends Noeud{

    protected TypeNoeud tn;

    public NoeudConstructible(){
        this(new Point());
    }
    public NoeudConstructible(Point p){
        this.pts = p;
        this.tn = TypeNoeud.VIDE;
        this.id = p.getStringPointID();
        this.typeCSS = tn.toString();
    }
    public NoeudConstructible(NoeudConstructible n){
        this(n.pts);
    }

    public TypeNoeud getTn() {
        return tn;
    }

    public void setTypeCSS(){
        typeCSS = tn.toString();
    }

    @Override
    public String getTypeCSS() {
        return typeCSS;
    }
}
