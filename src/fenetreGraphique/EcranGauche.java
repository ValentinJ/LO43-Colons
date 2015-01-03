package fenetreGraphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Guillaume on 09/12/2014.
 */
public class EcranGauche extends JPanel implements ActionListener{
    // bouton acheter carte dev
    public JButton achatCarteDev;

    // bouton fin de tour
    public JButton finDeTour;

    // rappel construction
    public JPanel construction;
    public JButton UV1;
    public JLabel detailsUV1;
    public JButton UV2;
    public JLabel detailsUV2;
    public JButton CC;
    public JLabel detailsCC;

    // jouer carte dev (*4)
    public JPanel jouerCarte;
    public JButton Ancien;
    public JButton CCC;
    public JButton Decouverte;
    public JButton Monopole;

    public Image imgBierre;
    public Image imgSommeil;
    public Image imgCafe;
    public Image imgCours;
    public Image imgNourriture;

    public EcranGauche() {
        setLayout(new GridLayout(4, 1));
        achatCarteDev = new JButton("Achat carte dév");
        finDeTour = new JButton("Fin de tour");
        achatCarteDev.addActionListener(this);
        finDeTour.addActionListener(this);

        //TODO mettre les images
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

        UV1        = new JButton("UV1");
        //detailsUV1 = new JLabel("details ressources necessaire");
        detailsUV1 = new JLabel(" = 1 " + new ImageIcon(imgBierre){{setOpaque(false);}}
                                + " 1 " + new ImageIcon(imgCafe){{setOpaque(false);}}
                                + " 1 " + new ImageIcon(imgCours){{setOpaque(false);}}
                                + " 1 " + new ImageIcon(imgNourriture){{setOpaque(false);}} ) ;
        UV2        = new JButton("UV2");
        detailsUV2 = new JLabel("details ressources necessaire");
        CC         = new JButton("CC");
        detailsCC  = new JLabel("details ressources necessaire");
        UV1.addActionListener(this);
        UV2.addActionListener(this);
        CC.addActionListener(this);

        construction = new JPanel();
        construction.setBorder(new EmptyBorder(5, 0, 0, 5));
        construction.setBorder(BorderFactory.createTitledBorder("Constructions"));
        construction.setLayout(new GridLayout(3, 2));
        construction.add(UV1);
        construction.add(detailsUV1);
        construction.add(UV2);
        construction.add(detailsUV2);
        construction.add(CC);
        construction.add(detailsCC);


        Decouverte = new JButton("Decouverte");
        Monopole   = new JButton("Monopole");
        Ancien     = new JButton("Ancien");
        CCC        = new JButton("CCC");
        Decouverte.addActionListener(this);
        Monopole.addActionListener(this);
        Ancien.addActionListener(this);
        CCC.addActionListener(this);

        jouerCarte = new JPanel();
        jouerCarte.setBorder(new EmptyBorder(5, 0, 0, 5));
        jouerCarte.setBorder(BorderFactory.createTitledBorder("Jouer carte"));
        jouerCarte.setLayout(new GridLayout(4, 1));
        jouerCarte.add(Decouverte);
        jouerCarte.add(Monopole);
        jouerCarte.add(Ancien);
        jouerCarte.add(CCC);


        setBorder(new EmptyBorder(5, 5, 0, 5));
        add(achatCarteDev);
        add(finDeTour);
        add(jouerCarte);
        add(construction);
    }

    //TODO visibilité des boutons


    //TODO fonctionnalité des boutons
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == UV1) {
            System.out.println("EcranGauche.java : UV1");
        }
        if (e.getSource() == UV2) {
            System.out.println("EcranGauche.java : UV2");
        }
        if (e.getSource() == CC) {
            System.out.println("EcranGauche.java : CC");
        }
        if (e.getSource() == Ancien) {
            System.out.println("EcranGauche.java : Ancien");
        }
        if (e.getSource() == Decouverte) {
            System.out.println("EcranGauche.java : Decouverte");
        }
        if (e.getSource() == CCC) {
            System.out.println("EcranGauche.java : CCC");
        }
        if (e.getSource() == Monopole) {
            System.out.println("EcranGauche.java : Monopole");
        }
        if (e.getSource() == achatCarteDev) {
            System.out.println("EcranGauche.java : achatCarteDev");
        }
        if (e.getSource() == finDeTour) {
            System.out.println("EcranGauche.java : finDeTour");
        }
    }
}
