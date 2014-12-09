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
    protected Map terrain;
    protected Point positionBinomeGlandeur;                     // deverouille case de l ancienne position puis se met a la nouvelle valeur

    public ManagerJeu(){}

    public ManagerJeu(ArrayList<Joueur> j, Map t, Point p){
        joueurs = j;
        terrain = t;
        positionBinomeGlandeur = p;
        tour = 0;
        lancerDesDes();
    }

    public void melangerCarteDeveloppement(){
        Collections.shuffle(pilesDeveloppement);
        Collections.shuffle(pilesDeveloppement);
    }

    public void finDeTour(){
        tour += 1;
        terrain.affichage();
    }

    public void lancerDesDes(){
        ArrayList<Integer> vD = new ArrayList<Integer>();

        vD.add((int) (Math.random() * 6 ) + 1);
        vD.add((int) (Math.random() * 6 ) + 1);

        valeurDes = vD;
    }

    public void productionRessource(int valeurDes){
        ArrayList<CaseRessource> caseProd = new ArrayList<CaseRessource>();
        ArrayList<Joueur> joueurRecolt = new ArrayList<Joueur>();

        for (int i = 0 ; i < (terrain.getListCase()).size() ; i++){
            if ( ((terrain.getListCase()).get(i)).getValeurNumerique() == valeurDes ){
                caseProd.add((terrain.getListCase()).get(i));
            }
        }

     
        for (int j = 0 ; j < caseProd.size() ; j++){
            joueurRecolt.add(chercheJoueur(caseProd.get(j)));
        }
    }

    public ArrayList<Joueur> chercheJoueur(Case c){                  // besoin accesseur coord UV : "getPoint()"
        ArrayList<Integer> jUV;

        /*for (int i =0; i < joueurs.size(); i++){
            int j;

            for (j = 0; j < ((joueurs.get(i)).UV1).size(); j++){
                if ( (((joueurs.get(i)).UV1).get(j)).getPoint() == c.getPointCase() )
                    jUV.add(i);
            }

            for (j = 0; j < ((joueurs.get(i)).UV2).size(); j++){
                if ( ( (((joueurs.get(i)).UV2).get(j)).getPoint() == c.getPointCase() ) && (jUV.contains(i) == false) ) // fait attention au doublons
                    jUV.add(i); // faire attention au doublons
            }
        }*/
    }

    public int calculerScore(){                                      // besoin accesseur coord UV : "getUV1()" et "getUV2()"
        ArrayList<Integer> joueurCC;

        // calcule en fonction des UVs
        /*for(int i; i<joueurs.size(); i++){
            (joueurs.get(i)).score = ((joueurs.get(i)).getUV1()).size() + ((joueurs.get(i)).getUV2()).size() * 2 ;
            if ( ((joueurs.get(i)).CC).size() > 5){
                joueurCC.add(i);
            }
            if ( ((joueurs.get(i)).CC).size() > 5){
                joueurCC.add(i);
            }
        }
        // ajout des bonus de CC
        if (joueurCC.size() > 0){
            if (joueurCC.size() == 1){
                (joueurs.get(joueurCC.get(0))).score += 2;
            }
            else{
                if
            }
        }*/

    }

    public int calculerScoreFinal(){
        for(int i=0 ; i < joueurs.size(); i++){
            for (int j = 0; j < ((joueurs.get(i)).mainDeveloppement).size(); j++){
                /*if (((joueurs.get(i)).mainDeveloppement).typeDeveloppement == "POINTVICTOIRE"){
                    (joueurs.get(i)).score += 1;
                }*/
            }
        }
    }

    /*public void nouvellePartie(){                                                        // manque nombre carte
                                                                                         // besoin constructeurPile

        terrain.initialisation();

        ArrayList<CarteDeveloppement> pilesD = new ArrayList<CarteDeveloppement>();
        pilesD.add();
        pilesD.add();
        pilesD.add();
        pilesD.add();
        pilesD.add();
        pilesDeveloppement = pilesD;
        melangerCarteDeveloppement();

        Pile biere = new Pile(new CarteRessource(), 10);
        pilesRessources.add(biere);
        Pile cafe = new Pile(new CarteRessource(), 10);
        pilesRessources.add(cafe);
        Pile cours = new Pile(new CarteRessource(), 10);
        pilesRessources.add(cours);
        Pile sommeil = new Pile(new CarteRessource(), 10);
        pilesRessources.add(sommeil);
        Pile nourriture = new Pile(new CarteRessource(), 10);
        pilesRessources.add(nourriture);

        while (tour){
            // autoriser uniquement joueur[tour] a jouer
            // en faire des thread ?
        }
    }*/

    public int phaseFondation(){
        // aucune idée
    }


}
