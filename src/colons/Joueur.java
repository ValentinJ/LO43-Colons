package colons;

import scala.collection.Iterator;

/**
 * Created by val on 30/10/14.
 */
public class Joueur {
    /* protected Main main; // <- du coup vraiment utile d avoir une classe pour un arraylist ? */
    protected java.util.ArrayList<Carte> main;

    protected int score;
    protected java.util.ArrayList<Uv> ListUv;
    private java.util.ArrayList<ControleContinu> listCC;
    private java.util.ArrayList<CarteDeveloppement> listCD;
    public Enum<Couleurs> couleur;

    public String nomDuJoueur;                               // important pour la fenetre graphique
    public int valDes;                                       // important pour le trie Joueur 1 , Joueur 2, ...

    public Joueur(int indice) {
        couleur = new Enum<Couleurs>(1);
    }

    public int CalculerScore() {
        // maison + colonie + route + carte dev + carte speciale (grand chevalier ou route commercial)
        return score;
    }

    public void AjoutCarte(int indice_ressource){
        (this.main).add(new CarteRessource(indice_ressource));
    }

    public void EnleverCarte(int indice_ressource){
        (this.main).remove(new CarteRessource(indice_ressource));
    }


    /* se fait a partir de la classe jeu. Aucune interraction depuis classe Joueur*/
    /*public void JouerCarte(int indice_main) throws Exception_event_game{
        Iterator it = (Iterator) main.iterator();
        for (int i =0; i < indice_main; i++){
            if (it.hasNext()){ it.next(); }
            else return;
        };
        // envoyer l exception ici, mais je ne sais plus faire
        // je ne suis pas sure que seul comme ça, ça fonctionne
    }*/

    /* c est dans a classe jeu que l on verifira si l on peut creer l UV pour le joueur */
    public void AjoutUv(Uv uv_quelconque){
        ListUv.add(uv_quelconque);
    }

    public void AjoutCC(ControleContinu cc){
        listCC.add(cc);
    }

    public void AjoutCD(CarteDeveloppement cd){
        listCD.add(cd);
    }

    /* je ne sais plus a quelle groupe fait partie les carte Grand chevalier et commerce */
    /* donc je ne sais pas a qui l ont doit faire la fonction EnleverCD */
}
