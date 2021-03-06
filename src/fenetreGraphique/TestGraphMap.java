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

        g.deplacerBinomeGlandeur();
        g.majCSS();

        System.out.println("#########\n Init UV1 Joueur 1 \n#########");
        g.InitConstructionUV1(j1);
        g.majCSS();
        //g.detailMapNoeudConstrutible();

        System.out.println("#########\n CC Joueur 1 \n#########");
        g.ClickConstructionControleContinus(j1);
        g.majCSS();
        g.detailMapArete();

        System.out.println("#########\n Init UV1 Joueur 1 \n#########");
        g.InitConstructionUV1(j1);
        g.majCSS();

        System.out.println("#########\n CC Joueur 1 \n#########");
        g.ClickConstructionControleContinus(j1);
        g.majCSS();
        g.detailMapArete();

        System.out.println("#########\n Init UV1 Joueur 2 \n#########");
        g.InitConstructionUV1(j2);
        g.majCSS();

        System.out.println("#########\n CC Joueur 2 \n#########");
        g.ClickConstructionControleContinus(j2);
        g.majCSS();
        g.detailMapArete();
        g.ClickConstructionControleContinus(j2);
        g.majCSS();
        //g.detailMapArete();

        System.out.println("#########################################################");
        for(NoeudConstructible nn :g.getVoisinsCase((CaseInterne)g.getCases().get(0)) ){
            System.out.println(nn.getTypeCSS());
        }
        System.out.println("#########################################################");


        System.out.println("#########\nUV1 Joueur 1 \n#########");
        g.ClickConstructionUV1(j1);
        g.majCSS();

        g.ClickConstructionControleContinus(j1);
        g.majCSS();
        g.detailMapArete();

        g.ClickConstructionControleContinus(j2);
        g.majCSS();
        g.detailMapArete();

    }
}
