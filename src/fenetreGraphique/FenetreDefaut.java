package fenetreGraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class FenetreDefaut extends JFrame {
    private String nomFenetre;
    private int hauteur = 500;
    private int largeur = 800;

    public FenetreDefaut(String _nom, int _h, int _l) {
        nomFenetre = _nom;
        hauteur = _h;
        largeur = _l;

        // Nomme la fenetre
        setTitle(nomFenetre);
    }

    public void affichage() {
        // initialisa la taille de la fenetre
        setSize(largeur,hauteur);
        // positionne la fenetre au centre
        setLocationRelativeTo(null);
        // termine le processus lorsqu'on clique sur la croix rouge
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // empeche le redimmensionnement de la fenetre
        setMinimumSize(new Dimension(largeur, hauteur));
        setResizable(true);  // par la suite faudra permettre ce redimensionnement
        // la rend visible
        setVisible(true);
    }
}
