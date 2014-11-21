package fenetreGraphique;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class FenetreDefaut extends JFrame {
    private String nomFenetre;
    private int hauteur = 800;
    private int largeur = 500;

    public FenetreDefaut(String _nom, int _h, int _l) {
        nomFenetre = _nom;
        hauteur = _h;
        largeur = _l;

        // Nomme la fenetre
        setTitle(nomFenetre);
    }

    public void affichage() {
        // initialisa la taille de la fenetre
        setSize(hauteur,largeur);
        // positionne la fenetre au centre
        setLocationRelativeTo(null);
        // termine le processus lorsqu'on clique sur la croix rouge
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // empeche le redimmensionnement de la fenetre
        setResizable(false);  // par la suite faudra permettre ce redimensionnement
        // la rend visible
        setVisible(true);
    }
}
