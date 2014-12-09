package fenetreGraphique;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranHaut extends JPanel {

    private Vector<Joueur> Joueurs;
    private Vector<BlocTourJoueur> BlocJoueurs;

    public EcranHaut(Vector<Joueur> _J){
        Joueurs = _J;

        // creation de ma liste des joueurs
        for(int i = 0; i < Joueurs.size(); i++){
            // afficher nom Joueur
            BlocJoueurs.add(new BlocTourJoueur((Joueurs.get(i)).nomDuJoueur, (Joueurs.get(i)).couleur);
        }

        MiseAJour(0);
    }

    public void MiseAJour(int indiceTour){
        // efface ancienne couleur bloc
        (BlocJoueurs.get( (indiceTour-1) % BlocJoueurs.size() )).desactiveCouleur();

        // efface ancienne couleur bloc dans le cas de l init du jeu
        (BlocJoueurs.get( (indiceTour+1) % BlocJoueurs.size() )).desactiveCouleur();

        // active couleur de la case du joueur actuel
        (BlocJoueurs.get( indiceTour % BlocJoueurs.size() )).activeCouleur();
    }
}
