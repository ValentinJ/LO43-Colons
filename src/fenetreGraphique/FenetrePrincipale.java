package fenetreGraphique;

import colonsUTBM.GraphMap;
import colonsUTBM.Joueur;
import colonsUTBM.ManagerJeu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class FenetrePrincipale extends FenetreDefaut {
    public EcranGauche EcranGauche;           // construction et boutons d'interractions
    public Plateau Plateau;                   // plateau du jeu
    public EcranDroit Infos;                  // infos du joueur et recapitulatif
                                              // des ressources en main de chaque joueurs
    public EcranBas EcranBas;                 // reglementation du jeu ou msg du jeu

    int nbJoueur;
    public ArrayList<Joueur> Joueurs;
    public ManagerJeu manJeu;
    public int Tour;

    public GraphMap g;

    public JScrollPane scroller;

    public FenetrePrincipale(String _nom, int _h, int _l, ManagerJeu jeu) {
        super(_nom, _h, _l);

        manJeu = jeu;
        Joueurs = jeu.getJoueurs();
        nbJoueur = Joueurs.size();

        g = jeu.getTerrain();
        g.majCSS();

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        //permet d'ajouter plusieurs JPanel sans ecraser les anciens
        getContentPane().setLayout(new BorderLayout());

        // creation des JPanel
        String msg_appli = "Lancement de la partie. Le joueur " + manJeu.getJoueurCourrant().getNom() + " commence" ;
        EcranBas = new EcranBas(msg_appli, this);
        scroller = new JScrollPane(EcranBas, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setPreferredSize(new Dimension(300,50));
        // instanciation du JPanel EcranGauche
        EcranGauche = new EcranGauche(manJeu, this, EcranBas);
        Plateau = new Plateau(g.getView(), manJeu, this);
        Infos = new EcranDroit(manJeu, this, EcranBas);

        // definit taille des JPanel
        EcranGauche.setPreferredSize(new Dimension(200, 100));

        // ajout des parties de JPanel dans la JFrame selon un emplacement précis
        add(EcranGauche, BorderLayout.WEST);
        add(Plateau,     BorderLayout.CENTER);
        add(Infos,       BorderLayout.EAST);
        add(scroller,    BorderLayout.SOUTH);

        affichage();
    }

    public void initialisationJeu(){

    }

    public void lancementJeu(){

    }

    public void miseAJour(){
        // mise a jour des differents JPanel
        EcranGauche.miseAJour(manJeu);
        Infos.MiseAJour(manJeu);
        Plateau.MiseAJour();

        validate();
    }

    public void JouerCarteMonopole(){
        // actions

        // mise a jour
        miseAJour();
    }

}
