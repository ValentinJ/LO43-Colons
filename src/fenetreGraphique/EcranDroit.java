package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.UV;
import sun.awt.VerticalBagLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
    public JPanel Banque;
    public JPanel EJ1;
    public JPanel EJ2;
    public JPanel EJ3;

    public JPanel recap;
    public JPanel recapCarteR;
    public Graphics gImgCarte;
    public Image imgBierre;
    public Image imgSommeil;
    public Image imgCafe;
    public Image imgCours;
    public Image imgNourriture;

    int Tour;

    public EcranDroit(Vector<Joueur> j, int t, Graphics g) throws IOException {
        gImgCarte = g;
        Joueurs = j;
        Tour = t;

        setLayout(new GridLayout(2,1));

        recap = new JPanel();
        recap.setLayout(new VerticalBagLayout());

        // partie le tableau de maniere dynamique
        recapCarteR = new JPanel(new GridLayout(12,Joueurs.size()+1));

//        imgBierre     = ImageIO.read(new File("/img/caseBiere"));
//        imgSommeil    = ImageIO.read(new File("/img/caseBiere"));
//        imgCafe       = ImageIO.read(new File("/img/caseBiere"));
//        imgCours      = ImageIO.read(new File("/img/caseBiere"));
//        imgNourriture = ImageIO.read(new File("/img/caseBiere"));
//        paintComponent(gImgCarte, imgBierre,      0, 5);
//        paintComponent(gImgCarte, imgSommeil,    20, 5);
//        paintComponent(gImgCarte, imgCafe,       40, 5);
//        paintComponent(gImgCarte, imgCours,      60, 5);
//        paintComponent(gImgCarte, imgNourriture, 80, 5);

        // entete tab
        for(int i=-1; i< Joueurs.size(); i++) {
            if (i==-1)
               recapCarteR.add(new JLabel("   "));
            else
                recapCarteR.add(new JLabel((Joueurs.get(i)).getNom()));
        }
        // contenue tab ressource
        for (int i=0; i<5; i++){
            for (int k = -1; k<Joueurs.size()+1; k++){
                if (k==-1) {
                    recapCarteR.add(new JLabel("   "));
                }
                else {
    //                recapCarteR.add(new JLabel((Joueurs.get(k)).getNom()));
                    //TODO mettre les cartes des joueurs et pas les noms !
                }
            }
        }

        // contenue des score
        for(int i=-1; i< Joueurs.size(); i++) {
            recapCarteR.add(new JLabel("   "));
        }
        for (int i=0; i<2; i++) {
            for (int k = -1; k < Joueurs.size() + 1; k++) {
                //UV1
                //UV2
            }
        }        // contenue des score
        for(int i=-1; i< Joueurs.size(); i++) {
            if (i!=-1)
                recapCarteR.add(new JLabel("   "));
            else
                recapCarteR.add(new JLabel("Bonus"));
        }
        for (int i=0; i<2; i++) {
            for (int k = -1; k < Joueurs.size() + 1; k++) {
                //Ancien
                //Comm
            }
        }
        // tot
        for(int i=-1; i< Joueurs.size(); i++) {
            recapCarteR.add(new JLabel("   "));
        }

        // partie nb ville et colonnie du joueur actu
        // partie bonus (anciens + controle continue)
        // partie score tot nb ville + colonnie + bonus

        recap.add(recapCarteR);

        // interface des echanges
        interfaceEchange = new JTabbedPane();
        //creation des onglets de l interface
        for (int i = 0; i < Joueurs.size()-2; i++){
            if (i==0) {
                EJ1 = OngletEchange(i);
                interfaceEchange.add((Joueurs.get((Tour+i)%Joueurs.size())).getNom(), EJ1);
            }
            if (i==1) {
                EJ2 = OngletEchange(i);
                interfaceEchange.add((Joueurs.get((Tour+i)%Joueurs.size())).getNom(), EJ2);
            }
            if (i==3) {
                EJ3 = OngletEchange(i);
                interfaceEchange.add((Joueurs.get((Tour+i)%Joueurs.size())).getNom(), EJ3);
            }
        }
        Banque = OngletEchange(5);
        interfaceEchange.add("Banque", Banque);

        interfaceEchange.setOpaque(true);

        add(recap);
        add(interfaceEchange);
    }

    public void MiseAJour(Vector<Joueur> _j, int _t){
        Joueurs = _j;
        Tour = _t;
        // tableau des ressources dans les mains

        // des differentes possession : carte / UV* / UV** / Controle Continue / ...
    }

    public JPanel OngletEchange(int indiceJoueur){ // servira pour verif cartes, boutons, liste derooulantes , ..
        JPanel tmpFinal = new JPanel();
        tmpFinal.setBorder(new EmptyBorder(5, 0, 0, 5));
        tmpFinal.setLayout(new VerticalBagLayout());

        JPanel tmp = new JPanel();
        tmp.setLayout(new GridLayout(1, 2));

        // coinGauche contient les voutons ratios pour selectionner la carte que l'on souhaite obtenir
        JPanel coinGauche = new JPanel();
        coinGauche.setLayout(new GridLayout(0, 1));
        coinGauche.setBorder(new EmptyBorder(5, 0, 0, 5));
        coinGauche.setBorder(BorderFactory.createTitledBorder("Sélection"));

        ButtonGroup group = new ButtonGroup();

        JRadioButton radio1 = new JRadioButton("Carte 1");
        radio1.setMnemonic(KeyEvent.VK_1);
        radio1.setActionCommand("Carte_1");
        radio1.setSelected(true);
        group.add(radio1);
        coinGauche.add(radio1);

        JRadioButton radio2 = new JRadioButton("Carte 2");
        radio2.setMnemonic(KeyEvent.VK_2);
        radio2.setActionCommand("Carte_2");
        group.add(radio2);
        coinGauche.add(radio2);

        JRadioButton radio3 = new JRadioButton("Carte 3");
        radio3.setMnemonic(KeyEvent.VK_3);
        radio3.setActionCommand("Carte_3");
        group.add(radio3);
        coinGauche.add(radio3);

        JRadioButton radio4 = new JRadioButton("Carte 4");
        radio4.setMnemonic(KeyEvent.VK_4);
        radio4.setActionCommand("Carte_4");
        group.add(radio4);
        coinGauche.add(radio4);

        JRadioButton radio5 = new JRadioButton("Carte 5");
        radio5.setMnemonic(KeyEvent.VK_5);
        radio5.setActionCommand("Carte_5");
        group.add(radio5);
        coinGauche.add(radio5);

        // quelle ressource nous souhaitons donnée pour la carte que nous avons selectionnée dans coinGauche
        JPanel coinDroit = new JPanel();
        coinDroit.setLayout(new GridLayout(5, 2));
        coinDroit.setBorder(new EmptyBorder(5, 0, 0, 5));

        coinDroit.setBorder(BorderFactory.createTitledBorder("Contre"));
        JComboBox jComboBox1 = new JComboBox();
        JComboBox jComboBox2 = new JComboBox();
        JComboBox jComboBox3 = new JComboBox();
        JComboBox jComboBox4 = new JComboBox();
        JComboBox jComboBox5 = new JComboBox();

        jComboBox1.addItem("0");
        jComboBox1.addItem("1");
        jComboBox1.addItem("2");
        jComboBox1.addItem("3");
        jComboBox1.addItem("4");

        jComboBox2.addItem("0");
        jComboBox2.addItem("1");
        jComboBox2.addItem("2");
        jComboBox2.addItem("3");
        jComboBox2.addItem("4");

        jComboBox3.addItem("0");
        jComboBox3.addItem("1");
        jComboBox3.addItem("2");
        jComboBox3.addItem("3");
        jComboBox3.addItem("4");

        jComboBox4.addItem("0");
        jComboBox4.addItem("1");
        jComboBox4.addItem("2");
        jComboBox4.addItem("3");
        jComboBox4.addItem("4");

        jComboBox5.addItem("0");
        jComboBox5.addItem("1");
        jComboBox5.addItem("2");
        jComboBox5.addItem("3");
        jComboBox5.addItem("4");

        coinDroit.add(jComboBox1);
        coinDroit.add(new JLabel("carte 1"));
        coinDroit.add(jComboBox2);
        coinDroit.add(new JLabel("carte 2"));
        coinDroit.add(jComboBox3);
        coinDroit.add(new JLabel("carte 3"));
        coinDroit.add(jComboBox4);
        coinDroit.add(new JLabel("carte 4"));
        coinDroit.add(jComboBox5);
        coinDroit.add(new JLabel("carte 5"));

        tmp.add(coinGauche);
        tmp.add(coinDroit);

        JButton comm = new JButton("Echanger");
        JPanel boutEchg = new JPanel();
        boutEchg.add(comm);

        tmpFinal.add(tmp);
        tmpFinal.add(boutEchg);

        return tmpFinal;
    }

    public void paintComponent(Graphics g, Image img, int d, int h) {
        g.drawImage(img, d, h, null);
    }
}
