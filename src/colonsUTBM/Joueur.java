package colonsUTBM;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Guillaume on 03/12/2014.
 */
public class Joueur {
    protected String nom;
    protected TypeCouleur couleur;
    protected int score;
    protected int nbUv1;
    protected int nbUv2;
    protected int nbCc;

    protected List<UV1> uvs;
    protected List<ControleContinueold> CC;

    protected Hashtable<TypeRessource,Pile> mainRessource;
    protected List<CarteDeveloppement> mainDeveloppement;

    // Méthodes boolean pour construction UV1, Uv2, Controle continu, Achat Carte developpement
    /**
     * Pour les construction uv1, UV2, Controle continue -> verifier ressource et nb de pions !=0
     * Construction d'une carte de dev -> verifier ressource
     */

    // Méthodes construction avec params (GraphMap g)
    /**
     * vérifier avec la méthode vue plus haut
     * retirer ressources
     * retirer pions
     * Ajouter l'uv dans l'arraylist des uv du joueur (voir la méthode récupérer uv du joueur)
     * normalement rien d'autre à faire  À VÉRIFIER !!
     */

    //Méthode récupérer UV du joueur à partir du graph et les stocker dans arraylist du joueur

    // Méthode pour faire commerce (argument un joueur si commerce avec joueur ou voir pour les autres...)

    //Méthode savoir si joueur peut faire un type de commerce que ce soit commerce 3:1 , commerce banque, commerce 2:1 en fonction de la ressource (retourner un boolean)

    //Joueur carteCC et carteAncien (arg graphmap g) (deux méthodes différentes !! )
    /**
     * CarteCC
     * construire deux CC sans retirer ressource mais retirer pions
     *
     * Carte Ancien
     * deplacer binome glandeur
     * choisir joueur voisin au binome pour lui voler une carte au hasard (prendre méthode de grpahmap qui retourne arraylist des joueur voisins à un hexagone ici binome glandeur)
     */

    //Méthode Joueur carte Monopole (arg arraylist des joeuurs, Enum du type de la carte)
    /**
     * Pour chaque joueur j de l'arraylist
     * Verifier que ce n'est pas le propre joueur
     * retirer les carte de ce type de carte
     * ajouter au joueur courant
     */

    //Méthode Jouer carte decouverte
    /**
     * Retirer 2 carte du meme type à la banque et l'ajouter au joueur
     */

    //Méthode enleve moitié des carte
    /**
     * Si plus de 7 cartes enlever la moitié aléatoirement arrondi à l'inférieur (donc si 9 carte alors enlever 4 cartes)
     */

    //Méthode déplacer binome glandeur (arg Graphmap g)
    /**
     * lancer la méthode adéquate de graphmap et voilà
     */

    //Méthode récupérer nombre cartes

    /**
     * à partir de la arraylist pile du joueur (n'est pas implémenté, à remplacer à la place de arralylist carteRessource)
     * récupérer le nombre de carte, pour chaque pile recuperer nb dans la pile et faire la somme
     */



    public Joueur(){}

    public Joueur(String _nom, TypeCouleur _couleur){
        nom = _nom;
        couleur = _couleur;

        mainRessource = new Hashtable<TypeRessource,Pile>();
        mainRessource.put(TypeRessource.BIERE, new Pile(new CarteRessource(TypeRessource.BIERE)));
        mainRessource.put(TypeRessource.SOMMEIL, new Pile(new CarteRessource(TypeRessource.SOMMEIL)));
        mainRessource.put(TypeRessource.CAFE, new Pile(new CarteRessource(TypeRessource.CAFE)));
        mainRessource.put(TypeRessource.COURS, new Pile(new CarteRessource(TypeRessource.COURS)));
        mainRessource.put(TypeRessource.NOURRITURE, new Pile(new CarteRessource(TypeRessource.NOURRITURE)));

        uvs = new ArrayList<UV1>();
        CC = new ArrayList<ControleContinueold>();
        mainDeveloppement = new ArrayList<CarteDeveloppement>();

        score = 0;
        nbCc =15;
        nbUv1 =5;
        nbUv2 =4;
    }

    public boolean verifierAchatCarteDev(){
        if(mainRessource.get(TypeRessource.COURS).getNombre()>=1
                && mainRessource.get(TypeRessource.COURS).getNombre()>=1
                && mainRessource.get(TypeRessource.COURS).getNombre()>=1)
            return true;
        return false;
        /**
         * 1cours
         * 1 café
         * 1 sommeil
         * vérifier mainRessource
         * permettra d'activer le bouton ou non
          */

    }

    public boolean verifierAchatControleContinu(){
        if(nbCc>=1 && mainRessource.get(TypeRessource.BIERE).getNombre()>=1
                && mainRessource.get(TypeRessource.NOURRITURE).getNombre()>=1)
            return true;
        return false;
        /**
         * 1 biere
         * 1 nourriture
         * vérifier nbCc != 00 && vérifier mainRessource
         * permettra d'activer le bouton ou non
         */
    }

    public boolean verifierAchatUV1(){
        if(nbUv1>=1 && mainRessource.get(TypeRessource.BIERE).getNombre()>=1
                && mainRessource.get(TypeRessource.CAFE).getNombre()>=1
                && mainRessource.get(TypeRessource.COURS).getNombre()>=1
                && mainRessource.get(TypeRessource.NOURRITURE).getNombre()>=1)
            return true;
        return false;
        /**
         * 1 biere
         * 1 nourriture
         * 1 cafe
         * 1 cours
         * vérifier nbUv1!= 00 && vérifier mainRessource
         * permettra d'activer le bouton ou non
         */
    }

    public boolean verifierAchatUV2(){
        if(nbUv2>=1 && nbUv1<5 && mainRessource.get(TypeRessource.COURS).getNombre()>=2
                && mainRessource.get(TypeRessource.SOMMEIL).getNombre()>=3)
            return true;
        return false;
        /**
         * 2 cours
         * 3 sommeil
         * vérifier nbUv2!= 00 && vérifier mainRessource
         * permettra d'activer le bouton ou non
         */
    }

    public void achatCarteDev(ArrayList<CarteDeveloppement> cd){

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

    public void jouerCarteDeveloppement(CarteDeveloppement c){
    }

    public void deplacerBinomeGlandeur(Case c){
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

    public Hashtable<TypeRessource,Pile> getMainRessource(){ return mainRessource;}
    public Pile getMainRessource(int indicePile){ return mainRessource.get(indicePile);}

    public void MAJScore(){
        for(UV1 uv : uvs){
            score+=uv.ptsVictoire;
        }
    }


    public ArrayList<UV1> getUvs() {
        return (ArrayList<UV1>)uvs;
    }

    public void setUvs(ArrayList<UV1> uvs) {
        this.uvs = uvs;
    }

    public int getUV1(){return nbUv1;}

    public int getUV2(){return nbUv2;}
}
