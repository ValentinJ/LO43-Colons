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
                img="CarteBiere.png";
                description="Une ressource bière qui provient du foyer, BDM, The Place ou Roger's";
                break;
            case CAFE:
                nom="Cafè";
                img="CarteCafe.png";
                description="Une ressource café qui provient du Leclerc, Monoprix, Cora ou Carrefour";
                break;
            case COURS:
                nom="Cours";
                img="CarteCours.png";
                description="Une ressource cours qui provient de la reprod, amphi, moddle ou d'un ancien élève";
                break;
            case SOMMEIL:
                nom="Sommeil";
                img="CarteSommeil.png";
                description="Une ressource sommeil qui provient de Sartres, ME ou l'hotel";
                break;
            case NOURRITURE:
                nom="Norriture";
                img="CarteNourriture.png";
                description="Une ressource nourriture qui provient du McDO, Quick ou KFC";
                break;
        }
    }

    public TypeRessource getTypeRessource() { return typeRessource; }
}
