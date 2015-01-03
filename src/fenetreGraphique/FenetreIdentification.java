package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.TypeCouleur;
import sun.awt.HorizBagLayout;
import sun.awt.VerticalBagLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Guillaume on 01/01/2015.
 */
//public class FenetreIdentification extends JFrame implements MouseListener {
public class FenetreIdentification extends JFrame implements ActionListener{

    public ArrayList<Joueur> Joueurs;

    public JPanel complet;
    public JPanel choix;
    public JPanel formulaire;
    public JPanel formulaire1;
    public JPanel formulaire2;
    public JPanel formulaire3;
    public JPanel formulaire4;
    public JPanel confirmation;

    public ButtonGroup group;
    public JRadioButton radio3;
    public JRadioButton radio4;

    public JTextArea t1;
    public JTextArea t2;
    public JTextArea t3;
    public JTextArea t4;
    public JLabel msg_error;

    public JButton confirmer;
    public JButton annuler;

    public int valider = 0;

    private String nomFenetre;
    private int hauteur = 400;
    private int largeur = 600;

    public FenetreIdentification(String _nom){
        super(_nom);

        msg_error = new JLabel("Erreur : tous les champs n'ont pas été saisis !");
        msg_error.setHorizontalAlignment(JLabel.CENTER);
        msg_error.setForeground(Color.RED);
        msg_error.setVisible(false);

        Joueurs = new ArrayList<Joueur>();
        nomFenetre = _nom;

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        //permet d'ajouter plusieurs JPanel sans ecraser les anciens
        getContentPane().setLayout(new BorderLayout());

        choix = new JPanel();
        choix.setLayout(new GridLayout(2, 3));
        choix = panelChoix();

        formulaire = new JPanel();
        formulaire.setLayout(new GridLayout(4,1));
        formulaire.setBorder(new EmptyBorder(10, 10, 10, 10));
        formulaire = panelFormulaire();

        confirmation = new JPanel();
        confirmation.setLayout(new GridLayout(2,1));
        confirmation.add(msg_error);
        confirmation.add(panelConfirmation());

        complet = new JPanel(new BorderLayout());
        complet = panelComplet(choix, formulaire, confirmation);

        add(complet);

        //demande d ecouter les boutons
        confirmer.addActionListener(this);
        annuler.addActionListener(this);
        radio3.addActionListener(this);
        radio4.addActionListener(this);

        // affichage
        affichage();
    }

    public JPanel panelChoix(){
        JPanel panelC = new JPanel();
        panelC.setLayout(new GridLayout(2,2));
        group = new ButtonGroup();

        JLabel text1 = new JLabel("Nombre de joueurs : ");
        radio3 = new JRadioButton("3");
        radio3.setSelected(true);
        radio4 = new JRadioButton("4");
        JLabel text2 = new JLabel("     ");

        group.add(radio3);
        group.add(radio4);

        JPanel panelTampo = new JPanel(new BorderLayout());
        panelTampo.add(radio3,BorderLayout.WEST);
        panelTampo.add(radio4,BorderLayout.EAST);

        panelC.add(text1);
        panelC.add(panelTampo);
        panelC.add(text2);

        return panelC;
    }
    public JPanel panelFormulaire(){
        JPanel panelF = new JPanel();
        panelF.setLayout(new GridLayout(4,1));
        panelF.setBorder(new EmptyBorder(10, 10, 10, 10));

        formulaire1 = new JPanel();
        formulaire1.setLayout(new GridLayout(1,4));
        formulaire1.setBorder(BorderFactory.createTitledBorder(""));
        t1 = new JTextArea(1,10);
        JLabel c1 = new JLabel("    ");
        c1.setOpaque(true);
        c1.setBackground(Color.BLUE);
        formulaire1.add(new JLabel("Nom du joueur "));
        formulaire1.add(t1);
        formulaire1.add(new JLabel("Couleur associée "));
        formulaire1.add(c1);

        formulaire2 = new JPanel();
        formulaire2.setLayout(new GridLayout(1,4));
        formulaire2.setBorder(BorderFactory.createTitledBorder(""));
        t2 = new JTextArea(1,10);
        JLabel c2 = new JLabel("    ");
        c2.setOpaque(true);
        c2.setBackground(Color.GREEN);
        formulaire2.add(new JLabel("Nom du joueur "));
        formulaire2.add(t2);
        formulaire2.add(new JLabel("Couleur associée "));
        formulaire2.add(c2);

        formulaire3 = new JPanel();
        formulaire3.setLayout(new GridLayout(1,4));
        formulaire3.setBorder(BorderFactory.createTitledBorder(""));
        t3 = new JTextArea(1,10);
        JLabel c3= new JLabel("    ");
        c3.setOpaque(true);
        c3.setBackground(Color.RED);
        formulaire3.add(new JLabel("Nom du joueur "));
        formulaire3.add(t3);
        formulaire3.add(new JLabel("Couleur associée "));
        formulaire3.add(c3);

        formulaire4 = new JPanel();
        formulaire4.setLayout(new GridLayout(1,4));
        formulaire4.setBorder(BorderFactory.createTitledBorder(""));
        t4 = new JTextArea(1,10);
        JLabel c4 = new JLabel("    ");
        c4.setOpaque(true);
        c4.setBackground(Color.YELLOW);
        formulaire4.add(new JLabel("Nom du joueur "));
        formulaire4.add(t4);
        formulaire4.add(new JLabel("Couleur associée "));
        formulaire4.add(c4);

        formulaire4.setVisible(false);

        panelF.add(formulaire1);
        panelF.add(formulaire2);
        panelF.add(formulaire3);
        panelF.add(formulaire4);

        return panelF;
    }
    public JPanel panelConfirmation(){
        JPanel panelConf = new JPanel();
        panelConf.setLayout(new GridLayout(1, 2));

        // bouton lancer le jeu
        confirmer = new JButton("Lancer le jeu");
        // fermer le jeu
        annuler = new JButton("Annuler");

        panelConf.add(confirmer);
        panelConf.add(annuler);

        return panelConf;
    }
    public JPanel panelComplet( JPanel _choix, JPanel _formulaire, JPanel _confirmation){
        JPanel panelComplet = new JPanel(new BorderLayout());
        panelComplet.add(_choix,        BorderLayout.NORTH);
        panelComplet.add(_formulaire, BorderLayout.CENTER);
        panelComplet.add(_confirmation, BorderLayout.SOUTH);
        return panelComplet;
    }

    public void affichage(){
        setTitle(nomFenetre);
        setResizable(false);
        // initialisa la taille de la fenetre
        setSize(largeur,hauteur);
        // positionne la fenetre au centre
        setLocationRelativeTo(null);
        // termine le processus lorsqu'on clique sur la croix rouge
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // la rend visible
        setVisible(true);
    }

    public int getValider(){return valider;}

    public ArrayList<Joueur> getJoueurs(){return Joueurs;}

    public void actionPerformed(ActionEvent e) {
        // si c est le bouton de radio3
        if (e.getSource() == radio3){
            formulaire4.setVisible(false);
            validate();
        }

        // si c est le bouton de radio4
        if (e.getSource() == radio4){
            formulaire4.setVisible(true);
            validate();
        }


        // si c est le bouton de confirmation du formulaire
        if (e.getSource() == confirmer){
            // verifier champs nom vide avant de faire une modif
            if (radio4.isSelected()) {
                if ( (champSaisit(t1.getText())) && (champSaisit(t2.getText())) && (champSaisit(t3.getText())) && (champSaisit(t4.getText())) ){
                    valider = 1;

                    //creation des joueurs
                    Joueurs.add(new Joueur(t1.getText(), TypeCouleur.BLEU));
                    Joueurs.add(new Joueur(t2.getText(), TypeCouleur.VERT));
                    Joueurs.add(new Joueur(t3.getText(), TypeCouleur.ROUGE));
                    Joueurs.add(new Joueur(t4.getText(), TypeCouleur.JAUNE));

                } else {
                    msg_error.setVisible(true);
                    System.out.println("Erreur : tous les champs n'ont pas été saisis !");
                }
            }
            else{
                if ( (champSaisit(t1.getText())) && (champSaisit(t2.getText())) && (champSaisit(t3.getText())) ){
                    valider = 1;

                    //creation des joueurs
                    Joueurs.add(new Joueur(t1.getText(), TypeCouleur.BLEU));
                    Joueurs.add(new Joueur(t2.getText(), TypeCouleur.VERT));
                    Joueurs.add(new Joueur(t3.getText(), TypeCouleur.ROUGE));

                }
                else {
                    msg_error.setVisible(true);
                    System.out.println("Erreur : tous les champs n'ont pas été saisis !");
                }
            }
        }

        // si c est le bouton annulation de l application
        if (e.getSource() == annuler){
            valider = 2;
            //this.setVisible(false);
        }
    }

    public boolean champSaisit(String n){
        if ((n.contains("a")) || n.contains("b") || n.contains("c") || n.contains("d") || n.contains("e") || n.contains("f")
                || n.contains("g") || n.contains("h") || n.contains("i") || n.contains("j") || n.contains("k") || n.contains("l")
                || n.contains("m") || n.contains("n") || n.contains("o") || n.contains("p") || n.contains("q") || n.contains("r")
                || n.contains("s") || n.contains("t") || n.contains("u") || n.contains("v") || n.contains("w") || n.contains("x")
                || n.contains("y") || n.contains("z") || n.contains("0") || n.contains("1") || n.contains("2") || n.contains("3")
                || n.contains("4") || n.contains("5") || n.contains("6") || n.contains("7") || n.contains("8") || n.contains("9") ){
            return true;
        }
        return false;
    }
}
