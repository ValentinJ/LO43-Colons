package fenetreGraphique;

import colonsUTBM.ManagerJeu;
import colonsUTBM.UV2;

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
    public FenetrePrincipale frame; // pointeur sur ma fenetre appelant cette classe
    public ManagerJeu manJeu;

    // bouton acheter carte dev
    public JButton achatCarteDev;

    // bouton fin de tour
    public JButton finDeTour;

    // rappel construction
    public JPanel construction;
    public JButton UV1;
    public JPanel detailsUV1;
    public JButton uv2;
    public JPanel detailsUV2;
    public JButton CC;
    public JPanel detailsCC;

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

    public JPanel faceDesDes;
    public Image imgDes1;
    public Image imgDes2;

    //todo test thread
    Thread t;



    public EcranGauche(ManagerJeu _manJeu, FenetrePrincipale _frame) {
        frame = _frame;
        manJeu = _manJeu;
        setLayout(new GridLayout(5, 1));
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

        affichageDes();

        UV1        = new JButton("UV1");
        //detailsUV1 = new JLabel("details ressources necessaire");
        detailsUV1 = new JPanel(new GridLayout(1,8));
        detailsUV1.add(new JLabel("="));
        detailsUV1.add(new JLabel(new ImageIcon(imgBierre)){{setOpaque(false);}});
        detailsUV1.add(new JLabel("+"));
        detailsUV1.add(new JLabel(new ImageIcon(imgCafe)){{setOpaque(false);}});
        detailsUV1.add(new JLabel("+"));
        detailsUV1.add(new JLabel(new ImageIcon(imgCours)){{setOpaque(false);}});
        detailsUV1.add(new JLabel("+"));
        detailsUV1.add(new JLabel(new ImageIcon(imgNourriture)){{setOpaque(false);}});
        uv2 = new JButton("uv2");
        detailsUV2 = new JPanel(new GridLayout(1,4));
        detailsUV2.add(new JLabel("= 3"));
        detailsUV2.add(new JLabel(new ImageIcon(imgSommeil)){{setOpaque(false);}});
        detailsUV2.add(new JLabel("+ 2"));
        detailsUV2.add(new JLabel(new ImageIcon(imgCours)){{setOpaque(false);}});
        CC         = new JButton("CC");
        detailsCC  = new JPanel(new GridLayout(1,4));
        detailsCC.add(new JLabel("="));
        detailsCC.add(new JLabel(new ImageIcon(imgBierre)){{setOpaque(false);}});
        detailsCC.add(new JLabel("+"));
        detailsCC.add(new JLabel(new ImageIcon(imgCafe)) {{
            setOpaque(false);
        }});

        UV1.addActionListener(this);
        uv2.addActionListener(this);
        CC.addActionListener(this);

        construction = new JPanel();
        construction.setBorder(new EmptyBorder(5, 0, 0, 5));
        construction.setBorder(BorderFactory.createTitledBorder("Constructions"));
        construction.setLayout(new GridLayout(3, 2));
        construction.add(UV1);
        construction.add(detailsUV1);
        construction.add(uv2);
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
        add(faceDesDes);
        add(jouerCarte);
        add(construction);
    }

    //TODO visibilité des boutons


    //TODO fonctionnalité des boutons
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == UV1) {
            System.out.println("EcranGauche.java : UV1");
            if(t == null || t.getState()== Thread.State.TERMINATED) {
                t = new Thread("exemple") {
                    @Override
                    public void run() {
                        manJeu.getJoueurCourrant().getUvs().add(manJeu.getTerrain().InitConstructionUV1(manJeu.getJoueurCourrant()));
                        manJeu.getTerrain().majCSS();
                    }
                };
                t.start();
            }
        }


        if (e.getSource() == uv2) {
            System.out.println("EcranGauche.java : uv2");
            if (t == null || t.getState() == Thread.State.TERMINATED) {
                    t = new Thread("exemple") {
                        @Override
                        public void run() {
                            manJeu.getTerrain().ClickConstructionUV2(manJeu.getJoueurCourrant());
                            manJeu.getTerrain().majCSS();
                        }
                    };
                    t.start();
            }
        }


        if (e.getSource() == CC) {
            System.out.println("EcranGauche.java : CC");
            if (t == null || t.getState() == Thread.State.TERMINATED) {
                t = new Thread("exemple") {
                    @Override
                    public void run() {
                        manJeu.getTerrain().ClickConstructionControleContinus(manJeu.getJoueurCourrant());
                        manJeu.getTerrain().majCSS();
                    }
                };
                t.start();
            }
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
            if(t == null || t.getState()== Thread.State.TERMINATED) {
                System.out.println("EcranGauche.java : finDeTour");
                manJeu.finDeTour();
                frame.miseAJour();  // appel mise a jour de frame principale
            }
        }

        frame.miseAJour();
    }

    // TODO a instancier
    public void miseAJour(ManagerJeu _manJeu){
        manJeu = _manJeu;
        affichageDes();

        // parcours carte dispo du joueur en cour

        // bloque les boutons
    }

    public void affichageDes(){
        faceDesDes = new JPanel(new GridLayout(1,2));

        try {
            imgDes1 = ImageIO.read(new File(System.getProperty("user.dir") +"/img/" + manJeu.getDes().getImgV1()));
        } catch (IOException e) {e.printStackTrace();}
        try {
            imgDes2 = ImageIO.read(new File(System.getProperty("user.dir") +"/img/" + manJeu.getDes().getImgV2()));
        } catch (IOException e) {e.printStackTrace();}

        System.out.println("des 1 :" + manJeu.getDes().getImgV1() + " des2 : " + manJeu.getDes().getImgV2() );

        ImageIcon imgIcon1 = new ImageIcon(imgDes1){{setOpaque(false);}};

        ImageIcon imgIcon2 = new ImageIcon(imgDes2){{setOpaque(false);}};
        faceDesDes.add(new JLabel( (imgIcon1.getImage()).getScaledInstance(20, 20, Image.SCALE_DEFAULT) ) ) );
        faceDesDes.add(new JLabel( (imgIcon2.getImage()).getScaledInstance(20, 20, Image.SCALE_DEFAULT) ) ) );
    }
}
