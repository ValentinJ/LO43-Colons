package fenetreGraphique;

import sun.awt.VerticalBagLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Guillaume on 21/11/2014.
 */
public class EcranBas extends JPanel {
    public String message;
    public JLabel information;
    public FenetrePrincipale frame;
    int i =0;

    public EcranBas(String msg, FenetrePrincipale _frame){
        message = msg;
        frame = _frame;
        information = new JLabel(message);

        setLayout(new GridBagLayout());
        add(information, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 0), 0, 0));
        setI(i+1);
        setBackground(Color.white);
        setBorder(new EmptyBorder(5, 5, 0, 5));
    }

    public void setMessage(String n){
        message = n;
        information = new JLabel(message);
        add(information, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 0), 0, 0));
        setI(i+1);
        frame.validate();
    }

    public void delete(){
        removeAll();
        setI(0);
    }

    public void setI(int k){
        i =k;
    }
}
