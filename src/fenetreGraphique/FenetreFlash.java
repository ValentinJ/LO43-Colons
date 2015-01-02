package fenetreGraphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Guillaume on 01/01/2015.
 */
public class FenetreFlash extends JFrame {

    public Image image;

    public FenetreFlash(){
        super();

        // on recherche image
        try {
            image = ImageIO.read(new File(System.getProperty("user.dir")+"/img/Groupe.png")); //+"\\img\\Groupe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage img = (BufferedImage) image;

        // on fait la fenetre
        add(new JLabel(new ImageIcon(image)){
            {
                setOpaque(false);
            }
        });
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(img.getWidth(),img.getHeight());
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
