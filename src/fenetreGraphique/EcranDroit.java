package fenetreGraphique;

import colonsUTBM.Joueur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranDroit extends JPanel{

    public Vector<Joueur> Joueurs;
    public JTabbedPane interfaceEchange;
    int Tour;

    public EcranDroit(Vector<Joueur> j, int t){
        Joueurs = j;
        Tour = t;
        // partie le tableau de maniere dynamique
        // partie nb ville et colonnie du joueur actu
        // partie bonus (anciens + controle continue)
        // partie score tot nb ville + colonnie + bonus

        // interface des echanges
        interfaceEchange = new JTabbedPane();
        JPanel echange = new JPanel();
        //creation des onglets de l interface
        for (int i = 1; i <= Joueurs.size()-1; i++){
            //creationOngletsEchange(echange);
            interfaceEchange.add((Joueurs.get((Tour+i)%Joueurs.size())).getNom(), this.creationOngletsEchange());
        }
        //echange.creationOngletsEchange();
        interfaceEchange.add("Banque", this.creationOngletsEchange());


        interfaceEchange.setOpaque(true);
        add(interfaceEchange);
    }

    public void MiseAJour(Vector<Joueur> _j, int _t){
        Joueurs = _j;
        Tour = _t;
        // tableau des ressources dans les mains

        // des differentes possession : carte / UV* / UV** / Controle Continue / ...
    }

    //public void creationOngletsEchange(JPanel tmpFinal){
    public JPanel creationOngletsEchange(){
        JPanel tmpFinal = new JPanel();
        tmpFinal.setLayout(new GridLayout(2, 1));

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
        coinDroit.setLayout(new GridLayout(2, 5));
        coinDroit.setBorder(new EmptyBorder(5, 0, 0, 5));
        coinDroit.setBorder(BorderFactory.createTitledBorder("Contre"));
        JComboBox jComboBox1 = new JComboBox();
        JComboBox jComboBox2 = new JComboBox();
        JComboBox jComboBox3 = new JComboBox();
        JComboBox jComboBox4 = new JComboBox();
        JComboBox jComboBox5 = new JComboBox();

        jComboBox1.addItem("1");
        jComboBox1.addItem("2");
        jComboBox1.addItem("3");
        jComboBox1.addItem("4");

        jComboBox2.addItem("1");
        jComboBox2.addItem("2");
        jComboBox2.addItem("3");
        jComboBox2.addItem("4");

        jComboBox3.addItem("1");
        jComboBox3.addItem("2");
        jComboBox3.addItem("3");
        jComboBox3.addItem("4");

        jComboBox4.addItem("1");
        jComboBox4.addItem("2");
        jComboBox4.addItem("3");
        jComboBox4.addItem("4");

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

        tmpFinal.add(tmp);
        tmpFinal.add(new JButton("Echanger"));

        return tmpFinal;
    }
}
