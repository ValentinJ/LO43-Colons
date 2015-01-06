package colonsUTBM;

import fenetreGraphique.FenetrePrincipale;

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

    protected FenetrePrincipale f;
    protected boolean actionEnCours;

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
        f = new FenetrePrincipale("Colons de l'UTBohèMe - Projet LO43", 720, 1280, this);
        actionEnCours=false;
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
        System.out.println("Ajout des ressources adjacentes à la 2ième UV");
        for(Joueur j : joueurs){
            for(TypeRessource r : terrain.getVoisinsRessources(j.getUvs().get(1)) ){
                j.ajoutRessourceProd(r, 1, pilesRessources, r, 1);
            }
        }
        System.out.println("FIN : PHASES FONDATION DES UV et CC");



        while(!terminer){
            for(Joueur j : joueurs){
                des.lancerDes();
                System.out.println(this.toString());
                System.out.println("Lancé des dés : " + des.getTotalDes());
                System.out.println("DEBUT : TOUR n°"+tour+" pour le joueur "+j.getNom());
                productionRessource(des.getTotalDes());
                f.miseAJour();
                tourCourant=tour;

                if(des.getTotalDes()==7) {
                    actionEnCours=true;
                    f.miseAJour();
                    terrain.deplacerBinomeGlandeur();
                    for (Joueur j1 : joueurs){
                        j1.eneleverMoitiecarte(pilesRessources);
                    }
                    actionEnCours=false;
                    f.miseAJour();
                }


                while(tour==tourCourant){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                j.validerCartesEnAttente();
                //todo test calcul score
                calculerScore();
                for(Joueur jjj : joueurs){
                    System.out.println(jjj.getNom()+" : "+jjj.getScore());
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
                System.out.println(noeudOccuper.get(j).toString());
                // pour chaque noeud adjacent occuper, gain ressource du type de la case <-AjoutRessource
                if (noeudOccuper.get(j) instanceof UV2) {
                    System.out.println("Ajout de 2 ressources");
                    ((UV2) noeudOccuper.get(j)).getJ().ajoutRessourceProd(caseProd.get(i).getTr(), 2, pilesRessources, caseProd.get(i).getTr(), 2);
                }
                else {
                    System.out.println("Ajout de 1 ressource");
                    ((UV1) noeudOccuper.get(j)).getJ().ajoutRessourceProd(caseProd.get(i).getTr(), 1, pilesRessources, caseProd.get(i).getTr(), 1);
                }
            }
        }
    }

    public void determinerPlusCC(){
        Joueur tmp = null;
        int nbCC;
        for(Joueur j : joueurs){
            nbCC = j.getCCsize();
            if(nbCC>=5){
                tmp = j;
                if(j.getCCsize()>tmp.getCCsize()){
                    tmp=j;
                }
            }

        }
        if(tmp!=null) {
            for (Joueur j : joueurs) {
                j.setPlusCC(false);
                if (tmp.equals(j))
                    j.setPlusCC(true);
            }
        }
    }

    public void determinerPlusAncien(){
        Joueur tmp = null;
        int tab[];
        int tabtmp[];
        for(Joueur j : joueurs){
            tab = j.getAncien();
            if(tab[2]>=3){
                tmp = j;
                tabtmp = tmp.getAncien();
                if(tab[2]>tabtmp[2]){
                    tmp=j;
                }
            }

        }
        if(tmp!=null) {
            for (Joueur j : joueurs) {
                j.setPlusAncien(false);
                if (tmp.equals(j))
                    j.setPlusAncien(true);
            }
        }
    }

    //todo calcul des score à finir !!!!
    public void calculerScore(){
        ArrayList<Integer> t;
        determinerPlusAncien();
        determinerPlusCC();
        for(Joueur jou : joueurs){
            t = jou.getNbUvs();
            jou.setScore(t.get(0)+t.get(1));
            if(jou.isPlusAncien())
                jou.setScore(jou.getScore()+2);
            if(jou.isPlusCC())
                jou.setScore(jou.getScore()+2);
        }


    }

    public Joueur calculerScoreFinal(){
        Joueur j = this.getJoueurs().get(0) ;
        for(int i=1 ; i < joueurs.size(); i++){
            if (j.getScore() < this.getJoueurs().get(i).getScore()){
                j = this.getJoueurs().get(i);
            }
        }
        return j;
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

    public void phaseFondation(){
        int tourCourant;
        for (int i=0; i<joueurs.size();i++){
            tour=i;
            tourCourant=tour;

            actionEnCours=true;
            f.miseAJour();
            joueurs.get(i).getUvs().add(terrain.InitConstructionUV1(joueurs.get(i)));
            terrain.majCSS();
            joueurs.get(i).getCC().add(terrain.ClickConstructionControleContinus(joueurs.get(i)));
            terrain.majCSS();
            joueurs.get(i).nbUv1--;
            joueurs.get(i).nbCc--;

            System.out.println(this.toString());


            actionEnCours=false;
            f.miseAJour();

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

            actionEnCours=true;
            f.miseAJour();

            joueurs.get(i).getUvs().add(terrain.InitConstructionUV1(joueurs.get(i)));
            terrain.majCSS();
            joueurs.get(i).getCC().add(terrain.ClickConstructionControleContinus(joueurs.get(i)));
            terrain.majCSS();
            joueurs.get(i).nbUv1--;
            joueurs.get(i).nbCc--;

            System.out.println(this.toString());


            actionEnCours=false;
            f.miseAJour();

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

    public boolean isActionEnCours() {
        return actionEnCours;
    }

    public FenetrePrincipale getF() {
        return f;
    }
}
