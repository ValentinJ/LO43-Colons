package colonsUTBM;

import java.util.ArrayList;

/**
 * Created by Guillaume on 03/12/2014.
 */
public class Joueur {
    protected String nom;
    protected TypeCouleur couleur;
    protected int score;

    protected ArrayList<UV1old> UV1old;
    protected ArrayList<UV2old> UV2old;
    protected ArrayList<ControleContinueold> CC;

    protected ArrayList<CarteRessource> mainRessource;
    protected ArrayList<CarteDeveloppement> mainDeveloppement;

    public Joueur(){
    }

    public Joueur(String _nom, TypeCouleur _couleur){
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

    //public void echangeAvecPort(TypePort t){
    //}

    public void echangeAvecBanque(){
    }

    public void jouerCarteDeveloppement(){
    }

    public void deplacerBinomeGlandeur(){
    }

    public void validationCarteDevEnMain(){
    }

    public String getNom(){
        return nom;
    }

    public String getCouleur(){
        return couleur.toString();
    }
}
