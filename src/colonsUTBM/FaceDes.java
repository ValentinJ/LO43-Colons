package colonsUTBM;

/**
 * Created by Guillaume on 09/12/2014.
 */
public enum FaceDes {
    UN("un.png"), DEUX("deux.png"), TROIS("trois.png"), QUATRE("quatre.png"), CINQ("cinq.png"), SIX("six.png");

    private String name="";

    FaceDes(String n){name= n;}

    public String toString(){return name;}
}
