package fenetreGraphique;

import colons.Couleurs;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class BlocTourJoueur {

    public String nom;
    Enum<Couleurs> couleur;

    public BlocTourJoueur(String _n, Enum<Couleurs> _c){
        nom=_n;
        couleur = _c;
        // creer un bloc graphique

    }

    // lorsque c est le tour du joueur, sa case se color
    public void activeCouleur(){

    }

    // enleve la couleur de la case
    public void desactiveCouleur() {

    }

    // peut etre en aura t on besoin pour placer correctement dans le champs si redimmensionnement de la fenetre
    public void setDimension(){

    }
}
