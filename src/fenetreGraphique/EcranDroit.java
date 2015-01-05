package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.ManagerJeu;
import colonsUTBM.TypeCouleur;
import colonsUTBM.TypeRessource;
import sun.awt.VerticalBagLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranDroit extends JPanel{
    public FenetrePrincipale frame;
    public ManagerJeu manJeu;


    public ArrayList<Joueur> Joueurs;
    public JTabbedPane interfaceEchange;
    public OngletEchange Banque;
    public OngletEchange EJ1;
    public OngletEchange EJ2;
    public OngletEchange EJ3;
    public OngletEchange EJ4;

    public JPanel recap;
    public JPanel recapInfos;

    public JPanel enteteV;
    public JPanel infosJoueur;
    public JPanel infosJ1;
    public JPanel infosJ2;
    public JPanel infosJ3;
    public JPanel infosJ4;

    public Image imgBierre;
    public Image imgSommeil;
    public Image imgCafe;
    public Image imgCours;
    public Image imgNourriture;

    public EcranBas eB;

    int Tour;

    public EcranDroit(ManagerJeu _manJeu, FenetrePrincipale _frame, EcranBas _eB) {
        Joueurs = _manJeu.getJoueurs();
        Tour = _manJeu.getTour();
        manJeu = _manJeu;
        frame = _frame;
        eB = _eB;

        //setLayout(new GridLayout(2, 1));
        setLayout(new GridBagLayout());


        recap = new JPanel(new VerticalBagLayout());

        // partie le tableau de maniere dynamique
        recapInfos = new JPanel(new GridLayout(1,2));

        try {
            imgBierre     = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteBiere.png"));
        } catch (IOException e) {e.printStackTrace();}
        try {
            imgSommeil    = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteSommeil.png"));
        } catch (IOException e) {e.printStackTrace();}
        try {
            imgCafe       = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteCafe.png"));
        } catch (IOException e) {e.printStackTrace();}
        try {
            imgCours      = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteCours.png"));
        } catch (IOException e) {e.printStackTrace();}
        try {
            imgNourriture = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteNourriture.png"));
        } catch (IOException e) {e.printStackTrace();}

        recapInfosJoueurs();

        recap.add(infosJoueur);

        // interface des echanges
        interfaceEchange = new JTabbedPane();
        //creation des onglets de l interface
        EJ1 = new OngletEchange(eB, manJeu);
        EJ2 = new OngletEchange(eB, manJeu);
        EJ3 = new OngletEchange(eB, manJeu);
        EJ4 = new OngletEchange(eB, manJeu);

        TableauDechange();

        add(recap, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 0), 0, 0));
        add(interfaceEchange, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }

    public void enteteVertical(){
        enteteV = new JPanel(new GridLayout(14,1));
        enteteV.add(new JLabel("  "));
        enteteV.add(new JLabel(new ImageIcon(imgBierre)){{setOpaque(false);}});
        enteteV.add(new JLabel(new ImageIcon(imgSommeil)){{setOpaque(false);} });
        enteteV.add(new JLabel(new ImageIcon(imgCafe)){{setOpaque(false);} });
        enteteV.add(new JLabel(new ImageIcon(imgCours)){{setOpaque(false);} });
        enteteV.add(new JLabel(new ImageIcon(imgNourriture)){{setOpaque(false);} });
        enteteV.add(new JLabel("  "));
        enteteV.add(new JLabel("UV1"));
        enteteV.add(new JLabel("uv2"));
        enteteV.add(new JLabel("  "));
        enteteV.add(new JLabel("Ancien "));
        enteteV.add(new JLabel("C C"));
        enteteV.add(new JLabel("  "));
        enteteV.add(new JLabel("Score"));
    }

    public void recapInfosJoueurs(){
        infosJoueur = new JPanel(new GridLayout(1, Joueurs.size()+1));

        enteteVertical();
        infosJoueur.add(enteteV);

        infosJ1 = new JPanel(new GridLayout(14,1));
        infosJ1.add(new JLabel((Joueurs.get(0)).getNom()));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.BIERE)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.CAFE)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.COURS)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) ));
        infosJ1.add(new JLabel("  "));
        infosJ1.add(new JLabel(Integer.toString((((Joueurs.get(0)).getNbUvs()).get(0)))));
        infosJ1.add(new JLabel(Integer.toString((((Joueurs.get(0)).getNbUvs()).get(1)))));
        infosJ1.add(new JLabel("  "));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getAncien()))));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getCCsize()))));
        infosJ1.add(new JLabel("  "));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getScore()))));
        infosJoueur.add(infosJ1);

        infosJ2 = new JPanel(new GridLayout(14,1));
        infosJ2.add(new JLabel((Joueurs.get(1)).getNom()));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.BIERE)).getNombre()) ));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) ));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.CAFE)).getNombre()) ));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.COURS)).getNombre()) ));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) ));
        infosJ2.add(new JLabel("  "));
        infosJ2.add(new JLabel(Integer.toString((((Joueurs.get(1)).getNbUvs()).get(0)))));
        infosJ2.add(new JLabel(Integer.toString((((Joueurs.get(1)).getNbUvs()).get(1)))));
        infosJ2.add(new JLabel("  "));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getAncien()))));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getCCsize()))));
        infosJ2.add(new JLabel("  "));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getScore()))));
        infosJoueur.add(infosJ2);

        infosJ3 = new JPanel(new GridLayout(14,1));
        infosJ3.add(new JLabel((Joueurs.get(2)).getNom()));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.BIERE)).getNombre()) ));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) ));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.CAFE)).getNombre()) ));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.COURS)).getNombre()) ));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) ));
        infosJ3.add(new JLabel("  "));
        infosJ3.add(new JLabel(Integer.toString((((Joueurs.get(2)).getNbUvs()).get(0)))));
        infosJ3.add(new JLabel(Integer.toString((((Joueurs.get(2)).getNbUvs()).get(1)))));
        infosJ3.add(new JLabel("  "));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getAncien()))));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getCCsize()))));
        infosJ3.add(new JLabel("  "));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getScore()))));
        infosJoueur.add(infosJ3);

        infosJ4 = new JPanel(new GridLayout(14,1));
        if  (Joueurs.size() > 3){
            infosJ4.add(new JLabel((Joueurs.get(3)).getNom()));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.BIERE)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.CAFE)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.COURS)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) ));
            infosJ4.add(new JLabel("  "));
            infosJ4.add(new JLabel(Integer.toString((((Joueurs.get(3)).getNbUvs()).get(0)))));
            infosJ4.add(new JLabel(Integer.toString((((Joueurs.get(3)).getNbUvs()).get(1)))));
            infosJ4.add(new JLabel("  "));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getAncien()))));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getCCsize()))));
            infosJ4.add(new JLabel("  "));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getScore()))));
            infosJoueur.add(infosJ4);
        }

        changementCouleur(0);

        infosJoueur.setBorder(BorderFactory.createTitledBorder("Renseignement"));
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

        Banque = new OngletEchange(eB, manJeu);
        interfaceEchange.add("Banque", Banque);
        interfaceEchange.setOpaque(true);
    }

    public void MiseAJour(ManagerJeu _manJeu){
        manJeu = _manJeu;
        Joueurs = _manJeu.getJoueurs();
        Tour = _manJeu.getTour();

        infosJoueur.removeAll();
        recap.removeAll();
        remove(recap);
        remove(interfaceEchange);
        repaint();
        recapInfosJoueurs();
        recap.add(infosJoueur);

        // interface des echanges
        interfaceEchange = new JTabbedPane();
        //creation des onglets de l interface
        EJ1 = new OngletEchange(eB, manJeu);
        EJ2 = new OngletEchange(eB, manJeu);
        EJ3 = new OngletEchange(eB, manJeu);
        EJ4 = new OngletEchange(eB, manJeu);

        TableauDechange();
        add(recap, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 0), 0, 0));
        add(interfaceEchange, new GridBagConstraints(0,1, 1, 1, 0, 0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    }

    public void changementCouleur(int t){
        int rang = Tour%Joueurs.size();
        if (rang == 0) {
            if (((Joueurs.get(rang)).getCouleur()).equals("blue")) {
                infosJ1.setBackground(Color.BLUE);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("red")) {
                infosJ1.setBackground(Color.RED);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("green")) {
                infosJ1.setBackground(Color.GREEN);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("yellow")) {
                infosJ1.setBackground(Color.YELLOW);
            }
        }
        if (rang == 1) {
            if (((Joueurs.get(rang)).getCouleur()).equals("blue")) {
                infosJ2.setBackground(Color.BLUE);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("red")) {
                infosJ2.setBackground(Color.RED);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("green")) {
                infosJ2.setBackground(Color.GREEN);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("yellow")) {
                infosJ2.setBackground(Color.YELLOW);
            }
        }
        if (rang == 2) {
            if (((Joueurs.get(rang)).getCouleur()).equals("blue")) {
                infosJ3.setBackground(Color.BLUE);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("red")) {
                infosJ3.setBackground(Color.RED);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("green")) {
                infosJ3.setBackground(Color.GREEN);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("yellow")) {
                infosJ3.setBackground(Color.YELLOW);
            }
        }
        if (rang == 3) {
            if (((Joueurs.get(rang)).getCouleur()).equals("blue")) {
                infosJ4.setBackground(Color.BLUE);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("red")) {
                infosJ4.setBackground(Color.RED);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("green")) {
                infosJ4.setBackground(Color.GREEN);
            }
            if (((Joueurs.get(rang)).getCouleur()).equals("yellow")) {
                infosJ4.setBackground(Color.YELLOW);
            }
        }
    }

}
