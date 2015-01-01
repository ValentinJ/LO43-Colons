package fenetreGraphique;

import colonsUTBM.Joueur;

import java.util.Vector;

/**
 * Created by Guillaume on 09/12/2014.
 */
public class main {
    public static void main(String []arg) {
        // peut etre afficher un display splash

        Vector<Joueur> j = new Vector<Joueur> ();
        // ouverture fenetre pour identifier les joueurs
        FenetreIdentification fId = new FenetreIdentification("Colons de l'UTBohèMe - Projet LO43");

        while (fId.getValider()==0){}
        fId.dispose();

        if (fId.getValider()==1){
            //fId.dispose();
            j = fId.getJoueurs();
            System.out.println("L'application a été lancé");

            // affichage de la fenetre de jeu
            FenetrePrincipale frame = new FenetrePrincipale("Colons de l'UTBohèMe - Projet LO43", 720, 1280, j);
        }
        else {
            //fId.dispose();
            System.out.println("L'application a été fermé " + fId.getValider());
            System.exit(0);
        }
    }
}
