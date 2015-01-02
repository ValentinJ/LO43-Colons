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


    protected ArrayList<UV1> uvs;
    protected ArrayList<ControleContinueold> CC;

    protected ArrayList<Pile> mainRessource;
    protected ArrayList<CarteDeveloppement> mainDeveloppement;

    public Joueur(){}

    public Joueur(String _nom, TypeCouleur _couleur){
        nom = _nom;
        couleur = _couleur;

        mainRessource = new ArrayList<Pile>();
        mainRessource.add(new Pile(new CarteRessource(TypeRessource.BIERE)));
        mainRessource.add(new Pile(new CarteRessource(TypeRessource.SOMMEIL)));
        mainRessource.add(new Pile(new CarteRessource(TypeRessource.CAFE)));
        mainRessource.add(new Pile(new CarteRessource(TypeRessource.COURS)));
        mainRessource.add(new Pile(new CarteRessource(TypeRessource.NOURRITURE)));

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

    public ArrayList<Pile> getMainRessource(){ return mainRessource;}
    public Pile getMainRessource(int indicePile){ return mainRessource.get(indicePile);}

    public void MAJScore(){
        for(UV1 uv : uvs){
            score+=uv.ptsVictoire;
        }
    }


    public ArrayList<UV1> getUvs() {
        return uvs;
    }

    public void setUvs(ArrayList<UV1> uvs) {
        this.uvs = uvs;
    }
}
