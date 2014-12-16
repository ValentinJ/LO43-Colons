package fenetreGraphique;

import colonsUTBM.GraphMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class Plateau extends JPanel {
    public GraphMap graph;

    // initialisation du plateau de jeu
    public Plateau(GraphMap g){
        graph= g;

        setLayout(new BorderLayout());
        graph.chargerCSS();
        graph.MAJCSS();

        add(graph.getView(),BorderLayout.CENTER);
        //add(new JLabel("ici devrait etre la map avec le res des dés"));
    }

    public void MiseAJour(){
        graph.chargerCSS();
        graph.MAJCSS();
    }

    // possible interraction

}
