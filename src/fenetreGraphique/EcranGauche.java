package fenetreGraphique;

import colonsUTBM.Joueur;
import colonsUTBM.ManagerJeu;
import colonsUTBM.UV1;
import colonsUTBM.UV2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
    public JLabel nbAncien;
    public JButton CCC;
    public JLabel nbCCC;
    public JButton Decouverte;
    public JLabel nbDecouverte;
    public JButton Monopole;
    public JLabel nbMonopole;
    public JLabel nbPointVictoire;

    public Image imgBierre;
    public Image imgSommeil;
    public Image imgCafe;
    public Image imgCours;
    public Image imgNourriture;

    public JPanel faceDesDes;
    public Image imgDes1;
    public Image imgDes2;
    protected JLabel des1;
    protected JLabel des2;
    protected GridLayout gridLayoutDes;


    public EcranBas eB;

    Thread t;

    public EcranGauche(ManagerJeu _manJeu, FenetrePrincipale _frame, EcranBas _eB) {
        frame = _frame;
        eB = _eB;
        manJeu = _manJeu;
        setLayout(new GridLayout(5, 1));
        achatCarteDev = new JButton("Achat carte dév");
        finDeTour = new JButton("Fin de tour");
        achatCarteDev.addActionListener(this);
        finDeTour.addActionListener(this);

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

        affichageConstruction();
        affichageJouerCarte();

        gridLayoutDes = new GridLayout(1,2);
        faceDesDes = new JPanel(gridLayoutDes);
        des1 = new JLabel();
        des2 = new JLabel();
        faceDesDes.add(des1);
        faceDesDes.add(des2);
        affichageDes();


        add(achatCarteDev);
        add(finDeTour);
        add(faceDesDes);
        add(jouerCarte);
        add(construction);

        miseAJour(manJeu);
        validate();
    }

    //TODO visibilité des boutons
    public void majBouton(){
        Joueur jCourant = manJeu.getJoueurCourrant();
        if(jCourant.verifierAchatCarteDev()){
            achatCarteDev.setEnabled(true);
        }
        else
            achatCarteDev.setEnabled(false);

        if(jCourant.verifierAchatControleContinu()){
            CC.setEnabled(true);
        }
        else
            CC.setEnabled(false);

        if(jCourant.verifierAchatUV2()){
            uv2.setEnabled(true);
        }
        else
            uv2.setEnabled(false);

        if(jCourant.verifierAchatUV1()){
            UV1.setEnabled(true);
        }
        else
            UV1.setEnabled(false);

        if(!manJeu.isActionEnCours()){
            finDeTour.setEnabled(true);
        }
        else
            finDeTour.setEnabled(false);

        if(jCourant.verifierAchatCarteDev()){
            achatCarteDev.setEnabled(true);
        }
        else
            achatCarteDev.setEnabled(false);

        int tab[];
        tab = jCourant.getMonopole();
        if(tab[0]-tab[1]>0){
            Monopole.setEnabled(true);
        }
        else
            Monopole.setEnabled(false);

        tab = jCourant.getCCC();
        if(tab[0]-tab[1]>0){
            CCC.setEnabled(true);
        }
        else
            CCC.setEnabled(false);

        tab = jCourant.getDecouverte();
        if(tab[0]-tab[1]>0){
            Decouverte.setEnabled(true);
        }
        else
            Decouverte.setEnabled(false);

        tab = jCourant.getAncien();
        if(tab[0]-tab[1]>0){
            Ancien.setEnabled(true);
        }
        else
            Ancien.setEnabled(false);
    }

    //TODO fonctionnalité des boutons
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == UV1) {
            eB.setMessage("Selectionner un noeud n'ayant aucun voisin pour construire une UV1.");
            if(t == null || t.getState()== Thread.State.TERMINATED) {
                t = new Thread("exemple") {
                    @Override
                    public void run() {
                        manJeu.getJoueurCourrant().construireUV1(manJeu.getTerrain(),manJeu.getPilesRessources());
                        manJeu.getF().miseAJour();
                        eB.setMessage("L'UV1 a été placée avec succès !");
                    }
                };
                t.start();
            }
        }


        if (e.getSource() == uv2) {
            eB.setMessage("Selectionner une UV1 que vous souhaitez transformer en UV2.");
            if (t == null || t.getState() == Thread.State.TERMINATED) {
                    t = new Thread("exemple") {
                        @Override
                        public void run() {
                            manJeu.getJoueurCourrant().transformerUV2(manJeu.getTerrain(),manJeu.getPilesRessources());
                            manJeu.getF().miseAJour();
                            eB.setMessage("L'UV1 a été modifiée en UV2 avec succès !");
                        }
                    };
                    t.start();
            }
        }


        if (e.getSource() == CC) {
            eB.setMessage("Selectionner un noeud vous appartenant puis un second noeud voisin de celui.");
            if (t == null || t.getState() == Thread.State.TERMINATED) {
                t = new Thread("exemple") {
                    @Override
                    public void run() {
                        manJeu.getJoueurCourrant().construireCC(manJeu.getTerrain(), manJeu.getPilesRessources());
                        manJeu.getF().miseAJour();
                        eB.setMessage("Controle continus placé avec succès !");
                    }
                };
                t.start();
            }
        }
        if (e.getSource() == Ancien) {
            eB.setMessage("Selectionner une tuile où placer le binome glandeur");
        }
        //TODO ici
        if (e.getSource() == Decouverte) {
            System.out.println("EcranGauche.java : Decouverte");
        }
        if (e.getSource() == CCC) {
            eB.setMessage("Selectionner un noeud vous appartenant puis un second noeud voisin de celui.");
            eB.setMessage("Repetez l'opération une seconde fois.");
            if (t == null || t.getState() == Thread.State.TERMINATED) {
                t = new Thread("exemple") {
                    @Override
                    public void run() {
                        manJeu.getJoueurCourrant().joueurCarteCC(manJeu.getTerrain());
                        manJeu.getF().miseAJour();
                        eB.setMessage("Controle continus placé avec succès !");
                    }
                };
                t.start();
            }
        }
        //TODO ici aussi
        if (e.getSource() == Monopole) {
            System.out.println("EcranGauche.java : Monopole");
        }
        if (e.getSource() == achatCarteDev) {
            manJeu.getJoueurCourrant().achatCarteDev(manJeu.getPilesDeveloppement(), manJeu.getPilesRessources());
            manJeu.getF().miseAJour();
            // TODO pb ici carte dev du manager vide !
            eB.setMessage("Vous avez obtenu une carte " + manJeu.getJoueurCourrant().getMainDeveloppement().get(manJeu.getJoueurCourrant().getMainDeveloppement().size() - 1).getNom());
        }
        if (e.getSource() == finDeTour) {
            if(t == null || t.getState()== Thread.State.TERMINATED) {
                eB.delete();
                //eB.removeAll();
                manJeu.finDeTour();
                frame.miseAJour();  // appel mise a jour de frame principale
                eB.setMessage(manJeu.msgGenerationR());
                eB.setMessage("Début du tour de " + manJeu.getJoueurCourrant().getNom());
            }
            else{
                eB.setMessage("Vous ne pouvez finir votre tour, vous n'avez pas terminer l'action précédemment déclanchée");
            }
        }

        //frame.miseAJour();
    }

    // TODO a instancier
    public void miseAJour(ManagerJeu _manJeu){
        manJeu = _manJeu;

        //removeAll();
        //repaint();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        affichageDes();
        MAJinfoNbrJouerCarte();
        majBouton();
        /*
        setBorder(new EmptyBorder(5, 5, 0, 5));
        add(achatCarteDev);
        add(finDeTour);
        add(faceDesDes);
        add(jouerCarte);
        add(construction);
        */
        // parcours carte dispo du joueur en cour

        // bloque les boutons
    }

    public static Image scaleImage(Image source, int width, int height) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) img.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(source, 0, 0, width, height, null);
        g.dispose();
        return img;
    }



    public void affichageDes(){
        try {
            imgDes1 = ImageIO.read(new File(System.getProperty("user.dir") +"/img/" + manJeu.getDes().getImgV1()));
        } catch (IOException e) {e.printStackTrace();}
        try {
            imgDes2 = ImageIO.read(new File(System.getProperty("user.dir") +"/img/" + manJeu.getDes().getImgV2()));
        } catch (IOException e) {e.printStackTrace();}

        System.out.println("des 1 :" + manJeu.getDes().getImgV1() + " des2 : " + manJeu.getDes().getImgV2() );
        imgDes1 = scaleImage(imgDes1,75,75);
        imgDes2 = scaleImage(imgDes2,75,75);
        ImageIcon imgIcon1 = new ImageIcon(imgDes1){{setOpaque(false);}};
        ImageIcon imgIcon2 = new ImageIcon(imgDes2){{setOpaque(false);}};
        des1.setIcon(imgIcon1);
        des2.setIcon(imgIcon2);
    }

    public void affichageConstruction(){
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
    }

    public void affichageJouerCarte(){
        int tab[];
        Decouverte = new JButton("Decouverte");
        Monopole   = new JButton("Monopole");
        Ancien     = new JButton("Ancien");
        CCC        = new JButton("CCC");
        Decouverte.addActionListener(this);
        Monopole.addActionListener(this);
        Ancien.addActionListener(this);
        CCC.addActionListener(this);

        tab = (manJeu.getJoueurCourrant().getAncien());
        nbAncien = new JLabel( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getDecouverte());
        nbDecouverte = new JLabel( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getMonopole());
        nbMonopole = new JLabel( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getCCC());
        nbCCC = new JLabel( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getPointVictoire());
        nbPointVictoire = new JLabel(Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) + " carte(s) point de victoire");


        /*
        jouerCarte = new JPanel(new GridBagLayout());
        jouerCarte.setBorder(new EmptyBorder(5, 0, 0, 5));
        jouerCarte.setBorder(BorderFactory.createTitledBorder("Jouer carte"));
        jouerCarte.add(Decouverte,   new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(nbDecouverte, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(Monopole,     new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(nbMonopole,   new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(Ancien,       new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(nbAncien,     new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(CCC,          new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(nbCCC,        new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), 0, 0));
        jouerCarte.add(nbPointVictoire, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
*/
        jouerCarte = new JPanel(new GridLayout(5,2));
        jouerCarte.setBorder(new EmptyBorder(5, 0, 0, 5));
        jouerCarte.setBorder(BorderFactory.createTitledBorder("Jouer carte"));
        jouerCarte.add(Decouverte);
        jouerCarte.add(nbDecouverte);
        jouerCarte.add(Monopole);
        jouerCarte.add(nbMonopole);
        jouerCarte.add(Ancien);
        jouerCarte.add(nbAncien);
        jouerCarte.add(CCC);
        jouerCarte.add(nbCCC);
        jouerCarte.add(nbPointVictoire);
    }

    public void MAJinfoNbrJouerCarte(){
        int tab[];
        tab = (manJeu.getJoueurCourrant().getAncien());
        nbAncien.setText(Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getDecouverte());
        nbDecouverte.setText( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getMonopole());
        nbMonopole.setText( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getCCC());
        nbCCC.setText( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) );
        tab = (manJeu.getJoueurCourrant().getPointVictoire());
        nbPointVictoire.setText( Integer.toString( tab[0])+"("+Integer.toString( tab[1])+") - "+Integer.toString( tab[2]) + " carte(s) point de victoire");
    }


}
