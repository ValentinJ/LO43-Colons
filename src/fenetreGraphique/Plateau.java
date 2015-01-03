package fenetreGraphique;

import colonsUTBM.GraphMap;
import colonsUTBM.ManagerJeu;
import org.graphstream.ui.swingViewer.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class Plateau extends JPanel {
    public FenetrePrincipale frame;
    public ManagerJeu manJeu;
    public GraphMap graph;

    // initialisation du plateau de jeu
    public Plateau(View v, ManagerJeu _manJeu, FenetrePrincipale _frame){
        //graph= g;
        manJeu = _manJeu;
        frame = _frame;
        graph = manJeu.getTerrain();
        setLayout(new BorderLayout());
        //graph.chargerCSS();

        add(v,BorderLayout.CENTER);
        //graph.majCSS();

        //add(new JLabel("ici devrait etre la map avec le res des dés"));
    }

    public void MiseAJour(){
        graph.chargerCSS();
        graph.majCSS();
    }

    // possible interraction

}
