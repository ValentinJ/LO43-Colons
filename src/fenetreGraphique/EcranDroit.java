package fenetreGraphique;

import colonsUTBM.Joueur;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranDroit extends JPanel{

    public Vector<Joueur> Joueurs;
    int Tour;

    public EcranDroit(){
        // partie le tableau
        // partie nb ville et colonnie du joueur actu
        // partie bonus (anciens + controle continue)
        // partie score tot nb ville + colonnie + bonus
    }

    public void MiseAJour(Vector<Joueur> _j, int _t){
        Joueurs = _j;
        Tour = _t;
        // tableau des ressources dans les mains

        // des differentes possession : carte / UV* / UV** / Controle Continue / ...
    }


}
