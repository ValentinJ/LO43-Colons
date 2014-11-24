package fenetreGraphique;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranBas extends JPanel {
    public Graphics g;
    public String message;

    public EcranBas(String msg){
        message = msg;
        paintComponent(message);
    }

    public void paintComponent(String msg){
        Font font = new Font("Courier", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString(msg, 10, 40);
    }
}
