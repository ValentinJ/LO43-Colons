package colonsUTBM;

import java.util.ArrayList;

/**
 * Created by Guillaume on 02/12/2014.
 */
public class Des {
    public ArrayList<String> imgFace;
    public int v1;
    public int v2;

    public Des(){v1=0; v2=0;}

    public ArrayList<Integer> affichage(int indice){
        ArrayList<Integer> liste = new ArrayList<Integer>();
        liste.add(v1);
        liste.add(v2);
        return liste;
    }
}
