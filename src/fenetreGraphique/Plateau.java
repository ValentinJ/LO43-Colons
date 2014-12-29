package fenetreGraphique;

import colonsUTBM.GraphMap;
import org.graphstream.ui.swingViewer.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class Plateau extends JPanel {
    public GraphMap graph;

    // initialisation du plateau de jeu
    public Plateau(View v){
        //graph= g;

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
