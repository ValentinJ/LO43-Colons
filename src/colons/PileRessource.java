package colons;

/**
 * Created by val on 30/10/14.
 */
public class PileRessource {
    protected CarteRessource ressource;
    protected int nombre;

    public PileRessource(int indice_ressource, int nb) {
        ressource = new CarteRessource(indice_ressource);
        nombre = nb;
    }

    public void retirer() {
        nombre = nombre - 1;
        return;
    }

    public void ajouter() {
        nombre = nombre + 1;
        return;
    }
}
