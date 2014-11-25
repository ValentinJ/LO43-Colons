package colons;

import java.util.Vector;

/**
 * Created by Guillaume on 25/11/2014.
 */
public class Jeu {
    private Vector<Joueur> ListeJoueur;
    private int Tour;

    public Jeu() {

    }

    public Jeu(Vector<Joueur> _ListeJoueurs) {
        // parcours liste joueurs et leur faire chacun lancé leur dés, puis réorganiser la liste en fonctions des val du dés
    }

    public void PhaseFondation() {

    }

    public void Echange() {
        // attention : différentié les cas
        // ainsi que prendre garde aux ports
    }

    public void JouerMonopole(){

    }

    public void AcheterCarte(){

    }

    public void verifPossibilite(){         // retourne si 1 ok pour Uv
                                            //             2            **
                                            //             3            controle

    }

    public void AcheterUv(){            // UV *
        // verif possible
        // appel joueur qui achete UV
    }

    public void TransformerUv(){        // UV **
        // verif possible
        // appel joueur qui achete UV
    }

    public void AcheterControle(){      // Controle continue
        // verif possible
        // appel joueur qui achete UV
    }
}
