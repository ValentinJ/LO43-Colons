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
    public JLabel nomJ1;
    public JLabel bierreJ1;
    public JLabel sommeilJ1;
    public JLabel cafeJ1;
    public JLabel coursJ1;
    public JLabel nourritureJ1;
    public JLabel blanc;
    public JLabel nbUV1J1;
    public JLabel nbUV2J1;
    public JLabel nbAncienJ1;
    public JLabel nbCCJ1;
    public JLabel scoreJ1;

    public JPanel infosJ2;
    public JLabel nomJ2;
    public JLabel bierreJ2;
    public JLabel sommeilJ2;
    public JLabel cafeJ2;
    public JLabel coursJ2;
    public JLabel nourritureJ2;
    public JLabel nbUV1J2;
    public JLabel nbUV2J2;
    public JLabel nbAncienJ2;
    public JLabel nbCCJ2;
    public JLabel scoreJ2;

    public JPanel infosJ3;
    public JLabel nomJ3;
    public JLabel bierreJ3;
    public JLabel sommeilJ3;
    public JLabel cafeJ3;
    public JLabel coursJ3;
    public JLabel nourritureJ3;
    public JLabel nbUV1J3;
    public JLabel nbUV2J3;
    public JLabel nbAncienJ3;
    public JLabel nbCCJ3;
    public JLabel scoreJ3;

    public JPanel infosJ4;
    public JLabel nomJ4;
    public JLabel bierreJ4;
    public JLabel sommeilJ4;
    public JLabel cafeJ4;
    public JLabel coursJ4;
    public JLabel nourritureJ4;
    public JLabel nbUV1J4;
    public JLabel nbUV2J4;
    public JLabel nbAncienJ4;
    public JLabel nbCCJ4;
    public JLabel scoreJ4;

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

        infosJoueur = new JPanel(new GridLayout(1, Joueurs.size()+1));
        enteteVertical();
        infosJoueur.add(enteteV);
        recapInfosJoueurs();

        //recap.add(infosJoueur);

        // interface des echanges
        interfaceEchange = new JTabbedPane();
        //creation des onglets de l interface
        EJ1 = new OngletEchange(eB, manJeu);
        EJ2 = new OngletEchange(eB, manJeu);
        EJ3 = new OngletEchange(eB, manJeu);
        EJ4 = new OngletEchange(eB, manJeu);
        Banque = new OngletEchange(eB, manJeu);

        TableauDechange();

        add(infosJoueur, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 0), 0, 0));
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

    public void instanciationVariableJoueurs(){
        nomJ1 = new JLabel((Joueurs.get(0)).getNom());
        bierreJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.BIERE)).getNombre()) );
        sommeilJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) );
        cafeJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.CAFE)).getNombre()) );
        coursJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.COURS)).getNombre()) );
        nourritureJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) );
        nbUV1J1 = new JLabel(Integer.toString((((Joueurs.get(0)).getNbUvs()).get(0))));
        nbUV2J1 = new JLabel(Integer.toString((((Joueurs.get(0)).getNbUvs()).get(1))));
        nbAncienJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getAncien())));
        nbCCJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getCCsize())));
        scoreJ1 = new JLabel(Integer.toString( ((Joueurs.get(0)).getScore())));

        nomJ2 = new JLabel((Joueurs.get(1)).getNom());
        bierreJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.BIERE)).getNombre()) );
        sommeilJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) );
        cafeJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.CAFE)).getNombre()) );
        coursJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.COURS)).getNombre()) );
        nourritureJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) );
        nbUV1J2 = new JLabel(Integer.toString((((Joueurs.get(1)).getNbUvs()).get(0))));
        nbUV2J2 = new JLabel(Integer.toString((((Joueurs.get(1)).getNbUvs()).get(1))));
        nbAncienJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getAncien())));
        nbCCJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getCCsize())));
        scoreJ2 = new JLabel(Integer.toString( ((Joueurs.get(1)).getScore())));

        nomJ3 = new JLabel((Joueurs.get(2)).getNom());
        bierreJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.BIERE)).getNombre()) );
        sommeilJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) );
        cafeJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.CAFE)).getNombre()) );
        coursJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.COURS)).getNombre()) );
        nourritureJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) );
        nbUV1J3 = new JLabel(Integer.toString((((Joueurs.get(2)).getNbUvs()).get(0))));
        nbUV2J3 = new JLabel(Integer.toString((((Joueurs.get(2)).getNbUvs()).get(1))));
        nbAncienJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getAncien())));
        nbCCJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getCCsize())));
        scoreJ3 = new JLabel(Integer.toString( ((Joueurs.get(2)).getScore())));

        if  (Joueurs.size() > 3) {
            nomJ4 = new JLabel((Joueurs.get(3)).getNom());
            bierreJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.BIERE)).getNombre()));
            sommeilJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()));
            cafeJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.CAFE)).getNombre()));
            coursJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.COURS)).getNombre()));
            nourritureJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()));
            nbUV1J4 = new JLabel(Integer.toString((((Joueurs.get(3)).getNbUvs()).get(0))));
            nbUV2J4 = new JLabel(Integer.toString((((Joueurs.get(3)).getNbUvs()).get(1))));
            nbAncienJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getAncien())));
            nbCCJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getCCsize())));
            scoreJ4 = new JLabel(Integer.toString(((Joueurs.get(3)).getScore())));
        }
    }

    public void MAJinstanciationVariableJoueurs(){
        nomJ1.setText((Joueurs.get(0)).getNom());
        bierreJ1.setText(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.BIERE)).getNombre()) );
        sommeilJ1.setText(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) );
        cafeJ1.setText(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.CAFE)).getNombre()) );
        coursJ1.setText(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.COURS)).getNombre()) );
        nourritureJ1.setText(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) );
        nbUV1J1.setText(Integer.toString((((Joueurs.get(0)).getNbUvs()).get(0))));
        nbUV2J1.setText(Integer.toString((((Joueurs.get(0)).getNbUvs()).get(1))));
        nbAncienJ1.setText(Integer.toString( ((Joueurs.get(0)).getAncien())));
        nbCCJ1.setText(Integer.toString( ((Joueurs.get(0)).getCCsize())));
        scoreJ1.setText(Integer.toString( ((Joueurs.get(0)).getScore())));

        nomJ2.setText((Joueurs.get(1)).getNom());
        bierreJ2.setText(Integer.toString(((Joueurs.get(1)).getMainRessource(TypeRessource.BIERE)).getNombre()));
        sommeilJ2.setText(Integer.toString(((Joueurs.get(1)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()));
        cafeJ2.setText(Integer.toString(((Joueurs.get(1)).getMainRessource(TypeRessource.CAFE)).getNombre()));
        coursJ2.setText(Integer.toString(((Joueurs.get(1)).getMainRessource(TypeRessource.COURS)).getNombre()));
        nourritureJ2.setText(Integer.toString(((Joueurs.get(1)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()));
        nbUV1J2.setText(Integer.toString((((Joueurs.get(1)).getNbUvs()).get(0))));
        nbUV2J2.setText(Integer.toString((((Joueurs.get(1)).getNbUvs()).get(1))));
        nbAncienJ2.setText(Integer.toString(((Joueurs.get(1)).getAncien())));
        nbCCJ2.setText(Integer.toString(((Joueurs.get(1)).getCCsize())));
        scoreJ2.setText(Integer.toString(((Joueurs.get(1)).getScore())));

        nomJ3.setText((Joueurs.get(2)).getNom());
        bierreJ3.setText(Integer.toString(((Joueurs.get(2)).getMainRessource(TypeRessource.BIERE)).getNombre()));
        sommeilJ3.setText(Integer.toString(((Joueurs.get(2)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()));
        cafeJ3.setText(Integer.toString(((Joueurs.get(2)).getMainRessource(TypeRessource.CAFE)).getNombre()));
        coursJ3.setText(Integer.toString(((Joueurs.get(2)).getMainRessource(TypeRessource.COURS)).getNombre()));
        nourritureJ3.setText(Integer.toString(((Joueurs.get(2)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()));
        nbUV1J3.setText(Integer.toString((((Joueurs.get(2)).getNbUvs()).get(0))));
        nbUV2J3.setText(Integer.toString((((Joueurs.get(2)).getNbUvs()).get(1))));
        nbAncienJ3.setText(Integer.toString(((Joueurs.get(2)).getAncien())));
        nbCCJ3.setText(Integer.toString(((Joueurs.get(2)).getCCsize())));
        scoreJ3.setText(Integer.toString(((Joueurs.get(2)).getScore())));

        if  (Joueurs.size() > 3) {
            nomJ4.setText((Joueurs.get(3)).getNom());
            bierreJ4.setText(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.BIERE)).getNombre()));
            sommeilJ4.setText(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()));
            cafeJ4.setText(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.CAFE)).getNombre()));
            coursJ4.setText(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.COURS)).getNombre()));
            nourritureJ4.setText(Integer.toString(((Joueurs.get(3)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()));
            nbUV1J4.setText(Integer.toString((((Joueurs.get(3)).getNbUvs()).get(0))));
            nbUV2J4.setText(Integer.toString((((Joueurs.get(3)).getNbUvs()).get(1))));
            nbAncienJ4.setText(Integer.toString(((Joueurs.get(3)).getAncien())));
            nbCCJ4.setText(Integer.toString(((Joueurs.get(3)).getCCsize())));
            scoreJ4.setText(Integer.toString(((Joueurs.get(3)).getScore())));
        }

        changementCouleur();
    }

    public void recapInfosJoueurs(){

        instanciationVariableJoueurs();
        infosJ1 = new JPanel(new GridLayout(14,1));
        infosJ1.add(nomJ1);
        infosJ1.add(bierreJ1);
        infosJ1.add(sommeilJ1);
        infosJ1.add(cafeJ1);
        infosJ1.add(coursJ1);
        infosJ1.add(nourritureJ1);
        infosJ1.add(new JLabel("  "));
        infosJ1.add(nbUV1J1);
        infosJ1.add(nbUV2J1);
        infosJ1.add(new JLabel("  "));
        infosJ1.add(nbAncienJ1);
        infosJ1.add(nbCCJ1);
        infosJ1.add(new JLabel("  "));
        infosJ1.add(scoreJ1);
        infosJoueur.add(infosJ1);

        infosJ2 = new JPanel(new GridLayout(14,1));
        infosJ2.add(nomJ2);
        infosJ2.add(bierreJ2);
        infosJ2.add(sommeilJ2);
        infosJ2.add(cafeJ2);
        infosJ2.add(coursJ2);
        infosJ2.add(nourritureJ2);
        infosJ2.add(new JLabel("  "));
        infosJ2.add(nbUV1J2);
        infosJ2.add(nbUV2J2);
        infosJ2.add(new JLabel("  "));
        infosJ2.add(nbAncienJ2);
        infosJ2.add(nbCCJ2);
        infosJ2.add(new JLabel("  "));
        infosJ2.add(scoreJ2);
        infosJoueur.add(infosJ2);

        infosJ3 = new JPanel(new GridLayout(14,1));
        infosJ3.add(nomJ3);
        infosJ3.add(bierreJ3);
        infosJ3.add(sommeilJ3);
        infosJ3.add(cafeJ3);
        infosJ3.add(coursJ3);
        infosJ3.add(nourritureJ3);
        infosJ3.add(new JLabel("  "));
        infosJ3.add(nbUV1J3);
        infosJ3.add(nbUV2J3);
        infosJ3.add(new JLabel("  "));
        infosJ3.add(nbAncienJ3);
        infosJ3.add(nbCCJ3);
        infosJ3.add(new JLabel("  "));
        infosJ3.add(scoreJ3);
        infosJoueur.add(infosJ3);

        infosJ4 = new JPanel(new GridLayout(14,1));
        if  (Joueurs.size() > 3) {
            infosJ4.add(nomJ4);
            infosJ4.add(bierreJ4);
            infosJ4.add(sommeilJ4);
            infosJ4.add(cafeJ4);
            infosJ4.add(coursJ4);
            infosJ4.add(nourritureJ4);
            infosJ4.add(new JLabel("  "));
            infosJ4.add(nbUV1J4);
            infosJ4.add(nbUV2J4);
            infosJ4.add(new JLabel("  "));
            infosJ4.add(nbAncienJ4);
            infosJ4.add(nbCCJ4);
            infosJ4.add(new JLabel("  "));
            infosJ4.add(scoreJ4);
            infosJoueur.add(infosJ4);
        }

        changementCouleur();
        infosJoueur.setBorder(BorderFactory.createTitledBorder("Renseignement"));
    }

    public void MAJinterfaceEchange(){
        int n = ( (manJeu.getTour())%((manJeu.getJoueurs()).size()) );

        for (int i = 0; i < interfaceEchange.getComponentCount(); i++){
            if (i == ((manJeu.getTour())%((manJeu.getJoueurs()).size())) ){
                (interfaceEchange.getComponent(i)).setVisible(false);
            }
            else{
                (interfaceEchange.getComponent(i)).setVisible(true);
            }
        }
    }

    public void TableauDechange(){
        interfaceEchange.removeAll();

        interfaceEchange.add((Joueurs.get((0))).getNom(), EJ1);
        interfaceEchange.add((Joueurs.get((1))).getNom(), EJ2);
        interfaceEchange.add((Joueurs.get((2))).getNom(), EJ3);
        if (Tour%Joueurs.size() != 3) {
            interfaceEchange.add((Joueurs.get((3))).getNom(), EJ4);
        }
        interfaceEchange.add("Banque", Banque);
        interfaceEchange.setOpaque(true);

        MAJinterfaceEchange();
    }

    public void MiseAJour(ManagerJeu _manJeu){
        manJeu = _manJeu;
        Joueurs = _manJeu.getJoueurs();
        Tour = _manJeu.getTour();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MAJinstanciationVariableJoueurs();

        MAJinterfaceEchange();

    }

    public void changementCouleur(){
        int rang = Tour%Joueurs.size();

        infosJ1.setBackground(Color.WHITE);
        infosJ2.setBackground(Color.WHITE);
        infosJ3.setBackground(Color.WHITE);
        infosJ4.setBackground(Color.WHITE);
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
