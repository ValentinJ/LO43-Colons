package fenetreGraphique;

import colonsUTBM.GraphMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class Plateau extends JPanel {
    protected GraphMap graph;

    // initialisation du plateau de jeu
    public Plateau(GraphMap g){
        setBackground(Color.cyan);
        graph= g;

        setLayout(new BorderLayout());

        add(graph.getView(),BorderLayout.CENTER);
        //add(new JLabel("ici devrait etre la map avec le res des dés"));
    }

    public void MiseAJour(){
        graph.MAJCSS();
        graph.chargerCSS();

    }

    // possible interraction

}
