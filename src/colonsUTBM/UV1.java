package colonsUTBM;

/**
 * Created by val on 12/12/14.
 */
public class UV1 extends NoeudConstructible {

    protected int ptsVictoire;

    protected Joueur j;

    public UV1(){
    }

    public UV1(NoeudConstructible n, Joueur j){
        super(n);
        this.j=j;
        tn=TypeNoeud.UV1;
        ptsVictoire=1;
        typeCSS = tn.toString()+", "+j.getCouleur();
    }

    public UV1(UV1 uv){
        super(uv.pts);
        this.j=uv.getJ();
        tn=TypeNoeud.UV1;
        ptsVictoire=1;
        typeCSS = tn.toString()+", "+j.getCouleur();

    }
    public Joueur getJ(){
        return j;
    }

    public void setTypeCSS(){
        typeCSS=tn.toString()+", "+j.getCouleur();
    }

    @Override
    public String getTypeCSS() {
        return typeCSS;
    }
}
