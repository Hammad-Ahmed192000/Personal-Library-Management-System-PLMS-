package finalProject;

import javax.swing.*;
import java.awt.*;

public class Background
{
    JLabel label ;
    ImageIcon icon ;
    Background()
    {

        icon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\pic1.jpg") ;
        label = new JLabel(icon) ;
        label.setBounds(200 , 200 , 200 , 200);

        /*
        frame.add(label);
        frame.setLayout(null);
        frame.setSize(500 , 500);
        frame.setVisible(true) ;
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          */
    }

}