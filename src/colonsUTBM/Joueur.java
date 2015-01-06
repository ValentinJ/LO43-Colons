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
    protected List<Arete> CC;

    protected Hashtable<TypeRessource,Pile> mainRessource;
    protected List<CarteDeveloppement> mainDeveloppement;

    // Méthodes boolean pour construction UV1, Uv2, Controle continu, Achat Carte developpement
    /**
     * Pour les construction uv1, uv2, Controle continue -> verifier ressource et nb de pions !=0
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
        CC = new ArrayList<Arete>();
        mainDeveloppement = new ArrayList<CarteDeveloppement>();

        score = 0;
        nbCc =15;
        nbUv1 =5;
        nbUv2 =4;
    }

    public boolean verifierAchatCarteDev(){
        if(mainRessource.get(TypeRessource.COURS).getNombre()>=1
                && mainRessource.get(TypeRessource.CAFE).getNombre()>=1
                && mainRessource.get(TypeRessource.SOMMEIL).getNombre()>=1)
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

    public void achatCarteDev(ArrayList<CarteDeveloppement> cd, Hashtable<TypeRessource, Pile> h){

        //todo ajout la carte au joueur
        if(verifierAchatCarteDev()){
            if(cd.size()!=0) {

                getMainRessource().get(TypeRessource.COURS).retirer();
                h.get(TypeRessource.COURS).ajouter();
                getMainRessource().get(TypeRessource.CAFE).retirer();
                h.get(TypeRessource.CAFE).ajouter();
                getMainRessource().get(TypeRessource.SOMMEIL).retirer();
                h.get(TypeRessource.SOMMEIL).ajouter();

                mainDeveloppement.add(cd.get(0));
                cd.remove(0);
            }
            else
                System.out.println("Il n'y a plus de cartes disponnibles !");
        }
        /**
         * verifierAchatCarteDev
         * Si VRAI alors retirer ressources
         * Ajouter carte au joueur
         */
    }

    public void validerCartesEnAttente(){
        for(CarteDeveloppement c : mainDeveloppement){
            if(!c.isAttenteValide())
                c.attenteValide=true;
        }
    }

    public void construireUV1(GraphMap g, Hashtable<TypeRessource,Pile> h){
        if(verifierAchatUV1()) {
            uvs.add(g.ClickConstructionUV1(this));
            g.majCSS();
            mainRessource.get(TypeRessource.COURS).retirer();
            h.get(TypeRessource.COURS).ajouter();
            mainRessource.get(TypeRessource.BIERE).retirer();
            h.get(TypeRessource.BIERE).ajouter();
            mainRessource.get(TypeRessource.CAFE).retirer();
            h.get(TypeRessource.CAFE).ajouter();
            mainRessource.get(TypeRessource.NOURRITURE).retirer();
            h.get(TypeRessource.NOURRITURE).ajouter();
            nbUv1--;
        }
    }

    public int nombreCarteRessource(){
        int i=0;
        for(TypeRessource p : mainRessource.keySet())
            i+=mainRessource.get(p).getNombre();
        return i;
    }

    public void eneleverMoitiecarte(Hashtable<TypeRessource, Pile> h){
        Random r = new Random();
        int valeur;
        int nbcarteajeter = 0;
        int cmptr=0;
        int nbrCarteRessourcesDifferentes;

        if(nombreCarteRessource() > 7){
            System.out.println("Le joueur "+this.getNom()+" a plus de 7 cartes !");
            nbcarteajeter= (int)Math.floor((double)(nombreCarteRessource()/2));
            System.out.println("Nombre de cartes à jeter : "+nbcarteajeter);

            for(int i = 0 ; i<nbcarteajeter ; i++){
                System.out.println("Carte "+i);
                nbrCarteRessourcesDifferentes=0;
                for(Pile p : mainRessource.values()){
                    if(p.getNombre()!=0){
                        nbrCarteRessourcesDifferentes++;
                    }
                }
                valeur = 0 + r.nextInt(4);

                cmptr=0;
                for(TypeRessource p : mainRessource.keySet()) {
                    if(cmptr==valeur) {
                        if(mainRessource.get(p).getNombre()!=0) {
                            System.out.println("On retire une carte de type " + p.toString());
                            mainRessource.get(p).retirer();
                            h.get(p).ajouter();
                        }
                        else{
                            if(mainRessource.get(TypeRessource.BIERE).getNombre()!=0) {
                                mainRessource.get(TypeRessource.BIERE).retirer();
                                h.get(TypeRessource.BIERE).ajouter();
                            }
                            else if(mainRessource.get(TypeRessource.SOMMEIL).getNombre()!=0) {
                                mainRessource.get(TypeRessource.SOMMEIL).retirer();
                                h.get(TypeRessource.SOMMEIL).ajouter();
                            }
                            else if(mainRessource.get(TypeRessource.CAFE).getNombre()!=0) {
                                mainRessource.get(TypeRessource.CAFE).retirer();
                                h.get(TypeRessource.CAFE).ajouter();
                            }
                            else if(mainRessource.get(TypeRessource.COURS).getNombre()!=0) {
                                mainRessource.get(TypeRessource.COURS).retirer();
                                h.get(TypeRessource.COURS).ajouter();
                            }
                            else {
                                mainRessource.get(TypeRessource.NOURRITURE).retirer();
                                h.get(TypeRessource.NOURRITURE).ajouter();
                            }
                        }
                    }
                    cmptr++;
                }
            }
        }
    }

    public void transformerUV2(GraphMap g, Hashtable<TypeRessource,Pile> h){
        if(verifierAchatUV2()) {
            UV2 uvtmp= new UV2();
            uvtmp = g.ClickConstructionUV2(this);
            UV1 uv1tmp = new UV1();
            for(UV1 uv : uvs){
                if(uv.getId().equals(uvtmp.getId())){
                    uv1tmp=uv;
                }
            }
            uvs.remove(uv1tmp);
            uvs.add(uvtmp);
            /*
            for(NoeudConstructible n : uvs){
                if(n.getId().equals())
            }
            */
            mainRessource.get(TypeRessource.COURS).retirer(2);
            h.get(TypeRessource.COURS).ajouter(2);
            mainRessource.get(TypeRessource.SOMMEIL).retirer(3);
            h.get(TypeRessource.SOMMEIL).ajouter(3);
            nbUv1++;
            nbUv2--;
            g.majCSS();
        }
    }

    public void construireCC(GraphMap g, Hashtable<TypeRessource, Pile> h ){
        if(verifierAchatControleContinu()) {
            CC.add(g.ClickConstructionControleContinus(this));
            getMainRessource().get(TypeRessource.BIERE).retirer();
            h.get(TypeRessource.BIERE).ajouter();
            getMainRessource().get(TypeRessource.NOURRITURE).retirer();
            h.get(TypeRessource.NOURRITURE).ajouter();
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
        TypeRessource ajout = null;
        TypeRessource echange = VerifierEchangeBanque();
        if (echange!=null) {
            mainRessource.get(echange).retirer(4);
            Random r = new Random();
            int k = r.nextInt(4);
            switch (k) {
                case 0:
                    ajout = TypeRessource.BIERE;
                    break;
                case 1:
                    ajout = TypeRessource.SOMMEIL;
                    break;
                case 2:
                    ajout = TypeRessource.CAFE;
                    break;
                case 3:
                    ajout = TypeRessource.COURS;
                    break;
                case 4:
                    ajout = TypeRessource.NOURRITURE;
                    break;
            }
            //todo à voir car j'ai commenté parceque j'ai changé la fonction (VAL)
            //ajoutRessourceProd(ajout, 1);
        }
    }

    public boolean valCC(){
        int constrCC=0;
        for (int i = 0; i<mainDeveloppement.size() ; i++) {
            if ((mainDeveloppement.get(i)).getTypeDeveloppement() == TypeDeveloppement.CCC && mainDeveloppement.get(i).isDansLaMain() &&
                    mainDeveloppement.get(i).isAttenteValide()) {
                constrCC = constrCC + 1;
            }
        }
        if (constrCC >=1  && nbCc >=2 )
            return true;
        return false;
    }

    public void joueurCarteCC(GraphMap g){
        int i=0;
        if(valCC()){
            CC.add(g.ClickConstructionControleContinus(this));
            CC.add(g.ClickConstructionControleContinus(this));
            nbCc=nbCc-2;
            for(CarteDeveloppement c : mainDeveloppement){
                if(c.getTypeDeveloppement() == TypeDeveloppement.CCC && c.isDansLaMain() && i==0) {
                    c.dansLaMain = false;
                    i++;
                }
            }
        }
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

    public int getCCsize(){return CC.size();}

    public ArrayList<Arete> getCC(){ return (ArrayList<Arete>) CC;}

    public int[] getAncien() {
        int nb[] = {0,0,0};
        for (int i = 0; i<mainDeveloppement.size() ; i++){
            if ( (mainDeveloppement.get(i)).getTypeDeveloppement() == TypeDeveloppement.ANCIEN ){
                if(mainDeveloppement.get(i).isDansLaMain())
                    nb[0] = nb[0] + 1;
                else
                    nb[2] +=1;
                if(!mainDeveloppement.get(i).isAttenteValide())
                    nb[1]+=1;
            }
        }
        return nb;
    }

    /**
     * indice 0 : nbr total cartes du type CCC dans la main
     * indice 1 : nbr total cartes du type CCC dans la main et non valide
     * indice 2 : nbr total cartes du type CCC jouées
     * @return
     */
    public int[] getCCC() {
        int nb[] = {0,0,0};
        for (int i = 0; i<mainDeveloppement.size() ; i++){
            if ( (mainDeveloppement.get(i)).getTypeDeveloppement() == TypeDeveloppement.CCC ){
                if(mainDeveloppement.get(i).isDansLaMain())
                    nb[0] = nb[0] + 1;
                else
                    nb[2] +=1;
                if(!mainDeveloppement.get(i).isAttenteValide())
                    nb[1]+=1;
            }
        }
        return nb;
    }

    public int[] getDecouverte() {
        int nb[] = {0,0,0};
        for (int i = 0; i<mainDeveloppement.size() ; i++){
            if ( (mainDeveloppement.get(i)).getTypeDeveloppement() == TypeDeveloppement.DECOUVERTE ){
                if(mainDeveloppement.get(i).isDansLaMain())
                    nb[0] = nb[0] + 1;
                else
                    nb[2] +=1;
                if(!mainDeveloppement.get(i).isAttenteValide())
                    nb[1]+=1;
            }
        }
        return nb;
    }

    public int[] getMonopole() {
        int nb[] = {0,0,0};
        for (int i = 0; i<mainDeveloppement.size() ; i++){
            if ( (mainDeveloppement.get(i)).getTypeDeveloppement() == TypeDeveloppement.MONOPOLE ){
                if(mainDeveloppement.get(i).isDansLaMain())
                    nb[0] = nb[0] + 1;
                else
                    nb[2] +=1;
                if(!mainDeveloppement.get(i).isAttenteValide())
                    nb[1]+=1;
            }
        }
        return nb;
    }

    public int[] getPointVictoire() {
        int nb[] = {0,0,0};
        for (int i = 0; i<mainDeveloppement.size() ; i++){
            if ( (mainDeveloppement.get(i)).getTypeDeveloppement() == TypeDeveloppement.POINTVICTOIRE ){
                if(mainDeveloppement.get(i).isDansLaMain())
                    nb[0] = nb[0] + 1;
                else
                    nb[2] +=1;
                if(!mainDeveloppement.get(i).isAttenteValide())
                    nb[1]+=1;
            }
        }
        return nb;
    }


    public ArrayList<CarteDeveloppement> getMainDeveloppement(){return (ArrayList) mainDeveloppement;}

    public void ajoutRessourceProd(TypeRessource rAAjouter, int nombreRessourceAAjouter, Hashtable<TypeRessource, Pile> h, TypeRessource rAEnlever, int nombreRessourceAEnelever){
        mainRessource.get(rAAjouter).ajouter(h.get(rAEnlever).retirer(nombreRessourceAEnelever));

    }

    public void ajoutRessource(TypeRessource rAAjouter, int nombreRessourceAAjouter, Hashtable<TypeRessource,Pile> h, TypeRessource rAEnlever, int nombreRessourceAEnelever ){
        mainRessource.get(rAAjouter).ajouter(nombreRessourceAAjouter);
        h.get(rAEnlever).retirer(nombreRessourceAEnelever);
    }

    public void retirerRessource(TypeRessource rARetirer, int nombreRessouceARetirer, Hashtable<TypeRessource,Pile> h, TypeRessource rAAjouter, int nombreRessourceAAjouter){
        mainRessource.get(rARetirer).retirer(nombreRessouceARetirer);
        h.get(rAAjouter).retirer(nombreRessourceAAjouter);
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

    public void calculerScore(ManagerJeu manJeu){
        int pointUV = (this.getNbUvs()).get(0) + ((this.getNbUvs()).get(1)*2);
        int pointPTSV = this.getPointVictoire()[0];
        boolean boolAncien = false;
        boolean boolCC = false;
        int carton = 0;

        if (this.getAncien()[0] > 2){
            boolAncien = true;
            for (int i = 0 ; i < manJeu.getJoueurs().size() ; i++) {
                if (! manJeu.getJoueurs().get(i).equals(this)){
                    if (manJeu.getJoueurs().get(i).getAncien()[0] >= this.getAncien()[0]){
                        boolAncien = false;
                    }
                }
            }
        }

        if (this.getCCsize() > 4){
            boolCC = true;
            for (int i = 0 ; i < manJeu.getJoueurs().size() ; i++) {
                if (! manJeu.getJoueurs().get(i).equals(this)){
                    if (manJeu.getJoueurs().get(i).getCCsize() >= this.getCCsize()){
                        boolCC = false;
                    }
                }
            }
        }

        if (boolAncien == true){
            carton = carton +2;
        }
        if (boolCC == true) {
            carton = carton + 2;
        }
        this.setScore(pointUV + pointPTSV + carton);
    }
}
