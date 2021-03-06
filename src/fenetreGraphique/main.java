package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.ManagerJeu;
import colonsUTBM.TypeCouleur;
import colonsUTBM.TypeRessource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Guillaume on 09/12/2014.
 */
public class main {
    public static void main(String []arg) {
        // TODO decommenter ce paragraphe fait fonctionner prog
        System.setProperty("org.graphstream.ui.renderer","org.graphstream.ui.j2dviewer.J2DGraphRenderer");



        FenetrePrincipale frame;
        FenetreFlash f = new FenetreFlash();
        // attend 3 secondes
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.dispose();

        ArrayList<Joueur> j = new ArrayList<Joueur> ();
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
            ManagerJeu jeu = new ManagerJeu(j);
            System.out.println("Affichage du jeu...");
            //frame = new FenetrePrincipale("Colons de l'UTBohèMe - Projet LO43", 720, 1280, jeu);

            jeu.jouer();
            FenetreDefaut fenetreVictoire = new FenetreDefaut("Victoire", 500, 500);
            fenetreVictoire.setLayout(new GridLayout(3, 1));
            Joueur vainqueur = new Joueur();
            vainqueur = jeu.calculerScoreFinal();
            fenetreVictoire.add(new JLabel("Le joueur " + vainqueur.getNom() + " a remporté la partie"));
            fenetreVictoire.affichage();
        }
        else {
            System.out.println("L'application a été fermé :" + fId.getValider());
            System.exit(0);
        }
        
    }
}
