package colonsUTBM;

/**
 * Created by Guillaume on 02/12/2014.
 */
public class CarteRessource extends Carte{

    protected TypeRessource typeRessource;

    public CarteRessource (TypeRessource t) {
        typeRessource = t;
        switch(typeRessource){
            case BIERE:
                nom="Biere";
                //img="Biere";
                break;
            case CAFE:
                nom="Cafè";
                //img="imgcafè";
                break;
            case COURS:
                nom="Cours";
                //img="imgcours";
                break;
            case SOMMEIL:
                nom="Sommeil";
                //img="imgsommeil";
                break;
            case NOURRITURE:
                nom="Norriture";
                //img="imgnorriture";
                break;
        }
    }

    public TypeRessource getTypeRessource() { return typeRessource; }
}
