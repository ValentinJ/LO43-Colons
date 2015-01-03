package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.TypeCouleur;

import java.util.ArrayList;

/**
 * Created by Guillaume on 09/12/2014.
 */
public class main {
    public static void main(String []arg) {

        FenetrePrincipale frame;

        //todo à décommenter : fenetre flash
        /*
        FenetreFlash f = new FenetreFlash();
        // attend 3 secondes
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.dispose();
        */

        //todo : TEST : Création automatique des joueurs
        ArrayList<Joueur> j = new ArrayList<Joueur> ();
        j.add(new Joueur("Mick", TypeCouleur.BLEU));
        j.add(new Joueur("Elodie", TypeCouleur.ROUGE));
        j.add(new Joueur("Didi", TypeCouleur.VERT));
        j.add(new Joueur("J4", TypeCouleur.JAUNE));
        frame = new FenetrePrincipale("Colons de l'UTBohèMe - Projet LO43", 720, 1280, j);


        //todo à décommenter : fenetre identification des joueurs
        /*
        FenetreIdentification fId = new FenetreIdentification("Colons de l'UTBohèMe - Projet LO43");
        while (fId.getValider()==0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fId.dispose();
        if (fId.getValider()==1){
            j = fId.getJoueurs();
            System.out.println("Affichage du jeu...");
            frame = new FenetrePrincipale("Colons de l'UTBohèMe - Projet LO43", 720, 1280, j);
        }
        else {
            System.out.println("L'application a été fermé :" + fId.getValider());
            System.exit(0);
        }
        */


    }
}
