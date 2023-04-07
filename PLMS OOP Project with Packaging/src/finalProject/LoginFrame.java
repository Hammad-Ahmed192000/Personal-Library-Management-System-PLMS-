package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame extends Frame
{
    JLabel background ;
    ImageIcon icon ;
    LoginFrame currentFrame = this;
    JLabel lN , lP , l1 ;
    JTextField tf = new JTextField(20);
    JButton back = new JButton("BACK"), submit = new JButton("SUBMIT"),next = new JButton("NEXT");
    final JPasswordField pF = new JPasswordField(20);
    JSeparator separator = new JSeparator() ;
    String name, ID ,password;
    boolean done = false;


    public LoginFrame()
    {

        setLayout(null);
        lN = new JLabel("Name :",Label.LEFT);
        lP = new JLabel("Password :",Label.LEFT);
        l1 = new JLabel("LOGIN ACCOUNT");

        // this code is for setting the BackGround.
        icon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\pic2.jpg") ;
        JLabel background = new JLabel(icon);
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);


        l1.setBounds(480 ,50,500,50);
        tf.setBounds(630 ,300,250,40);
        pF.setBounds(630 ,400,250,40);
        lN.setBounds(500,300,80,50);
        lP.setBounds(500,370,110,110);
        back.setBounds(350,600,120,50);
        submit.setBounds(650,600,120,50);
        next.setBounds(900,600,120,50);
        separator.setBounds(0, 120 ,1350,50 );


        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);

        back.setBorder(border);
        submit.setBorder(border);
        next.setBorder(border);


        l1.setForeground(Color.WHITE);
        lN.setForeground(Color.WHITE);
        lP.setForeground(Color.WHITE);


        back.setBackground(Color.BLACK);
        submit.setBackground(Color.BLACK);
        next.setBackground(Color.BLACK);

        back.setForeground(Color.WHITE);
        submit.setForeground(Color.WHITE);
        next.setForeground(Color.WHITE);


        l1.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        lN.setFont(new Font("Aerial",Font.BOLD,19));
        lP.setFont(new Font("Aerial",Font.BOLD,19));
        tf.setFont(new Font("Aerial",Font.PLAIN,17));
        pF.setFont(new Font("Aerial",Font.PLAIN,17));
        back.setFont(new Font("Aerial",Font.BOLD,14));
        submit.setFont(new Font("Aerial",Font.BOLD,14));
        next.setFont(new Font("Aerial",Font.BOLD,14));


        background.add(l1);
        background.add(separator) ;
        background.add(lN);
        background.add(lP);
        background.add(tf);
        background.add(pF);
        background.add(back);
        background.add(submit);
        background.add(next);

        add(background) ;


        back.addActionListener(new actions());
        submit.addActionListener(new actions());
        next.addActionListener(new actions());
        addWindowListener(new MyWindow());



        setSize(1280,850);
        setVisible(true);
        setLocationRelativeTo(null);

    }
    private class actions implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==back)
            {
                currentFrame.setVisible(false);
                new project().setVisible(true);
            }

            else if(ae.getSource()==next)
            {
                try
                {
                    name = tf.getText();
                    password = new String(pF.getPassword());
                    if(name.length()==0 || password.length()==0)
                    {
                        throw new EmptyException();
                    }

                    for(int i=0;i<name.length();i++)
                    {
                        if((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z') || name.charAt(i)==' ')
                        {

                        }
                        else
                        {
                            throw new NameException();
                        }
                    }

                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }

                    JOptionPane.showMessageDialog(null , "Thank You for Loging In :)");
                    currentFrame.setVisible(false);
                    new showMenu1().setVisible(true);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"This is in Next Button");
                }
            }

            else
            {
                try
                {
                    name = tf.getText();
                    password = new String(pF.getPassword());

                    if(name.length()==0 || password.length()==0)
                    {
                        throw new EmptyException();
                    }

                    for(int i=0;i<name.length();i++)
                    {
                        if((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z') || name.charAt(i)==' ')
                        {

                        }
                        else
                        {
                            throw new NameException();
                        }
                    }

                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }

                    JOptionPane.showMessageDialog(null , "Thank You for Loging In :)");
                    currentFrame.setVisible(false);
                    new showMenu1().setVisible(true);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"This is in Submit button.");
                }
            }
        }
    }
}

