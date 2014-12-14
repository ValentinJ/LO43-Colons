package colonsUTBM;

/**
 * Created by Guillaume on 02/12/2014.
 */
public class CarteDeveloppement extends Carte{
    protected boolean attenteValide; /*il dit si la carte peut etre joué*/
    private TypeDeveloppement typeDeveloppement;

    public CarteDeveloppement(){
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
}
