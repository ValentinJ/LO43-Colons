package fenetreGraphique;

import colonsUTBM.Joueur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranHaut extends JPanel {

    private Vector<Joueur> Joueurs;
    private Vector<BlocTourJoueur> BlocJoueurs;

    public EcranHaut(Vector<Joueur> _J){
        setBackground(Color.white);
        setBorder(new EmptyBorder(5, 5, 0, 5));
        Joueurs = _J;
        setLayout(new GridLayout(1, Joueurs.size()));

        // creation de ma liste des joueurs
        for(int i = 0; i < Joueurs.size(); i++){
            // afficher nom Joueur
            BlocJoueurs.add(new BlocTourJoueur((Joueurs.get(i)).getNom(), (Joueurs.get(i)).getCouleur()));
        }

        MiseAJour(0);
    }


    public void MiseAJour(int indiceTour){
        // efface ancienne couleur bloc
/*        (BlocJoueurs.get( (indiceTour-1) % BlocJoueurs.size() )).desactiveCouleur();

        // efface ancienne couleur bloc dans le cas de l init du jeu
        (BlocJoueurs.get( (indiceTour+1) % BlocJoueurs.size() )).desactiveCouleur();

        // active couleur de la case du joueur actuel
        (BlocJoueurs.get( indiceTour % BlocJoueurs.size() )).activeCouleur();*/
    }
}
