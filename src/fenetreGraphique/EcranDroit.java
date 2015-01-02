package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.UV;
import sun.awt.VerticalBagLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranDroit extends JPanel{

    public Vector<Joueur> Joueurs;
    public JTabbedPane interfaceEchange;
    //public ArrayList<OngletEchange> OngletsEchange;
    public OngletEchange Banque;
    public OngletEchange EJ1;
    public OngletEchange EJ2;
    public OngletEchange EJ3;
    public OngletEchange EJ4;

    public JPanel recap;
    public JPanel recapCarteR;
    public JPanel recapScore;

    public Image imgBierre;
    public Image imgSommeil;
    public Image imgCafe;
    public Image imgCours;
    public Image imgNourriture;

    public ButtonGroup group;
    public JRadioButton radio1;
    public JRadioButton radio2;
    public JRadioButton radio3;
    public JRadioButton radio4;
    public JRadioButton radio5;

    public JButton comm;

    int Tour;

    public EcranDroit(Vector<Joueur> j, int t) throws IOException {
        Joueurs = j;
        Tour = t;

        setLayout(new GridLayout(2,1));

        recap = new JPanel(new VerticalBagLayout());

        // partie le tableau de maniere dynamique
        recapCarteR = new JPanel(new GridLayout(12,Joueurs.size()+1));

        imgBierre     = ImageIO.read(new File(System.getProperty("user.dir") +"\\img\\CarteBiere.png"));
        imgSommeil    = ImageIO.read(new File(System.getProperty("user.dir") +"\\img\\CarteSommeil.png"));
        imgCafe       = ImageIO.read(new File(System.getProperty("user.dir") +"\\img\\CarteCafe.png"));
        imgCours      = ImageIO.read(new File(System.getProperty("user.dir") +"\\img\\CarteCours.png"));
        imgNourriture = ImageIO.read(new File(System.getProperty("user.dir") +"\\img\\CarteNourriture.png"));

        // entete tab avec le nom des joueurs
        for(int i=-1; i< Joueurs.size(); i++) {
            if (i==-1)
               recapCarteR.add(new JLabel("   "));
            else
                recapCarteR.add(new JLabel((Joueurs.get(i)).getNom()));
        }
        // contenue tab ressource
        for (int i=0; i<5; i++){
            System.out.println(Integer.toString(i));
            for (int k = -1; k<Joueurs.size(); k++){
                System.out.println(Integer.toString(k));
                if (k == -1) {
                    System.out.println("  Passe dans b");
                    switch (i){
                        case 0:
                            recapCarteR.add(new JLabel(new ImageIcon(imgBierre)){{setOpaque(false);} });
                        case 1:
                            recapCarteR.add(new JLabel(new ImageIcon(imgSommeil)){{setOpaque(false);} });
                        case 2:
                            recapCarteR.add(new JLabel(new ImageIcon(imgCafe)){{setOpaque(false);} });
                        case 3:
                            recapCarteR.add(new JLabel(new ImageIcon(imgCours)){{setOpaque(false);} });
                        case 4:
                            recapCarteR.add(new JLabel(new ImageIcon(imgNourriture)){{setOpaque(false);} });
                    }
                }
                else {
                    recapCarteR.add(new JLabel( Integer.toString( ((Joueurs.get(k)).getMainRessource(i)).getNombre()) ));
                }
            }
        }

        // contenue des score
        recapScore = new JPanel(new GridLayout()); //TODO
        for(int i=-1; i< Joueurs.size(); i++) {
            recapScore.add(new JLabel("   "));
        }
        for (int i=0; i<2; i++) {
            for (int k = -1; k < Joueurs.size() + 1; k++) {
                //UV1
                //UV2
            }
        }        // contenue des score
        for(int i=-1; i< Joueurs.size(); i++) {
            if (i!=-1)
                recapScore.add(new JLabel("   "));
            else
                recapScore.add(new JLabel("Bonus"));
        }
        for (int i=0; i<2; i++) {
            for (int k = -1; k < Joueurs.size() + 1; k++) {
                //Ancien
                //Comm
            }
        }
        // tot
        for(int i=-1; i< Joueurs.size(); i++) {
            recapScore.add(new JLabel("   "));
        }

        // partie nb ville et colonnie du joueur actu
        // partie bonus (anciens + controle continue)
        // partie score tot nb ville + colonnie + bonus

        recap.add(recapCarteR);
        recap.add(recapScore);

        // interface des echanges
        interfaceEchange = new JTabbedPane();
        //creation des onglets de l interface
        EJ1 = new OngletEchange();
        EJ2 = new OngletEchange();
        EJ3 = new OngletEchange();
        EJ4 = new OngletEchange();

        TableauDechange();

        add(recap);
        add(interfaceEchange);
    }

    public void TableauDechange(){
        interfaceEchange.removeAll();

        if (Tour%Joueurs.size() != 0)
            interfaceEchange.add((Joueurs.get((0))).getNom(), EJ1);
        if (Tour%Joueurs.size() != 1)
            interfaceEchange.add((Joueurs.get((1))).getNom(), EJ2);
        if (Tour%Joueurs.size() != 2)
            interfaceEchange.add((Joueurs.get((2))).getNom(), EJ3);
        if (Joueurs.size()>3) {
            if (Tour%Joueurs.size() != 3)
                interfaceEchange.add((Joueurs.get((3))).getNom(), EJ4);
        }

        Banque = new OngletEchange();
        interfaceEchange.add("Banque", Banque);
        interfaceEchange.setOpaque(true);
    }

    public void MiseAJour(Vector<Joueur> _j, int _t){
        Joueurs = _j;
        Tour = _t;

        TableauDechange();

        // tableau des ressources dans les mains

        // des differentes possession : carte / UV* / UV** / Controle Continue / ...

        validate();
    }
}
