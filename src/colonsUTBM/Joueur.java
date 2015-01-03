package colonsUTBM;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

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
    protected List<ControleContinus> CC;

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
        CC = new ArrayList<ControleContinus>();
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

        //todo ajout la carte au joueur
        if(verifierAchatCarteDev()){
            getMainRessource().get(TypeRessource.COURS).retirer();
            getMainRessource().get(TypeRessource.CAFE).retirer();
            getMainRessource().get(TypeRessource.SOMMEIL).retirer();
        }
        /**
         * verifierAchatCarteDev
         * Si VRAI alors retirer ressources
         * Ajouter carte au joueur
         */
    }

    public void construireUV1(GraphMap g){
        if(verifierAchatUV1()) {
            uvs.add(g.ClickConstructionUV1(this));
            mainRessource.get(TypeRessource.COURS).retirer();
            mainRessource.get(TypeRessource.BIERE).retirer();
            mainRessource.get(TypeRessource.CAFE).retirer();;
            mainRessource.get(TypeRessource.NOURRITURE).retirer();
            nbUv1--;

        }
    }

    public int nombreCarteRessource(){
        int i=0;
        for(TypeRessource p : mainRessource.keySet())
            i+=mainRessource.get(p).getNombre();
        return i;
    }

    public void eneleverMoitiecarte(){
        Random r = new Random();
        int valeur;
        int nbcarteajeter = 0;
        int cmptr=0;

        if(nombreCarteRessource() > 7){
            nbcarteajeter= (int)Math.floor((double)(nombreCarteRessource()/2));

            for(int i = 0 ; i<nbcarteajeter ; i++){
                valeur = 0 + r.nextInt(nombreCarteRessource());

                for(TypeRessource p : mainRessource.keySet()) {
                    i += mainRessource.get(p).getNombre();
                }

                i++;
            }
        }
    }

    public void transformerUV2(GraphMap g){
        if(verifierAchatUV2()) {
            g.ClickConstructionUV2(this);
            mainRessource.get(TypeRessource.COURS).retirer(2);
            mainRessource.get(TypeRessource.SOMMEIL).retirer(3);
            nbUv1++;
            nbUv2--;
        }
    }

    public void construireCC(GraphMap g){
        if(verifierAchatControleContinu()) {
            CC.add(g.ClickConstructionControleContinus(this));
            getMainRessource().get(TypeRessource.BIERE).retirer();
            getMainRessource().get(TypeRessource.NOURRITURE).retirer();
            nbCc--;
        }
    }

    public void echangeAvecJoueur(Joueur j){
    }

    //public void echangeAvecPort(TypePort t){
    //}

    public TypeRessource VerifierEchangeBanque(){
        TypeRessource echange=null;
        if (mainRessource.get(TypeRessource.BIERE).getNombre()>=4)
            echange=TypeRessource.BIERE;
        if (mainRessource.get(TypeRessource.SOMMEIL).getNombre()>=4)
            echange=TypeRessource.SOMMEIL;
        if (mainRessource.get(TypeRessource.COURS).getNombre()>=4)
            echange=TypeRessource.COURS;
        if (mainRessource.get(TypeRessource.CAFE).getNombre()>=4)
            echange=TypeRessource.CAFE;
        if (mainRessource.get(TypeRessource.NOURRITURE).getNombre()>=4)
            echange=TypeRessource.NOURRITURE;
        return echange;
    }

    public void echangeAvecBanque(){
        //mainRessource.get(TypeRessource.echange).retirer(4);
    }


    public void jouerCarteDeveloppement(CarteDeveloppement c){
    }

    public void deplacerBinomeGlandeur(GraphMap g){
        g.deplacerBinomeGlandeur();
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
    public Pile getMainRessource(TypeRessource r){ return mainRessource.get(r);}

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

    public void setScore(int val){score = val;}

    public int getCC(){return CC.size();}

    public int getAncien() {
        int nb_ancien = 0;
        for (int i = 0; i<mainDeveloppement.size() ; i++){
            if ( (mainDeveloppement.get(i)).getTypeDeveloppement() == TypeDeveloppement.ANCIEN ){
                nb_ancien = nb_ancien + 1;
            }
        }
        return nb_ancien;
    }


    public ArrayList<CarteDeveloppement> getMainDeveloppement(){return (ArrayList) mainDeveloppement;}

    public void ajoutRessource(TypeRessource r, int nombreRessourceAAjouter){
        mainRessource.get(r).ajouter(nombreRessourceAAjouter);
    }

    public ArrayList<Integer> getNbUvs(){
        ArrayList<Integer> NbUVS = new ArrayList<Integer>();

        int _UV1=0;
        int _UV2=0;
        for (int i=0; i<uvs.size(); i++){
            if (uvs.get(i) instanceof UV2){
                _UV2 += 1;
            }
        }
        _UV1 = uvs.size() - _UV2;
        NbUVS.add(_UV1);
        NbUVS.add(_UV2);

        return NbUVS;
    }
}
