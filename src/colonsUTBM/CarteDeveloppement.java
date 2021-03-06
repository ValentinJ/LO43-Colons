package colonsUTBM;

/**
 * Created by Guillaume on 02/12/2014.
 */
public class CarteDeveloppement extends Carte{

    protected boolean attenteValide; /*il dit si la carte peut etre joué*/
    protected TypeDeveloppement typeDeveloppement;
    protected boolean dansLaMain;

    public CarteDeveloppement(TypeDeveloppement t){
        typeDeveloppement = t;
        attenteValide = false;
        dansLaMain = true;
        switch (typeDeveloppement){
            case ANCIEN:
                nom="Carte Ancien";
                //img=imgcarteancien;
                break;
            case POINTVICTOIRE:
                nom="Carte Point Victorie";
                //img=imgpointvictorie;
                break;
            case DECOUVERTE:
                nom="Carte Decouverte";
                //img=imgdecuverte;
                break;
            case CCC:
                nom="Carte Construction Control Continue";
                //img=imgCCC;
                break;
            case MONOPOLE:
                nom="Carte Monopole";
                //img=imgmonopole;
                break;
        }
    }

    public boolean isAttenteValide() { return attenteValide; }
    public TypeDeveloppement getTypeDeveloppement() { return typeDeveloppement; }
    public boolean isDansLaMain() { return dansLaMain;}
    public void setAttenteValide(boolean b) { attenteValide = b;}
    public void setDansLaMain(boolean b) {dansLaMain = b;}
}
