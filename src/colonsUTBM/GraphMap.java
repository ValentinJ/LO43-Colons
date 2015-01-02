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
        System.setProperty("org.graphstream.ui.renderer","org.graphstream.ui.j2dviewer.J2DGraphRenderer");
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
            //n.addAttribute("layout.frozen"); //todo ne freeze rien du tout !!
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
                }
                //ajout arête case - noeud
                if(g.getNode(p.getStringPointID())!=null){
                    if(c instanceof CaseExterne && ((CaseExterne) c).isCommerce()){
                        if(mm<2) {
                            g.addEdge(c.pts.getStringPointID() + ":" + p.getStringPointID(), c.pts.getStringPointID(), p.getStringPointID());
                            e = g.getEdge(c.pts.getStringPointID() + ":" + p.getStringPointID());
                            e.addAttribute("ui.class", "edgeCommerce"); //à commenter pour voir liaison case - noeud
                            e.addAttribute("layout.weight", 100);
                        }
                        mm++;
                    }
                    if(c instanceof CaseInterne) {
                        g.addEdge(c.pts.getStringPointID() + ":" + p.getStringPointID(), c.pts.getStringPointID(), p.getStringPointID());
                        e = g.getEdge(c.pts.getStringPointID() + ":" + p.getStringPointID());
                        e.addAttribute("ui.class", "edgeCase"); //à commenter pour voir liaison case - noeud
                        e.addAttribute("layout.weight", 100);
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
                    g.getEdge(listeNoeuds.get(i).getStringPointID() + ":" + listeNoeuds.get((i+1)%6).getStringPointID()).addAttribute("layout.weight", -1);
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

    public void majCSS(){
        majCasesCSS();
        majNoeudsCSS();
        majAretesCSS();
    }

    public void majCasesCSS(){
        for(Case c : cases){
            c.setTypeCSS();
            g.getNode(c.id).addAttribute("ui.class", c.getTypeCSS());
        }
    }

    public void majNoeudsCSS(){
        for(NoeudConstructible n : noeuds){
            g.getNode(n.id).addAttribute("ui.class", n.getTypeCSS());
        }
    }

    public void majAretesCSS(){
        for(Arete a : aretes){
            g.getEdge(a.id).addAttribute("ui.class", a.getTypeCSS());
        }
    }

    public ArrayList<Case> getCases(){
        return cases;
    }

    public NoeudConstructible getNoeudConstructible(String id){
        for(NoeudConstructible n : noeuds){
            if(n.id.equals(id)) return n;
        }
        return null;
    }

    public void CSSpourConstructionUV1(){
        for(Node n : g.getEachNode()){
            for(NoeudConstructible nc : noeuds){

            }
        }
    }

    public ArrayList<NoeudConstructible> getVoisinsCase(CaseInterne c) {
        ArrayList<NoeudConstructible> voisins = new ArrayList<NoeudConstructible>();
        Iterator<Node> it = g.getNode(c.id).getNeighborNodeIterator();
        while (it.hasNext()) {
            Node n = it.next();
            if (!n.getAttribute("ui.class").equals("noeud")) voisins.add(getNoeudConstructible(n.getId()));
        }
        return voisins;
    }

    public void afficherMap(){
        viewer = g.display();
        viewer.disableAutoLayout();
        //viewer.getDefaultView().getCamera().setViewPercent(1.05);
    }

    public boolean verifierConstructionUV1(String id){
        boolean b = false;
        for (NoeudConstructible n : noeuds){
            if(n.getId().equals(id) && n.tn==TypeNoeud.VIDE ) {
                b = true;
            }
        }
        return b;
    }

    public boolean verifierPasDeVoisinsConstructionUV1(String id){
        boolean b=false;
        int i=0;
        Iterator<Node> it = g.getNode(id).getNeighborNodeIterator();
        System.out.println("Voisins de "+id+" :");
        while (it.hasNext()) {
            Node n = it.next();
            if(n.getAttribute("ui.class").equals("noeud")) i++;
            if(i==3) b=true;
            System.out.println(n.getAttribute("ui.class"));
        }
        return b;
    }

    public boolean verifierConstructionUV2(String id, Joueur j){
        boolean b = false;
        for (NoeudConstructible n : noeuds){
            if(n.getId().equals(id) && n.tn==TypeNoeud.UV1 && j.equals(((UV1)n).getJ())) {
                b = true;
            }
        }
        return b;
    }

    public boolean verifierConstructionControleContinusA(String idA, Joueur j){
        boolean b = false;
        for (NoeudConstructible n : noeuds) {
            if (n.getId().equals(idA) && n.tn != TypeNoeud.VIDE && j.equals(((UV1) n).getJ())) {
                b = true;
            } else if (n.getId().equals(idA) && n.tn == TypeNoeud.VIDE && verifierNoeudConstructiblePossedeAreteDuJoueur(n,j)) {
                b = true;
            }
        }
        return b;
    }

    public boolean verifierConstructionControleContinusB(String idA, String idB, Joueur j){
        boolean b = false;
        for (NoeudConstructible n : noeuds) {
            if (n.getId().equals(idB) && n.tn != TypeNoeud.VIDE && j.equals(((UV1) n).getJ()) && verifierAreteEstVideOuExiste(idA,idB)) {
                b = true;
            } else if (n.getId().equals(idB) /*&& n.tn == TypeNoeud.VIDE*/ && verifierAreteEstVideOuExiste(idA,idB)) {
                b = true;
            }
        }
        return b;
    }

    public boolean verifierNoeudConstructiblePossedeAreteDuJoueur(NoeudConstructible n, Joueur j){
        boolean b = false;

        Iterator<Edge> it = g.getNode(n.id).getEnteringEdgeIterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            System.out.println(edge.getAttribute("ui.class")+"="+"conctroleContinu, "+j.getCouleur());
            if(edge.getAttribute("ui.class").equals("controleContinu, "+j.getCouleur())){
                b=true;
            }
        }

        return b;
    }

    public boolean verifierNoeudConstructiblePossedeAreteDuJoueur(String id, Joueur j){
        boolean b = false;

        Iterator<Edge> it = g.getNode(id).getEnteringEdgeIterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            System.out.println(edge.getAttribute("ui.class")+"="+"conctroleContinu, "+j.getCouleur());
            if(edge.getAttribute("ui.class").equals("controleContinu, "+j.getCouleur())){
                b=true;
            }
        }

        return b;
    }

    public boolean verifierAreteEstVideOuExiste(String idA, String idB){
        boolean b = false;
        for( Arete ar : aretes){
            if(ar.getTypeCSS().equals("") && ( ar.getIdArete().equals(idA+":"+idB) || ar.getIdArete().equals(idB+":"+idA) ) )
                b=true;
        }


        return b;
    }

    public boolean verifierDeplacementBinomeGlandeur(String id){
        boolean b = false;
        for( Case ca : cases){
            if(ca instanceof CaseInterne && ca.getId().equals(id))
                b=true;
        }
        return b;
    }

    public NoeudConstructible ClickConstructionUV1(final Joueur j) {
        final String[] IDClicked = {""};
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
            public void buttonReleased(String id) {
                System.out.println("Button release on node "+id);

                if(verifierConstructionUV1(id) && verifierPasDeVoisinsConstructionUV1(id) && verifierNoeudConstructiblePossedeAreteDuJoueur(id,j) ) {
                    loop = false;
                    IDClicked[0] = id;
                }
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
        NoeudConstructible tmp = new NoeudConstructible();
        for(NoeudConstructible n : noeuds){
            if(n.getId().equals(IDClicked[0])){
                tmp = n;
            }
        }
        noeuds.set(noeuds.indexOf(tmp),new UV1(tmp,j));
        System.out.println("On sort du listener UV1 !");
    return null;
    }

    public NoeudConstructible InitConstructionUV1(final Joueur j) {
        final String[] IDClicked = {""};
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
            public void buttonReleased(String id) {
                System.out.println("Button release on node "+id);

                if(verifierConstructionUV1(id) && verifierPasDeVoisinsConstructionUV1(id) ) {
                    loop = false;
                    IDClicked[0] = id;
                }
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
        NoeudConstructible tmp = new NoeudConstructible();
        for(NoeudConstructible n : noeuds){
            if(n.getId().equals(IDClicked[0])){
                tmp = n;
            }
        }
        noeuds.set(noeuds.indexOf(tmp),new UV1(tmp,j));
        System.out.println("On sort du listener UV1 !");
        return null;
    }

    public NoeudConstructible ClickConstructionUV2(final Joueur j) {
        final String[] IDClicked = {""};
        System.out.println("On entre dans le listener UV2");
        ViewerPipe fromViewer = viewer.newViewerPipe();

        fromViewer.addViewerListener(new ViewerListener() {
            @Override
            public void viewClosed(String s) {
                loop = false;
            }

            @Override
            public void buttonPushed(String s) {
                System.out.println("Button pushed on node " + s);
            }

            @Override
            public void buttonReleased(String id) {
                System.out.println("Button release on node " + id);

                if (verifierConstructionUV2(id,j)) {
                    loop = false;
                    IDClicked[0] = id;
                }
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
        UV1 tmp = new UV1();
        for(NoeudConstructible n : noeuds){
            if(n.getId().equals(IDClicked[0])){
                tmp = (UV1)n;
            }
        }
        noeuds.set(noeuds.indexOf(tmp),new UV2(tmp));
        System.out.println("On sort du listener UV2 !");
        return null;
    }

    public ControleContinus ClickConstructionControleContinus(final Joueur j){
        final String[] IDClicked = {"",""};
        System.out.println("On entre dans le listener ControleContinus");
        ViewerPipe fromViewer = viewer.newViewerPipe();

        fromViewer.addViewerListener(new ViewerListener() {
            @Override
            public void viewClosed(String s) {
                loop = false;
            }

            @Override
            public void buttonPushed(String s) {
                System.out.println("Button pushed on node " + s);
            }

            @Override
            public void buttonReleased(String id) {
                System.out.println("Button release on node " + id);
                if(IDClicked[0]==id){
                    IDClicked[0]="";
                    System.out.println("Annulation construction Contrôle continu !");
                    majCSS();
                }

                else if(IDClicked[0]!="" && verifierConstructionControleContinusB(IDClicked[0],id,j)){
                    loop = false;
                    IDClicked[1]= id;
                }
                else if (verifierConstructionControleContinusA(id,j) && IDClicked[0]=="") {
                    IDClicked[0] = id;
                    g.getNode(id).addAttribute("ui.class", "edgeConstruction");
                    System.out.println("Ajout du css pour le noeud en cours");
                }

            }
        });
        fromViewer.addSink(g);
        loop = true;
        while(loop) {
            fromViewer.pump();
            //Le sleep permet d'utiliser moins de ressources CPU
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Erreur : " + e.getMessage());
            }

        }


        Arete tmp = new Arete();
        for(Arete ar : aretes){
            if(ar.getIdArete().equals(IDClicked[0]+":"+IDClicked[1]) || ar.getIdArete().equals(IDClicked[1]+":"+IDClicked[0])){
                tmp = ar;
            }
        }
        aretes.set(aretes.indexOf(tmp),new ControleContinus(tmp,j));

        //noeuds.set(noeuds.indexOf(tmp),new UV2(tmp));
        System.out.println("On sort du listener ControleContinus !");

        return null;
    }

    public void deplacerBinomeGlandeur(){
        final String[] IDClicked = {""};
        System.out.println("On entre dans le listener Deplacer binome");
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
            public void buttonReleased(String id) {
                System.out.println("Button release on node "+id);

                if(verifierDeplacementBinomeGlandeur(id)) {
                    loop = false;
                    IDClicked[0] = id;
                }
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


        //todo deplacer binome
        for(Case ca : cases){
            if(ca instanceof CaseInterne){
                ((CaseInterne) ca).binomeGlandeur=false;
            }
        }
        for(Case ca : cases){
            if(ca.getId().equals(IDClicked[0])){
                ((CaseInterne) ca).binomeGlandeur=true;
            }
        }
        System.out.println("On sort du listener deplacer binome !");

    }

    public View getView(){
        viewer = new Viewer(g, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD); //Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD
        view = viewer.addDefaultView(false);   // false indicates "no JFrame".
        viewer.getDefaultView().getCamera().setViewPercent(1.05);

        return view;
    }

    public void detailMapNoeudConstrutible(){

        for(NoeudConstructible n : noeuds){
            System.out.println("----"+n.toString()+"----");
            System.out.println("ID : "+n.getId());
            System.out.println("TypeCSS : "+n.getTypeCSS());
            System.out.println("TypeNoeud : "+n.getTn());
        }

    }

    public void detailMapArete(){

        for(Arete n : aretes){
            System.out.println("----"+n.toString()+"----");
            System.out.println("ID : "+n.getIdArete());
            System.out.println("TypeCSS : "+n.getTypeCSS());
        }

    }

}
