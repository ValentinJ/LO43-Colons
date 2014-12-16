package fenetreGraphique;

import colonsUTBM.Joueur;

import java.util.Vector;

/**
 * Created by Guillaume on 09/12/2014.
 */
public class main {
    public static void main(String []arg) {
        Vector<Joueur> j = new Vector<Joueur> ();
        //FenetreDefaut frame = new FenetreDefaut("test", 1600, 850);
        //frame.affichage();
        FenetrePrincipale frame = new FenetrePrincipale("testage", 720, 1280, j);
    }
}
