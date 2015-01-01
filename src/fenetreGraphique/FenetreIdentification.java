package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.TypeCouleur;
import sun.awt.HorizBagLayout;
import sun.awt.VerticalBagLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * Created by Guillaume on 01/01/2015.
 */
//public class FenetreIdentification extends JFrame implements MouseListener {
public class FenetreIdentification extends JFrame{

    public Vector<Joueur> Joueurs;

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

    public JButton confirmer;
    public JButton annuler;

    public int valider = 0;

    private String nomFenetre;
    private int hauteur = 500;
    private int largeur = 800;

    public FenetreIdentification(String _nom, Vector<Joueur> J){
        super(_nom);

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new BorderLayout());
        //permet d'ajouter plusieurs JPanel sans ecraser les anciens
        getContentPane().setLayout(new BorderLayout());

        // boutons radio
        //    3 - 4
        choix = new JPanel();
        choix.setLayout(new GridLayout(2, 3));
        group = new ButtonGroup();

        JLabel text1 = new JLabel("Nombre de joueur : ");
        radio3 = new JRadioButton("3");
        radio3.setSelected(true);
        radio3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    t4.setEditable(false);
                    System.out.println("        Verouiller t4");
            }
        });
        radio4 = new JRadioButton("4");
        radio3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    t4.setEditable(true);
                    System.out.println("        Deverouiller t4");
            }
        });
        JLabel text2 = new JLabel("Remplisser les informations pour les joueurs : ");

        group.add(radio3);
        group.add(radio4);

        choix.add(text1);
        choix.add(radio3);
        choix.add(radio4);
        choix.add(text2);

        // JTEXTAREA  + JLABEL Couleur
        formulaire = new JPanel();
        choix.setLayout(new GridLayout(4,1));

        formulaire1 = new JPanel();
        formulaire1.setLayout(new GridLayout(1,4));
        t1 = new JTextArea(1,10);
        JLabel c1 = new JLabel("    ");
        c1.setOpaque(true);
        c1.setBackground(Color.BLUE);
        formulaire1.add(new JLabel("Nom du joueur "));
        formulaire1.add(t1);
        formulaire1.add(new JLabel(" Couleur associé "));
        formulaire1.add(c1);

        formulaire2 = new JPanel();
        formulaire2.setLayout(new GridLayout(1,4));
        t2 = new JTextArea(1,10);
        JLabel c2 = new JLabel("    ");
        c2.setOpaque(true);
        c2.setBackground(Color.GREEN);
        formulaire2.add(new JLabel("Nom du joueur "));
        formulaire2.add(t2);
        formulaire2.add(new JLabel(" Couleur associé "));
        formulaire2.add(c2);

        formulaire3 = new JPanel();
        formulaire3.setLayout(new GridLayout(1,4));
        t3 = new JTextArea(1,10);
        JLabel c3= new JLabel("    ");
        c3.setOpaque(true);
        c3.setBackground(Color.RED);
        formulaire3.add(new JLabel("Nom du joueur "));
        formulaire3.add(t3);
        formulaire3.add(new JLabel(" Couleur associé "));
        formulaire3.add(c3);

        formulaire4 = new JPanel();
        formulaire4.setLayout(new GridLayout(1,4));
        t4 = new JTextArea(1,10);
        t4.setEditable(false); // puisque par defaut il n y a que trois joueurs
        JLabel c4 = new JLabel("    ");
        c4.setOpaque(true);
        c4.setBackground(Color.YELLOW);
        formulaire4.add(new JLabel("Nom du joueur "));
        formulaire4.add(t4);
        formulaire4.add(new JLabel(" Couleur associé "));
        formulaire4.add(c4);

        formulaire.add(formulaire1);
        formulaire.add(formulaire2);
        formulaire.add(formulaire3);
        formulaire.add(formulaire4);


        confirmation = new JPanel();
        confirmation.setLayout(new GridLayout(1, 2));

        // bouton lancer le jeu
        confirmer = new JButton("lancer le jeu");
        confirmer.addActionListener(new ConfirmerListener());
        // fermer le jeu
        annuler = new JButton("Annuler");
        annuler.addActionListener(new AnnulerListener());

        confirmation.add(confirmer);
        confirmation.add(annuler);

        complet = new JPanel(new BorderLayout());

        complet.add(choix,        BorderLayout.NORTH);
        complet.add(formulaire, BorderLayout.CENTER);
        complet.add(confirmation, BorderLayout.SOUTH);

        add(complet);

        // affichage
        affichage();

        J = Joueurs;
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

    public int getValider(){
        return valider;
    }


    // insertion des classes listener unique pour cette fenetre
    class ConfirmerListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e1) {
            // verifier champs nom vide avant de faire une modif
            if (radio4.isSelected()) {
                if ((!((t1.getText()).equals(""))) && (!((t2.getText()).equals("")))
                        && (!((t3.getText().equals("")))) && (!((t4.getText().equals(""))))) {
                    valider = 1;

                    //creation des joueurs
                    Joueurs.add(new Joueur(t1.getText(), TypeCouleur.BLEU));
                    Joueurs.add(new Joueur(t2.getText(), TypeCouleur.VERT));
                    Joueurs.add(new Joueur(t3.getText(), TypeCouleur.ROUGE));
                    Joueurs.add(new Joueur(t4.getText(), TypeCouleur.JAUNE));

                } else {
                    System.out.println("Erreur, tous les champs n'ont pas été saisie");
                }
            }
            else{
                if ((!((t1.getText()).equals(""))) && (!((t2.getText()).equals(""))) && (!((t3.getText().equals("")))) ) {
                    valider = 1;

                    //creation des joueurs
                    Joueurs.add(new Joueur(t1.getText(), TypeCouleur.BLEU));
                    Joueurs.add(new Joueur(t2.getText(), TypeCouleur.VERT));
                    Joueurs.add(new Joueur(t3.getText(), TypeCouleur.ROUGE));

                }
                else {
                    System.out.println("Erreur, tous les champs n'ont pas été saisie");
                }
            }

            System.out.println("Fenetre id - ConfirmerListener - valider " + valider);
        }
    }
    class AnnulerListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e2) {
            valider = 2;
            System.out.println("Fenetre id - AnnulerListener - valider " + valider);
            //this.dispose();
            //System.exit(0);
        }
    }
}
