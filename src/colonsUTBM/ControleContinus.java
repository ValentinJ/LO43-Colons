package colonsUTBM;

/**
 * Created by val on 14/12/14.
 */
public class ControleContinus extends Arete{

    protected Joueur j;

    ControleContinus(Arete r, Joueur j) {
        super(r.n, r.m);
        this.j=j;
    }

    public String getTypeCSS(){
        return j.getCouleur();
    }
}
