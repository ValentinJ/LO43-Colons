package fenetreGraphique;

import colonsUTBM.GraphMap;
import colonsUTBM.Joueur;
import org.graphstream.graph.Graph;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class FenetrePrincipale extends FenetreDefaut {

    public BarreMenu Menu;                    // Barre de menu de toute bonne fenetre

    public EcranHaut EcranHaut;               // infos sur le joueur de ce tour
    public EcranGauche EcranGauche;           // construction et boutons d'interractions
    public Plateau Plateau;                   // plateau du jeu
    public EcranDroit Infos;                  // infos du joueur et recapitulatif
                                              // des ressources en main de chaque joueurs
    public EcranBas EcranBas;                 // reglementation du jeu ou msg du jeu

    int nbJoueur;
    public Vector<Joueur> Joueurs;
    public int Tour;

    public GraphMap g;
    public Graphics gImgEntete;

    public FenetrePrincipale(String _nom, int _h, int _l, Vector<Joueur> _J) {
        super(_nom, _h, _l);

        Joueurs = _J;
        nbJoueur = Joueurs.size();
        Menu = new BarreMenu();

        g = new GraphMap(true);
        g.initMap();
        g.chargerCSS();
        g.MAJCSS();

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        //permet d'ajouter plusieurs JPanel sans ecraser les anciens
        getContentPane().setLayout(new BorderLayout());

        // ajout du menu
        setJMenuBar(Menu);

        // creation des JPanel
        //EcranHaut = new EcranHaut(Joueurs);
        String msg_appli = "MSG INFOS : Application développée par Sara, Yuanxiang, Valentin, Guillaume";
        EcranBas = new EcranBas(msg_appli);
        // instanciation du JPanel EcranGauche
        EcranGauche = new EcranGauche();
        Plateau = new Plateau(g.getView());

        try {
            Infos = new EcranDroit(Joueurs, Tour, gImgEntete);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("il est passé par ici");
        /* * * * lui ajouté aussi le recap des construction * * * * */

        // definit taille des JPanel
        //EcranHaut.setPreferredSize(new Dimension(80, 100));
        EcranGauche.setPreferredSize(new Dimension(200, 100));

        // ajout des parties de JPanel dans la JFrame selon un emplacement précis
        //add(EcranHaut,   BorderLayout.NORTH);
        add(EcranGauche, BorderLayout.WEST);
        add(Plateau,     BorderLayout.CENTER);
        add(Infos,       BorderLayout.EAST);
        add(EcranBas,    BorderLayout.SOUTH);
        System.out.println("mais peut etre pas par là !");

        affichage();
    }

    public void initialisationJeu(){

    }

    public void lancementJeu(){

    }
/*
    public void miseAJour(){
        // mise a jour des differents JPanel

        Infos.MiseAJour(Joueurs, Tour);
        EcranHaut.MiseAJour(Tour);
        Plateau.MiseAJour();

        affichage();
    }
*/
    public void JouerCarteMonopole(){
        // actions

        // mise a jour
        Infos.MiseAJour(Joueurs, Tour);
    }

    public static void main() {
        Vector<Joueur> j = new Vector<Joueur> ();
        FenetrePrincipale frame = new FenetrePrincipale("testage", 600, 1200, j);
    }

}
