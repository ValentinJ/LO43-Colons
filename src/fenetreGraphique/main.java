package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.TypeCouleur;

import java.util.Vector;

/**
 * Created by Guillaume on 09/12/2014.
 */
public class main {
    public static void main(String []arg) {

        FenetrePrincipale frame;
        /*
        // afficher un display splash
        FenetreFlash f = new FenetreFlash();
        // attend 3 secondes
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.dispose();
        */
        Vector<Joueur> j = new Vector<Joueur> ();

        // ouverture fenetre pour identifier les joueurs
        FenetreIdentification fId = new FenetreIdentification("Colons de l'UTBohèMe - Projet LO43");

        while (fId.getValider()==0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }        }
        System.out.println("FID.valider "+fId.getValider());
        fId.dispose();

        if (fId.getValider()==1){
            //fId.dispose();
            j = fId.getJoueurs();
            System.out.println("L'application a été lancé");

            // affichage de la fenetre de jeu
            frame = new FenetrePrincipale("Colons de l'UTBohèMe - Projet LO43", 720, 1280, j);
        }
        else {
            //fId.dispose();
            System.out.println("L'application a été fermé " + fId.getValider());
            System.exit(0);
        }

        /*
        *
        * Ce qui suit est pour accelerer les tests mais a virer après
        *


        Vector<Joueur> j = new Vector<Joueur> ();

        j.add(new Joueur("Mickael", TypeCouleur.BLEU));
        j.add(new Joueur("Elodie", TypeCouleur.VERT));
        j.add(new Joueur("Thomas", TypeCouleur.ROUGE));

        System.out.println("L'application a été lancé");
        FenetrePrincipale frame = new FenetrePrincipale("Colons de l'UTBohèMe - Projet LO43", 720, 1280, j);
*/
    }
}
