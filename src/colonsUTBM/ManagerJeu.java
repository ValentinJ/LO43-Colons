package colonsUTBM;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Guillaume on 03/12/2014.
 */

public class ManagerJeu {
    protected ArrayList<Joueur> joueurs;
    protected ArrayList<Pile> pilesRessources;
    protected ArrayList<CarteDeveloppement> pilesDeveloppement;

    protected ArrayList<Integer> valeurDes;
    protected int tour;
    protected GraphMap terrain;
    protected Point positionBinomeGlandeur;                     // deverouille case de l ancienne position puis se met a la nouvelle valeur


    public ManagerJeu(){}

    public ManagerJeu(ArrayList<Joueur> j, GraphMap t, Point p){
        joueurs = j;
        melangerOrdreJoueur();
        terrain = t;
        terrain.initMap();
        positionBinomeGlandeur = p;
        tour = 0;
        lancerDesDes();
    }

    public void melangerOrdreJoueur(){
        Collections.shuffle(joueurs);
        Collections.shuffle(joueurs);
    }

    public void melangerCarteDeveloppement(){
        Collections.shuffle(pilesDeveloppement);
        Collections.shuffle(pilesDeveloppement);
    }

    public void finDeTour(){
        tour += 1;
        // vlider carte dev en main
        terrain.majCSS();
    }

    public void lancerDesDes(){
        ArrayList<Integer> vD = new ArrayList<Integer>();
        vD.add((int) (Math.random()*6) + 1);
        vD.add((int) (Math.random()*6) + 1);
        valeurDes = vD;
    }


    public void productionRessource(int valeurDes){                 // ne peut le faire sans fonction de valentin
        //getVoisinCase(); // classe de terrain

        // avec valeur des, recup toutes les cases ayant cette valeur

        ArrayList<CaseInterne> caseProd = new ArrayList<CaseInterne>();
        ArrayList<UV1> noeudOccuper = new ArrayList<UV1>();

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
            noeudOccuper = (UV1) (terrain.getVoisinsCase(caseProd.get(i)));
            for (int j = 0 ; j < noeudOccuper.size() ; j++){
                // pour chaque noeud adjacent occuper, gain ressource du type de la case <-AjoutRessource
                if (noeudOccuper insteanceof UV1)
                    noeudOccuper.getJ(ajoutRessource( ,1));
                else
                    noeudOccuper.getJ(ajoutRessource( ,2));
            }
        }

        // recupere les joueurs ayant une uv sur la / les cases produisant des ressources
        for (int j = 0 ; j < caseProd.size() ; j++){
            joueurRecolt = chercheJoueur(caseProd.get(j));
            // regarde le type d'uv qu a le joueur sur la case
            for (int k = 0; k < joueurRecolt.size(); k++){
                // test UV1old
                int d;
                for (d = 0; d < ((joueurs.get(k)).getUV1()).size(); d++){
                    if ( (((joueurs.get(k)).getUV1()).get(d)).getPoint() == (caseProd.get(j)).getPointCase() )
                        ;
                }

                // test UV2old

            }
            // engendre les gains
        }

    }

    public void calculerScore(){                                     // besoin accesseur coord UV : "getUV1()" et "getUV2()"
        ArrayList<Integer> joueurCC = new ArrayList<Integer>();
        ArrayList<Integer> joueurAncien = new ArrayList<Integer>();
        // calcule en fonction des UVs
        for(int i=0; i<joueurs.size(); i++){
            (joueurs.get(i)).setScore(((joueurs.get(i)).getUV1()) + ((joueurs.get(i)).getUV2())*2);
            if ( ((joueurs.get(i)).getCC()) > 4){
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
                    if (val < (joueurs.get(joueurCC.get(i))).getCC() ){
                        val = (joueurs.get(joueurCC.get(i))).getCC();
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
            for (int j = 0; j < ((joueurs.get(i)).getMainDeveloppement()).size(); j++) {
                if ((((joueurs.get(i)).getMainDeveloppement()).get(j)).getTypeDeveloppement() == TypeDeveloppement.POINTVICTOIRE){
                    (joueurs.get(i)).setScore((joueurs.get(i)).getScore() + 1);
                }
            }
        }
        return 0;
    }

    public void nouvellePartie(){
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

        pilesRessources.add(new Pile(new CarteRessource(TypeRessource.BIERE), 19));
        pilesRessources.add(new Pile(new CarteRessource(TypeRessource.CAFE), 19));
        pilesRessources.add(new Pile(new CarteRessource(TypeRessource.COURS), 19));
        pilesRessources.add(new Pile(new CarteRessource(TypeRessource.SOMMEIL), 19));
        pilesRessources.add(new Pile(new CarteRessource(TypeRessource.NOURRITURE), 19));
    }

    /* A VIRER CAR PENSE POSER PB POUR AFFICHAGE GRAPHIQUE */
    public void phaseFondation(){
        for (int i=0; i<joueurs.size();i++){
            // pose uv
            // pose cc
            tour++;
        }
        for (int i=joueurs.size(); i>0;i--){
            // pose uv
            // pose cc
            tour++;
        }
    }
}
