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
    public void retirer() { nombre--; }
    public void ajouterX(int nbr){ nombre+=nbr;}
    public void retirerX(int nbr){ nombre-=nbr;}
    public int getNombre() { return nombre; }
    public CarteRessource getRessource() { return ressource; }
}
