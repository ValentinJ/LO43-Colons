package fenetreGraphique;

import colonsUTBM.*;

/**
 * Created by val on 30/11/14.
 */
public class TestGraphMap {
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


        g.ClickConstructionUV1(j1);
        g.majCSS();
        //g.detailMapNoeudConstrutible();
        g.ClickConstructionUV1(j1);
        g.majCSS();
        g.ClickConstructionUV1(j2);
        g.majCSS();
        g.ClickConstructionUV2(j1);
        g.majCSS();
        //g.detailMapNoeudConstrutible();

        g.ClickConstructionControleContinus(j1);
        g.majCSS();
        g.detailMapArete();

        g.ClickConstructionControleContinus(j2);
        g.majCSS();
        g.detailMapArete();

        g.ClickConstructionControleContinus(j1);
        g.majCSS();
        g.detailMapArete();

        g.ClickConstructionControleContinus(j2);
        g.majCSS();
        g.detailMapArete();

    }
}
