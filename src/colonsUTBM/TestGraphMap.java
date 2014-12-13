package colonsUTBM;

/**
 * Created by val on 30/11/14.
 */
public class TestGraphMap {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui.renderer","org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        GraphMap g = new GraphMap(true);
        g.initMap();
        g.chargerCSS();
        g.afficherMap();
        g.MAJCSS();
        //MaFenetre mf = new MaFenetre(g.getView());
        Joueur j1 = new Joueur("Val", TypeCouleur.BLEU);
        Joueur j2 = new Joueur("IA", TypeCouleur.ROUGE);
        g.ClickConstructionUV1();
        g.ClickConstructionUV2();

    }
}
