package colonsUTBM;

/**
 * Created by val on 04/12/14.
 */
public class Arete {
    protected NoeudConstructible n;
    protected NoeudConstructible m;
    protected String id;
    protected String typeCSS;


    Arete(){}

    Arete(NoeudConstructible n, NoeudConstructible m){
        this.n=n;
        this.m=m;
        id=n.id+":"+m.id;
        typeCSS="";
    }

    public String getTypeCSS(){
        return typeCSS;
    }


    public String getIdArete(){
        return id;
    }
}
