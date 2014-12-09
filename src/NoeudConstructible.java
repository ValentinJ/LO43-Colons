/**
 * Created by val on 30/11/14.
 */
public class NoeudConstructible extends Noeud{

    protected TypeNoeud tn;

    public NoeudConstructible(){
        this(new Point(),TypeNoeud.VIDE);
    }
    public NoeudConstructible(Point p, TypeNoeud tn){
        this.pts = p;
        this.tn = tn;
        this.id = p.getStringPointID();
        setTypeCSS();
    }

    public TypeNoeud getTn() {
        return tn;
    }

    public void setTn(TypeNoeud tn) {
        this.tn = tn;
        setTypeCSS();
    }

    public void setTypeCSS(){
        if(tn==TypeNoeud.VIDE) typeCSS = TypeNoeudCSS.VIDE.toString();
        if(tn==TypeNoeud.UV1) typeCSS=TypeNoeudCSS.UV1.toString();
        if(tn==TypeNoeud.UV2) typeCSS=TypeNoeudCSS.UV2.toString();
    }

    @Override
    public String getTypeCSS() {
        return typeCSS;
    }
}
