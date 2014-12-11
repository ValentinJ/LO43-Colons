package fenetreGraphique;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranBas extends JPanel {
    public Graphics g;
    public String message;

    public EcranBas(String msg){
        add(new JLabel(msg));
        setBackground(Color.white);
        setBorder(new EmptyBorder(5, 5, 0, 5));
    }
}
