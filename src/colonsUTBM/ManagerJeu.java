package colonsUTBM;

import java.util.ArrayList;

/**
 * Created by Guillaume on 03/12/2014.
 */
public class ManagerJeu {
    protected ArrayList<Joueur> joueurs;
    protected ArrayList<Pile> pilesRessources;
    protected ArrayList<CarteDeveloppement> pilesDeveloppement;

    protected int valeurDes;
    protected int tour;
    protected Map terrain;
    protected Point positionBinomeGlandeur;                     // deverouille case de l ancienne position puis se met a la nouvelle valeur

    public ManagerJeu(){
    }

    public void melangerCarteDeveloppement(){
    }

    public void finDeTour(){
    }

    public void lancerDesDes(){
    }

    public void productionRessource(int valeurDes){
    }

    public ArrayList<Joueur> chercheJoueur(Case c){
    }

    public int calculerScore(){
    }

    public int calculerScoreFinal(){
    }

    public void nouvellePartie(){
    }

    public int phaseFondation(){
    }


}
