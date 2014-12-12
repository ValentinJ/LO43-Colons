package colonsUTBM;

/**
 * Created by Guillaume on 03/12/2014.
 */
public enum TypeCouleur {
    BLEU("blue"), ROUGE("red"), JAUNE("yellow"), VERT("green");

    private String name;

    TypeCouleur(String name){
        this.name=name;
    }

    public String toString(){
        return name;
    }
}
