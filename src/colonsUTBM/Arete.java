package colonsUTBM;

/**
 * Created by val on 04/12/14.
 */
public class Arete {
    protected NoeudConstructible n;
    protected NoeudConstructible m;
    protected String id;
    protected String typeCSS;


    Arete(NoeudConstructible n, NoeudConstructible m){
        this.n=n;
        this.m=m;
        id=n.id+":"+m.id;
    }

    public String getTypeCSS(){
        return "";
    }

    public String getIdArete(){
        return id;
    }
}
