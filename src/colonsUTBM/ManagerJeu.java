package colonsUTBM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

/**
 * Created by Guillaume on 03/12/2014.
 */

public class ManagerJeu {

    protected ArrayList<Joueur> joueurs;
    protected Hashtable<TypeRessource,Pile> pilesRessources;
    protected ArrayList<CarteDeveloppement> pilesDeveloppement;

    protected ArrayList<Integer> valeurDes;
    protected int tour;
    protected GraphMap terrain;
    protected Des des;

    public ManagerJeu(){}

    public ManagerJeu(ArrayList<Joueur> j){
        joueurs = j;
        melangerOrdreJoueur();
        terrain = new GraphMap(true);
        terrain.initMap();
        terrain.chargerCSS();

        des = new Des();
        tour = 0;

        pilesDeveloppement = new ArrayList<CarteDeveloppement>();
        pilesRessources = new Hashtable<TypeRessource, Pile>();
        InitVariables();
    }

    public ManagerJeu(ArrayList<Joueur> j, GraphMap t, Point p){
        joueurs = j;
        melangerOrdreJoueur();
        terrain = t;
        terrain.initMap();
        des = new Des();

        /*
        System.setProperty("org.graphstream.ui.renderer","org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        GraphMap g = new GraphMap(true);
        g.initMap();
        g.chargerCSS();
        g.afficherMap();
        g.majCSS();
        */
        tour = 0;

    }

    public void melangerOrdreJoueur(){
        Collections.shuffle(joueurs);
        Collections.shuffle(joueurs);
    }
    public void melangerCarteDeveloppement(){
        Collections.shuffle(pilesDeveloppement);
        Collections.shuffle(pilesDeveloppement);
    }

    public void jouer(){
        boolean terminer = false;
        int tourCourant;
        System.out.println("DEBUT : PHASES FONDATION DES UV et CC");
        phaseFondation();
        System.out.println("FIN : PHASES FONDATION DES UV et CC");

        while(!terminer){
            for(Joueur j : joueurs){
                des.lancerDes();
                System.out.println("Lancé des dés : "+des.getTotalDes());
                System.out.println("DEBUT : TOUR n°"+tour+" pour le joueur "+j.getNom());
                productionRessource(des.getTotalDes());
                tourCourant=tour;

                if(des.getTotalDes()==7)
                    terrain.deplacerBinomeGlandeur();

                while(tour==tourCourant){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Fin de tour pour le joueur "+j.getNom());
            }
        }
        System.out.println("La partie se termine...");
    }

    public void finDeTour() {
        tour += 1;
        // vlider carte dev en main
        terrain.majCSS();
    }


    public void productionRessource(int valeurDes){
    // ne peut le faire sans fonction de valentin
    //getVoisinCase(); // classe de terrain
    // avec valeur des, recup toutes les cases ayant cette valeur

        ArrayList<CaseInterne> caseProd = new ArrayList<CaseInterne>();
        ArrayList<NoeudConstructible> noeudOccuper = new ArrayList<NoeudConstructible>();

        // recupere les case produisant les ressources
        for (int i = 0 ; i < (terrain.getCases()).size() ; i++){
            if ( ((terrain.getCases()).get(i)) instanceof CaseInterne){
                if ( ((CaseInterne) ((terrain.getCases()).get(i))).getValeurDes() == valeurDes ){
                    caseProd.add((CaseInterne) ((terrain.getCases()).get(i)));
                }
            }
        }


        // pour chaque case recup, trouver si un noeud adjacent est occuper   <- ici getVoisinCase();
        for (int i = 0 ; i < caseProd.size() ; i++){
            noeudOccuper = terrain.getVoisinsCase(caseProd.get(i));
            for (int j = 0 ; j < noeudOccuper.size() ; j++){
                // pour chaque noeud adjacent occuper, gain ressource du type de la case <-AjoutRessource
                if (noeudOccuper.get(j) instanceof UV1)
                    ((UV1)noeudOccuper.get(j)).getJ().ajoutRessource(caseProd.get(i).getTr(),1);
                else
                    ((UV2)noeudOccuper.get(j)).getJ().ajoutRessource(caseProd.get(i).getTr(), 2);
            }
        }
    }

    public void calculerScore(){                                     // besoin accesseur coord UV : "getUV1()" et "getUV2()"
        ArrayList<Integer> joueurCC = new ArrayList<Integer>();
        ArrayList<Integer> joueurAncien = new ArrayList<Integer>();
        // calcule en fonction des UVs
        for(int i=0; i<joueurs.size(); i++){
            (joueurs.get(i)).setScore(((joueurs.get(i)).getUV1()) + ((joueurs.get(i)).getUV2())*2);
            if ( ((joueurs.get(i)).getCCsize()) > 4){
                joueurCC.add(i);
            }
            if ( ((joueurs.get(i)).getAncien()) > 2){
                joueurAncien.add(i);
            }
        }

        // ajout des bonus de CC
        if (joueurCC.size() > 0){
            if (joueurCC.size() == 1){
                (joueurs.get(joueurCC.get(0))).setScore((joueurs.get(joueurCC.get(0))).getScore() + 2);
            }
            else{
                int place=0;
                int val=0;
                for(int i=0; i<joueurCC.size(); i++){
                    if (val < (joueurs.get(joueurCC.get(i))).getCCsize() ){
                        val = (joueurs.get(joueurCC.get(i))).getCCsize();
                        place = i;
                    }
                }
                (joueurs.get(joueurCC.get(place))).setScore((joueurs.get(joueurCC.get(place))).getScore()+2);
            }
        }

        // ajout des bonus de Ancien
        if (joueurAncien.size() > 0){
            if (joueurAncien.size() == 1){
                (joueurs.get(joueurAncien.get(0))).setScore((joueurs.get(joueurAncien.get(0))).getScore() + 2);
            }
            else{
                int place=0;
                int val=0;
                for(int i=0; i<joueurAncien.size(); i++){
                    if (val < (joueurs.get(joueurAncien.get(i))).getAncien() ){
                        val = (joueurs.get(joueurAncien.get(i))).getAncien();
                        place = i;
                    }
                }
                (joueurs.get(joueurAncien.get(place))).setScore((joueurs.get(joueurAncien.get(place))).getScore()+2);
            }
        }
    }

    public int calculerScoreFinal(){
        for(int i=0 ; i < joueurs.size(); i++){
            calculerScore();
            for (int j = 0; j < ((joueurs.get(i)).getMainDeveloppement()).size(); j++) {
                if ((((joueurs.get(i)).getMainDeveloppement()).get(j)).getTypeDeveloppement() == TypeDeveloppement.POINTVICTOIRE){
                    (joueurs.get(i)).setScore((joueurs.get(i)).getScore() + 1);
                }
            }
        }
        return 0;
    }

    public void InitVariables(){
        // Ajout des cartes developpement dans l'arralylist et mélange
        // 25 au total : 6*Progres : 2*CCC, 2*Decouverte, 2*Monopole + 5*Point de Victoire + 14*Ancien
        ArrayList<CarteDeveloppement> pilesD = new ArrayList<CarteDeveloppement>();
        for (int i=0; i<2; i++) {
            pilesD.add(new CarteDeveloppement(TypeDeveloppement.CCC));
        }
        for (int i=0; i<2; i++) {
            pilesD.add(new CarteDeveloppement(TypeDeveloppement.DECOUVERTE));
        }
        for (int i=0; i<2; i++) {
            pilesD.add(new CarteDeveloppement(TypeDeveloppement.MONOPOLE));
        }
        for (int i=0; i<5; i++) {
            pilesD.add(new CarteDeveloppement(TypeDeveloppement.POINTVICTOIRE));
        }
        for (int i=0; i<14; i++) {
            pilesD.add(new CarteDeveloppement(TypeDeveloppement.ANCIEN));
        }
        pilesDeveloppement = pilesD;
        melangerCarteDeveloppement();

        // Ajout des piles ressources dans le Hashtable
        pilesRessources.put(TypeRessource.BIERE, new Pile(new CarteRessource(TypeRessource.BIERE),19));
        pilesRessources.put(TypeRessource.SOMMEIL, new Pile(new CarteRessource(TypeRessource.SOMMEIL), 19));
        pilesRessources.put(TypeRessource.CAFE, new Pile(new CarteRessource(TypeRessource.CAFE),19));
        pilesRessources.put(TypeRessource.COURS, new Pile(new CarteRessource(TypeRessource.COURS),19));
        pilesRessources.put(TypeRessource.NOURRITURE, new Pile(new CarteRessource(TypeRessource.NOURRITURE),19));
    }

    /* A VIRER CAR PENSE POSER PB POUR AFFICHAGE GRAPHIQUE */
    public void phaseFondation(){
        int tourCourant;
        for (int i=0; i<joueurs.size();i++){
            tour=i;
            tourCourant=tour;

            joueurs.get(i).getUvs().add(terrain.InitConstructionUV1(joueurs.get(i)));
            terrain.majCSS();
            joueurs.get(i).getCC().add(terrain.ClickConstructionControleContinus(joueurs.get(i)));
            terrain.majCSS();

            while(tour==tourCourant){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(tour);
        }
        for (int i=joueurs.size()-1; i>=0;i--){
            tour=i;
            tourCourant=tour;

            joueurs.get(i).getUvs().add(terrain.InitConstructionUV1(joueurs.get(i)));
            terrain.majCSS();
            terrain.ClickConstructionControleContinus(joueurs.get(i));
            terrain.majCSS();

            while(tour==tourCourant){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(tour);

        }
        tour=0;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Hashtable<TypeRessource,Pile> getPilesRessources() {
        return pilesRessources;
    }

    public ArrayList<CarteDeveloppement> getPilesDeveloppement() {
        return pilesDeveloppement;
    }

    public ArrayList<Integer> getValeurDes() {
        return valeurDes;
    }

    public int getTour() {
        return tour;
    }

    public GraphMap getTerrain() {
        return terrain;
    }

    public Des getDes() {
        return des;
    }

    public String toString(){
        String txt = "";

        txt = "TOUR n°"+tour+"\n"+
                "\tNombre de ressources BIERE..... : \t"+ pilesRessources.get(TypeRessource.BIERE).getNombre()+"\n"+
                "\tNombre de ressources CAFE...... : \t"+ pilesRessources.get(TypeRessource.CAFE).getNombre()+"\n"+
                "\tNombre de ressources COURS..... : \t"+ pilesRessources.get(TypeRessource.COURS).getNombre()+"\n"+
                "\tNombre de ressources NOURRITURE : \t"+ pilesRessources.get(TypeRessource.NOURRITURE).getNombre()+"\n"+
                "\tNombre de ressources SOMMEIL... : \t"+ pilesRessources.get(TypeRessource.SOMMEIL).getNombre()+"\n"+
                "\tNombre cartes DEVELOPPEMENT.... : \t"+ pilesDeveloppement.size();


        return txt;
    }

    public Joueur getJoueurCourrant(){
        return joueurs.get(tour%joueurs.size());
    }

    public String msgGenerationR(){
        String msg = "";
        ArrayList<CaseInterne> caseProd = new ArrayList<CaseInterne>();
        ArrayList<NoeudConstructible> noeudOccuper = new ArrayList<NoeudConstructible>();

        // recupere les case ayant produit les ressources
        for (int i = 0 ; i < (terrain.getCases()).size() ; i++){
            if ( ((terrain.getCases()).get(i)) instanceof CaseInterne){
                if ( ((CaseInterne) ((terrain.getCases()).get(i))).getValeurDes() == this.getDes().getTotalDes() ){
                    caseProd.add((CaseInterne) ((terrain.getCases()).get(i)));
                }
            }
        }

        // pour chaque case recuperer, trouver si un noeud adjacent est occuper
        for (int i = 0 ; i < caseProd.size() ; i++){
            noeudOccuper = terrain.getVoisinsCase(caseProd.get(i));
            for (int j = 0 ; j < noeudOccuper.size() ; j++){
                msg = msg + "<html>Le joueur " + (((UV1) noeudOccuper.get(j)).getJ()).getNom() + " a obtenu ";
                // pour chaque noeud adjacent occuper, gain ressource du type de la case
                if (noeudOccuper.get(j) instanceof UV1)
                    msg = msg + "1 carte de type " + caseProd.get(i).getTr().toString() + ".</br>";
                else
                    msg = msg + "2 cartes de type " + caseProd.get(i).getTr().toString() + ".</br>";
            }
        }

        if (msg.equals("")){
            msg = "Aucune production de ressource pour ce tour";
        }
        else{
            msg = msg + "</html>";
        }

        return msg;
    }
}
