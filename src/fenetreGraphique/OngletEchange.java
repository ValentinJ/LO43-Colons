package fenetreGraphique;

import sun.awt.VerticalBagLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Guillaume on 16/12/2014.
 */

public class OngletEchange extends JPanel implements ActionListener{

    public JPanel tmpFinal;
    public JPanel tmp;
    public JPanel coinGauche;
    public JPanel coinDroit;
    public ButtonGroup group;

    public JComboBox jComboBox1;
    public JComboBox jComboBox2;
    public JComboBox jComboBox3;
    public JComboBox jComboBox4;
    public JComboBox jComboBox5;

    public JRadioButton radio1;
    public JRadioButton radio2;
    public JRadioButton radio3;
    public JRadioButton radio4;
    public JRadioButton radio5;

    public JButton comm;

    public OngletEchange(){
        tmpFinal = new JPanel();
        tmpFinal.setBorder(new EmptyBorder(5, 0, 0, 5));
        tmpFinal.setLayout(new VerticalBagLayout());

        tmp = new JPanel();
        tmp.setLayout(new GridLayout(1, 2));

        // coinGauche contient les boutons ratios pour selectionner la carte que l'on souhaite obtenir
        coinGauche = new JPanel();
        coinGauche.setLayout(new GridLayout(0, 1));
        coinGauche.setBorder(new EmptyBorder(5, 0, 0, 5));
        coinGauche.setBorder(BorderFactory.createTitledBorder("Sélection"));

        group = new ButtonGroup();

        radio1 = new JRadioButton("Carte 1");
        radio1.setMnemonic(KeyEvent.VK_1);
        radio1.setActionCommand("Carte_1");
        radio1.setSelected(true);
        group.add(radio1);
        coinGauche.add(radio1);

        radio2 = new JRadioButton("Carte 2");
        radio2.setMnemonic(KeyEvent.VK_2);
        radio2.setActionCommand("Carte_2");
        group.add(radio2);
        coinGauche.add(radio2);

        radio3 = new JRadioButton("Carte 3");
        radio3.setMnemonic(KeyEvent.VK_3);
        radio3.setActionCommand("Carte_3");
        group.add(radio3);
        coinGauche.add(radio3);

        radio4 = new JRadioButton("Carte 4");
        radio4.setMnemonic(KeyEvent.VK_4);
        radio4.setActionCommand("Carte_4");
        group.add(radio4);
        coinGauche.add(radio4);

        radio5 = new JRadioButton("Carte 5");
        radio5.setMnemonic(KeyEvent.VK_5);
        radio5.setActionCommand("Carte_5");
        group.add(radio5);
        coinGauche.add(radio5);

        // quelle ressource nous souhaitons donnée pour la carte que nous avons selectionnée dans coinGauche
        coinDroit = new JPanel();
        coinDroit.setLayout(new GridLayout(5, 2));
        coinDroit.setBorder(new EmptyBorder(5, 0, 0, 5));

        coinDroit.setBorder(BorderFactory.createTitledBorder("Contre"));
        jComboBox1 = new JComboBox();
        jComboBox2 = new JComboBox();
        jComboBox3 = new JComboBox();
        jComboBox4 = new JComboBox();
        jComboBox5 = new JComboBox();

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

        comm = new JButton("Echanger");
        comm.addActionListener(this);
        JPanel boutEchg = new JPanel();
        boutEchg.add(comm);

        tmpFinal.add(tmp);
        tmpFinal.add(boutEchg);

        add(tmpFinal);
    }

    public void actionPerformed(ActionEvent echange1) {
        // si c est le bouton confirmerEchange
        if (echange1.getSource() == comm) {
            System.out.println("le joueur a demander un echange");
            group.getSelection(); // pour connaitre le type de carte desirer
        }
    }
}
