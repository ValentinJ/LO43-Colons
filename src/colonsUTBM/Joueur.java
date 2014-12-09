package colonsUTBM;

import java.util.ArrayList;

/**
 * Created by Guillaume on 03/12/2014.
 */
public class Joueur {
    protected String nom;
    protected Couleur couleur;
    protected int score;

    protected ArrayList<UV1> UV1;
    protected ArrayList<colonsUTBM.UV2> UV2;
    protected ArrayList<ControleContinue> CC;

    protected ArrayList<CarteRessource> mainRessource;
    protected ArrayList<CarteDeveloppement> mainDeveloppement;

    public Joueur(){
    }

    public Joueur(String _nom, Couleur _couleur){
        nom = _nom;
        couleur = _couleur;
        score = 0;
    }

    public void acheterCarte(){
    }

    public void construireUV(){
    }

    public void transformerUV2(){
    }

    public void construireCC(){
    }

    public void echangeAvecJoueur(Joueur j){
    }

    public void echangeAvecPort(/*TypePort t*/){
    }

    public void echangeAvecBanque(){
    }

    public void jouerCarteDeveloppement(){
    }

    public void deplacerBinomeGlandeur(){
    }

    public void validationCarteDevEnMain(){
    }
}
