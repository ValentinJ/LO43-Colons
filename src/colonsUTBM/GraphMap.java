package colonsUTBM;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;
import org.graphstream.ui.swingViewer.ViewerListener;
import org.graphstream.ui.swingViewer.ViewerPipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by val on 29/11/14.
 */
public class GraphMap{
    protected Graph g;
    protected Viewer viewer;
    protected View view;
    protected ViewerPipe fromViewer;
    protected ArrayList<Case> cases;
    protected ArrayList<NoeudConstructible> noeuds;
    protected ArrayList<Arete> aretes;

    //test
    private boolean loop;

    public GraphMap(boolean activerQualite){
        g = new SingleGraph("Map");
        if(activerQualite){
            g.addAttribute("ui.antialias");
            g.addAttribute("ui.quality");
        }
        cases = new ArrayList<Case>();
        noeuds = new ArrayList<NoeudConstructible>();
        aretes = new ArrayList<Arete>();
        loop=true;
    }

    public void chargerCSS(){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        g.addAttribute("ui.stylesheet", "url('file:///"+path+"/MapCSS.css')");
    }

    public void initMap(){
        int valeurDes[] = {11,3,6,5,4,9,10,8,4,11,12,9,10,8,3,6,2,5};

        //liste des types de ressource
        ArrayList<TypeCase> tcr = new ArrayList<TypeCase>();
        tcr.add(TypeCase.BIERE);
        tcr.add(TypeCase.BIERE);
        tcr.add(TypeCase.BIERE);
        tcr.add(TypeCase.BIERE);
        tcr.add(TypeCase.SOMMEIL);
        tcr.add(TypeCase.SOMMEIL);
        tcr.add(TypeCase.SOMMEIL);
        tcr.add(TypeCase.CAFE);
        tcr.add(TypeCase.CAFE);
        tcr.add(TypeCase.CAFE);
        tcr.add(TypeCase.CAFE);
        tcr.add(TypeCase.COURS);
        tcr.add(TypeCase.COURS);
        tcr.add(TypeCase.COURS);
        tcr.add(TypeCase.COURS);
        tcr.add(TypeCase.NOURRITURE);
        tcr.add(TypeCase.NOURRITURE);
        tcr.add(TypeCase.NOURRITURE);
        tcr.add(TypeCase.SEVENANS);
        //Mélange de la liste deux fois
        Collections.shuffle(tcr);
        Collections.shuffle(tcr);

        //liste des type de commerce
        ArrayList<TypeCase> tcc = new ArrayList<TypeCase>();
        tcc.add(TypeCase.BIERE);
        tcc.add(TypeCase.CAFE);
        tcc.add(TypeCase.COURS);
        tcc.add(TypeCase.NOURRITURE);
        tcc.add(TypeCase.SOMMEIL);
        Collections.shuffle(tcc); //mélande de la liste
        
        //Liste des points formant une case (hexagone)
        ArrayList<Point> pts = new ArrayList<Point>();
        pts.add(new Point(0,0));//Debut ressource indice 0
        pts.add(new Point(1,-1));
        pts.add(new Point(-1,-2));
        pts.add(new Point(-2,-1));
        pts.add(new Point(-1,1));
        pts.add(new Point(1,2));
        pts.add(new Point(2,1));
        pts.add(new Point(3,0));
        pts.add(new Point(2,-2));
        pts.add(new Point(0,-3));
        pts.add(new Point(-2,-4));
        pts.add(new Point(-3,-3));
        pts.add(new Point(-4,-2));
        pts.add(new Point(-3,0));
        pts.add(new Point(-2,2));
        pts.add(new Point(0,3));
        pts.add(new Point(2,4));
        pts.add(new Point(3,3));
        pts.add(new Point(4,2));//Fin ressource indice 18
        pts.add(new Point(4,-1));//Debut ocean + commerce indice 19
        pts.add(new Point(3,-3));
        pts.add(new Point(1,-4));
        pts.add(new Point(-1,-5));
        pts.add(new Point(-3,-6));
        pts.add(new Point(-4,-5));
        pts.add(new Point(-5,-4));
        pts.add(new Point(-6,-3));
        pts.add(new Point(-5,-1));
        pts.add(new Point(-4,1));
        pts.add(new Point(-3,3));
        pts.add(new Point(-1,4));
        pts.add(new Point(1,5));
        pts.add(new Point(3,6));
        pts.add(new Point(4,5));
        pts.add(new Point(5,4));
        pts.add(new Point(6,3));
        pts.add(new Point(5,1));//Fin ocean + commerce indice 36

        int m=0, mm=0;
        int compteur=0;

        for(Point p : pts){
            if(m<19) {
                if (tcr.get(m) == TypeCase.SEVENANS) {
                    cases.add(new CaseInterne(p, tcr.get(m), 0));
                }
                else {
                    cases.add(new CaseInterne(p, tcr.get(m), valeurDes[compteur]));
                    compteur++;
                }
            }
            else{
                if((m-19)%4==0) {
                    cases.add(new CaseExterne(p,tcc.get(0)));
                    tcc.remove(0);
                }
                if(((m-19)%4==1 || (m-19)%4==3)) {
                    cases.add(new CaseExterne(p, TypeCase.OCEAN));
                }
                if((m-19)%4==2){
                    cases.add(new CaseExterne(p, TypeCase.COMMERCETOUT));
                }
            }
            m++;
        }

        Edge e;
        ArrayList<Point> listeNoeuds = new ArrayList<Point>();
        for(Case c : cases){
            //Creation case et ajout css
            g.addNode(c.id);
            Node n = g.getNode(c.id);
            n.addAttribute("layout.frozen"); //todo ne freeze rien du tout !!
            n.setAttribute("xy", c.pts.transformerX(), c.pts.transformerY());
            n.addAttribute("ui.class", c.getTypeCSS());

            // Ajout du nombre associé à la ressource sauf SEVENANS
            if(c instanceof CaseInterne && ((CaseInterne) c).valeurDes!=0 ) {
                n.addAttribute("ui.label",((CaseInterne) c).valeurDes);
            }

            //Creations noeuds (point de construction UV ou UV**)
            mm=0; // compteur arête commerce
            listeNoeuds = c.getPointsCase(); // recuperation des futur points de la case (case ressource ou sevenans)
            for(Point p : listeNoeuds){
                if(g.getNode(p.getStringPointID())==null && c instanceof CaseInterne) { // verifier si point n'existe pas
                    g.addNode(p.getStringPointID()); // ajout des points à la map + attributs
                    noeuds.add(new NoeudConstructible(p));
                    n = g.getNode(p.getStringPointID());
                    n.setAttribute("xy",p.transformerX(), p.transformerY());
                    n.addAttribute("ui.label", p.getStringPointID());
                } //todo stocker les noeuds (point construction UV ou UV**) dans l'arraylist noeuds !
                //ajout arête case - noeud
                if(g.getNode(p.getStringPointID())!=null){
                    if(c instanceof CaseExterne && ((CaseExterne) c).isCommerce()){
                        if(mm<2) {
                            g.addEdge(c.pts.getStringPointID() + ":" + p.getStringPointID(), c.pts.getStringPointID(), p.getStringPointID());
                            e = g.getEdge(c.pts.getStringPointID() + ":" + p.getStringPointID());
                            e.addAttribute("ui.class", "edgeCommerce"); //à commenter pour voir liaison case - noeud
                        }
                        mm++;
                    }
                    if(c instanceof CaseInterne) {
                        g.addEdge(c.pts.getStringPointID() + ":" + p.getStringPointID(), c.pts.getStringPointID(), p.getStringPointID());
                        e = g.getEdge(c.pts.getStringPointID() + ":" + p.getStringPointID());
                        e.addAttribute("ui.class", "edgeCase"); //à commenter pour voir liaison case - noeud
                    }
                }
            }
            //On parcourt les 6 points constituant le tour d'une case, on ajoute les arêtes si elles ne sont pas
            // déjà créées. On le fait seulement pour les cases internet (hors ocean) - utilisation d'un modulo pour la
            //liaison entre le point indice 5 et 0 (permet la creation de l'arête)
            if(c instanceof CaseInterne)
            for(int i=0; i<listeNoeuds.size(); i++) {
                if (g.getEdge(listeNoeuds.get(i).getStringPointID() + ":" + listeNoeuds.get((i+1)%6).getStringPointID()) == null &&
                        g.getEdge(listeNoeuds.get((i+1)%6).getStringPointID() + ":" + listeNoeuds.get(i).getStringPointID()) == null) {
                    g.addEdge(listeNoeuds.get(i).getStringPointID() + ":" + listeNoeuds.get((i+1)%6).getStringPointID(), listeNoeuds.get(i).getStringPointID(), listeNoeuds.get((i+1)%6).getStringPointID());
                    for(NoeudConstructible x : noeuds){
                        if(x.id.equals(listeNoeuds.get(i).getStringPointID())){
                            for(NoeudConstructible y : noeuds){
                                if(y.id.equals(listeNoeuds.get((i + 1) % 6).getStringPointID())) {
                                    aretes.add(new Arete(x, y));
                                }
                            }
                        }
                    }
                }
            }

        }
        
    }

    public void MAJCSS(){
        for(Case c : cases){
            g.getNode(c.id).addAttribute("ui.class", c.getTypeCSS());
        }
        for(NoeudConstructible n : noeuds){
            g.getNode(n.id).addAttribute("ui.class", n.getTypeCSS());
        }
        for(Arete a : aretes){
            g.getEdge(a.id).addAttribute("ui.class", a.getTypeCSS());
        }
    }

    public void CSSpourConstructionUV1(){
        for(Node n : g.getEachNode()){
            for(NoeudConstructible nc : noeuds){

            }
        }
    }

    //todo faire méthode pour retourner une arralist des UV1old UV2old en fonction de la case
    public ArrayList<NoeudConstructible> getVoisinsCase(CaseInterne c){
        ArrayList<NoeudConstructible> voisins = new ArrayList<NoeudConstructible>();
        Iterator<Node> it = g.getNode(c.id).getNeighborNodeIterator();
        while (it.hasNext()) {
            Node n = it.next();
            //n.getId()
            // parcourir arraylist noeuds et trouver ceux d'instance UV1old ou UV2old et les stocker dans voisins
        }
        return voisins;
    }

    public void afficherMap(){
        viewer = g.display();
        viewer.disableAutoLayout();
        /*
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(g);
        */
    }

    public NoeudConstructible ClickConstructionUV1(Joueur j) {
        System.out.println("On entre dans le listener UV1");
        ViewerPipe fromViewer = viewer.newViewerPipe();

        fromViewer.addViewerListener(new ViewerListener() {
            @Override
            public void viewClosed(String s) {
                loop = false;
            }
            @Override
            public void buttonPushed(String s) {
                System.out.println("Button pushed on node "+s);
            }
            @Override
            public void buttonReleased(String s) {
                System.out.println("Button release on node "+s);
                loop=false;
            }
        });

        fromViewer.addSink(g);
        loop = true;

        while(loop) {
            fromViewer.pump();
            //Le sleep permet d'utiliser moins de ressources CPU
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println("Erreur : "+e.getMessage());
            }
            
        }


        System.out.println("On sort du listener UV1 !");
    return null;
    }

    public NoeudConstructible ClickConstructionUV2() {
        System.out.println("On entre dans le listener UV2 ");
        ViewerPipe fromViewer = viewer.newViewerPipe();

        fromViewer.addViewerListener(new ViewerListener() {
            @Override
            public void viewClosed(String s) {

            }

            @Override
            public void buttonPushed(String s) {
                System.out.println("Button pushed on node "+s);
            }

            @Override
            public void buttonReleased(String s) {
                System.out.println("Button release on node "+s);
                loop=false;
            }
        });
        fromViewer.addSink(g);
        loop = true;

        while(loop) {
            fromViewer.pump();
            //Le sleep permet d'utiliser moins de ressources CPU
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println("Erreur : "+e.getMessage());
            }

            // here your simulation code.

            // You do not necessarily need to use a loop, this is only an example.
            // as long as you call pump() before using the graph. pump() is non
            // blocking.  If you only use the loop to look at event, use blockingPump()
            // to avoid 100% CPU usage. The blockingPump() method is only available from
            // the nightly builds.
        }


        System.out.println("On sort du listener UV2 !");
        return null;
    }


    public View getView(){
        viewer = new Viewer(g, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD); //Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD
        view = viewer.addDefaultView(false);   // false indicates "no JFrame".
        return view;
    }

}
