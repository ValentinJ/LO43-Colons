package colonsUTBM;

import java.util.ArrayList;

/**
 * Created by Guillaume on 03/12/2014.
 */
public class Joueur {
    protected String nom;
    protected TypeCouleur couleur;
    protected int score;
    protected int nb_UV1;
    protected int nb_UV2;
    protected int nb_CC;

    protected ArrayList<UV1> uvs;
    protected ArrayList<ControleContinueold> CC;

    protected ArrayList<CarteRessource> mainRessource;
    protected ArrayList<CarteDeveloppement> mainDeveloppement;

    public Joueur(){
    }

    public Joueur(String _nom, TypeCouleur _couleur){
        nom = _nom;
        couleur = _couleur;
        score = 0;
        nb_CC=15;
        nb_UV1=5;
        nb_UV2=4;
    }

    public boolean verifierAchatCarteDev(){
        //todo verifierAchatCarteDev
        /**
         * vérifier mainRessource
         * permettra d'activer le bouton ou non
          */
        return true;
    }

    public boolean verifierAchatControleContinu(){
        //todo verifierAchatControleContinu
        /**
         * vérifier nb_CC != 00 && vérifier mainRessource
         * permettra d'activer le bouton ou non
         */
        return true;
    }

    public boolean verifierAchatUV1(){
        //todo verifierAchatUV1
        /**
         * vérifier nb_UV1!= 00 && vérifier mainRessource
         * permettra d'activer le bouton ou non
         */
        return true;
    }

    public boolean verifierAchatUV2(){
        //todo verifierAchatUV2
        /**
         * vérifier nb_UV2!= 00 && vérifier mainRessource
         * permettra d'activer le bouton ou non
         */
        return true;
    }

    public void achatCarteDev(){
        //todo acheterCarteDev
        /**
         * verifierAchatCarteDev
         * Si VRAI alors retirer ressources
         * Ajouter carte au joueur
         */
    }

    public void construireUV1(GraphMap g){
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

    public int getScore(){
        return score;
    }
    public void MAJScore(){
        for(UV1 uv : uvs){
            score+=uv.ptsVictoire;
        }
    }
}
