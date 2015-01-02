package fenetreGraphique;

import colonsUTBM.GraphMap;
import colonsUTBM.Joueur;

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
    public int Tour;

    public GraphMap g;

    public FenetrePrincipale(String _nom, int _h, int _l, ArrayList<Joueur> _J) {
        super(_nom, _h, _l);

        Joueurs = _J;
        nbJoueur = Joueurs.size();
        //Menu = new BarreMenu();

        g = new GraphMap(true);
        g.initMap();
        g.chargerCSS();
        g.majCSS();

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        //permet d'ajouter plusieurs JPanel sans ecraser les anciens
        getContentPane().setLayout(new BorderLayout());

        // creation des JPanel
        String msg_appli = "MSG INFOS : Application développée par Sara, Yuanxiang, Valentin, Guillaume";
        EcranBas = new EcranBas(msg_appli);
        // instanciation du JPanel EcranGauche
        EcranGauche = new EcranGauche();
        Plateau = new Plateau(g.getView());

        try {
            Infos = new EcranDroit(Joueurs, Tour);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // definit taille des JPanel
        EcranGauche.setPreferredSize(new Dimension(200, 100));

        // ajout des parties de JPanel dans la JFrame selon un emplacement précis
        add(EcranGauche, BorderLayout.WEST);
        add(Plateau,     BorderLayout.CENTER);
        add(Infos,       BorderLayout.EAST);
        add(EcranBas,    BorderLayout.SOUTH);

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
        ArrayList<Joueur> j = new ArrayList<Joueur> ();
        FenetrePrincipale frame = new FenetrePrincipale("testage", 600, 1200, j);
    }

}
