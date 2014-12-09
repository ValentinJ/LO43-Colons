package fenetreGraphique;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class FenetrePrincipale extends FenetreDefaut {

    /* * * * * * * * Variables pour fenetre graphique * * * * * * * */
    public BarreMenu Menu;                    // Barre de menu de toute bonne fenetre

    public EcranHaut EcranHaut;               // infos sur le joueur de ce tour
    public JPanel EcranGauche;                // construction et boutons d'interractions
    public Plateau Plateau;                   // plateau du jeu
    public EcranDroit Infos;                  // infos du joueur et recapitulatif
                                              // des ressources en main de chaque joueurs
    public EcranBas EcranBas;                 // reglementation du jeu ou msg du jeu

    /* * * * * * * * Variable pour fonctionnement Jeu * * * * * * * */
    int nbJoueur;
    public Vector<Joueur> Joueurs;
    public int Tour;

    public FenetrePrincipale(String _nom, int _h, int _l, Vector<Joueur> _J) {
        super(_nom, _h, _l);

        Joueurs = _J;
        nbJoueur = Joueurs.size();
        Menu = new BarreMenu();

        //permet d'ajouter plusieurs panel sans ecraser les anciens
        getContentPane().setLayout(new BorderLayout());

        // ajout du menu
        setJMenuBar(Menu);

        // creation des JPanel
        EcranHaut = new EcranHaut(Joueurs);
        String msg_appli = "Application développé par Sara, *Laurent, Valentin, Guillaume";
        EcranBas = new EcranBas(msg_appli);
        // instanciation du JPanel EcranGauche
        EcranGauche.add(new JButton("Echange"));
        EcranGauche.add(new JButton("Fin de tour"));
        /* * * * lui ajouté aussi le recap des construction * * * * */

        // ajout des parties de JPanel dans la JFrame selon un emplacement précis
        add("NORTH", EcranHaut);
        add("WEST",  EcranGauche);
        add("SOUTH", Plateau);
        add("EAST",  Infos);
        add("CENTER",EcranBas);

        affichage();
    }

    public void initialisationJeu(){

    }

    public void lancementJeu(){

    }

    public void miseAJour(){
        // mise a jour des differents JPanel

        Infos.MiseAJour(Joueurs, Tour);
        EcranHaut.MiseAJour(Tour);
        Plateau.MiseAJour();

        affichage();
    }

    public void JouerCarteMonopole(){
        // actions

        // mise a jour
        Infos.MiseAJour(Joueurs, Tour);
    }

}
