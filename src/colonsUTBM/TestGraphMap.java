package colonsUTBM;

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
        g.MAJCSS();
        //MaFenetre mf = new MaFenetre(g.getView());

        g.ClickConstructionControleContinus(j1);
        g.MAJCSS();
        g.detailMapArete();
        g.ClickConstructionUV1(j1);
        g.MAJCSS();
        //g.detailMapNoeudConstrutible();
        g.ClickConstructionUV1(j2);
        g.MAJCSS();
        g.ClickConstructionUV2(j2);
        g.MAJCSS();
        g.ClickConstructionUV2(j1);
        g.MAJCSS();
        //g.detailMapNoeudConstrutible();

    }
}
