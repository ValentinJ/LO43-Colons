package fenetreGraphique;

import colonsUTBM.Couleur;

import javax.swing.*;
import java.awt.Color;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class BlocTourJoueur extends JPanel{

    public String nom;
    public String c;

    public BlocTourJoueur(String _n, String _c){
        nom=_n;
        c = _c;
        setBackground(Color.white);
    }

    // lorsque c est le tour du joueur, sa case se color
    public void activeCouleur(){
        if (c.equals("VERT")) {
            setBackground(Color.green);
        }
        if (c.equals("BLEU")) {
            setBackground(Color.blue);
        }
        if (c.equals("ROUGE")) {
            setBackground(Color.red);
        }
        if (c.equals("JAUNE")) {
            setBackground(Color.yellow);
        }
    }

    // enleve la couleur de la case
    public void desactiveCouleur() {
        setBackground(Color.white);
    }

    // peut etre en aura t on besoin pour placer correctement dans le champs si redimmensionnement de la fenetre
    public void setDimension(){

    }
}
