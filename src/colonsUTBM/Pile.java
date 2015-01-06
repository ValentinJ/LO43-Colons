package colonsUTBM;

/**
 * Created by Guillaume on 02/12/2014.
 */
public class Pile {

    protected int nombre;
    protected CarteRessource ressource;

    public Pile(CarteRessource cr){
        ressource = cr;
        nombre=0;
    }

    public Pile(CarteRessource cr, int nb){
        ressource = cr;
        nombre = nb;
    }

    public void ajouter() { nombre++; }
    public int retirer() {
        if(nombre>0) {
            nombre--;
            return 1;
        }
        else
            return 0;
    }
    public void ajouter(int nbr){ nombre+=nbr;}
    public int retirer(int nbr){
        int tmp=0;
        if(nombre>nbr){
            nombre-=nbr;
            return nbr;
        }
        else{
            tmp=nombre;
            nombre=0;
            return tmp;
        }
    }
    public int getNombre() { return nombre; }
    public CarteRessource getRessource() { return ressource; }
}
