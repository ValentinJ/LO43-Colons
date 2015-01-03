package fenetreGraphique;

import colonsUTBM.Joueur;
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

    int Tour;

    public EcranDroit(ArrayList<Joueur> j, int t) throws IOException {
        Joueurs = j;
        Tour = t;

        setLayout(new GridLayout(2,1));

        recap = new JPanel(new VerticalBagLayout());

        // partie le tableau de maniere dynamique
        recapInfos = new JPanel(new GridLayout(1,2));

        imgBierre     = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteBiere.png"));
        imgSommeil    = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteSommeil.png"));
        imgCafe       = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteCafe.png"));
        imgCours      = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteCours.png"));
        imgNourriture = ImageIO.read(new File(System.getProperty("user.dir") +"/img/CarteNourriture.png"));

        enteteVertical();
        recapInfosJoueurs();

        recap.add(infosJoueur);

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
        enteteV.add(new JLabel("UV2"));
        enteteV.add(new JLabel("  "));
        enteteV.add(new JLabel("Ancien"));
        enteteV.add(new JLabel("C C"));
        enteteV.add(new JLabel("  "));
        enteteV.add(new JLabel("Score"));
    }

    public void recapInfosJoueurs(){
        infosJoueur = new JPanel(new GridLayout(1, Joueurs.size()+1));

        infosJoueur.add(enteteV);

        infosJ1 = new JPanel(new GridLayout(14,1));
        infosJ1.add(new JLabel((Joueurs.get(0)).getNom()));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.BIERE)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.CAFE)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.COURS)).getNombre()) ));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) ));
        infosJ1.add(new JLabel("  "));
        infosJ1.add(new JLabel(Integer.toString(((Joueurs.get(0)).getUV1()))));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getUV2()))));
        infosJ1.add(new JLabel("  "));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getAncien()))));
        infosJ1.add(new JLabel(Integer.toString( ((Joueurs.get(0)).getCC()))));
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
        infosJ2.add(new JLabel(Integer.toString(((Joueurs.get(1)).getUV1()))));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getUV2()))));
        infosJ2.add(new JLabel("  "));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getAncien()))));
        infosJ2.add(new JLabel(Integer.toString( ((Joueurs.get(1)).getCC()))));
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
        infosJ3.add(new JLabel(Integer.toString(((Joueurs.get(2)).getUV1()))));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getUV2()))));
        infosJ3.add(new JLabel("  "));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getAncien()))));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getCC()))));
        infosJ3.add(new JLabel("  "));
        infosJ3.add(new JLabel(Integer.toString( ((Joueurs.get(2)).getScore()))));
        infosJoueur.add(infosJ3);

        if  (Joueurs.size() > 3){
            infosJ4 = new JPanel(new GridLayout(14,1));
            infosJ4.add(new JLabel((Joueurs.get(3)).getNom()));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.BIERE)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.SOMMEIL)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.CAFE)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.COURS)).getNombre()) ));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getMainRessource(TypeRessource.NOURRITURE)).getNombre()) ));
            infosJ4.add(new JLabel("  "));
            infosJ4.add(new JLabel(Integer.toString(((Joueurs.get(3)).getUV1()))));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getUV2()))));
            infosJ4.add(new JLabel("  "));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getAncien()))));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getCC()))));
            infosJ4.add(new JLabel("  "));
            infosJ4.add(new JLabel(Integer.toString( ((Joueurs.get(3)).getScore()))));
            infosJoueur.add(infosJ4);
        }
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

    public void MiseAJour(ArrayList<Joueur> _j, int _t){
        Joueurs = _j;
        Tour = _t;

        TableauDechange();

        // tableau des ressources dans les mains

        // des differentes possession : carte / UV* / UV** / Controle Continue / ...



        validate();
    }/*

    //TODO faire la coloration
    public void changementCouleur(int t){
        int rang = t%Joueurs.size();

        recapInfosJoueurs();

        switch (rang){
            case 0: E
            case 1:
            case 2:
            case 3:
        }

        public void activeCouleur(){
            if (c.equals("VERT")) {
                setBackground(Color.green);
            }
            if (c.equals("BLEU")) {
                setBackground(Color.blue);
            }
            if (c.equals("ROUGE")) {
                setBackground(Color.red);
            }
            if (c.equals("JAUNE")) {
                setBackground(Color.yellow);
            }
        }
    }*/
}
