package colonsUTBM;

/**
 * Created by val on 14/12/14.
 */
public class ControleContinus extends Arete{

    protected Joueur j;

    ControleContinus(){}

    ControleContinus(Arete r, Joueur j) {
        super(r.n, r.m);
        this.j=j;
        this.typeCSS="controleContinu, "+j.getCouleur();
    }

    public String getTypeCSS(){
        return typeCSS;
    }
}
