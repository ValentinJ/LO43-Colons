package colonsUTBM;

/**
 * Created by val on 04/12/14.
 */
public enum TypeNoeud {
    VIDE(""),UV1("uv1"),UV2("uv2");

    private String name;

    TypeNoeud(String name){
        this.name=name;
    }

    public String toString(){
        return name;
    }

}
