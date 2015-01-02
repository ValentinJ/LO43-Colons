package fenetreGraphique;

import colonsUTBM.*;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by val on 02/01/15.
 */
public class TestJeuManagerJoueur {

    public static void main(String[] args) {
        Joueur j1 = new Joueur("Val", TypeCouleur.BLEU);
        Joueur j2 = new Joueur("IA", TypeCouleur.ROUGE);

        NoeudConstructible n = new NoeudConstructible(new Point(1,2));
        UV1 u = new UV1(n,j1);

        System.setProperty("org.graphstream.ui.renderer","org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        GraphMap g = new GraphMap(true);
        g.initMap();
        g.chargerCSS();
        g.afficherMap();
        g.majCSS();
        //MaFenetre mf = new MaFenetre(g.getView());

        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(new Joueur("Mickael", TypeCouleur.BLEU));
        joueurs.add(new Joueur("Elodie", TypeCouleur.VERT));
        joueurs.add(new Joueur("Thomas", TypeCouleur.ROUGE));




    }
}
