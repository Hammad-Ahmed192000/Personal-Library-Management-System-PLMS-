package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class AccountFrame extends Frame
{

    AccountFrame currentFrame = this;

    JLabel lN , lI , lP ,l1;
    JTextField tf = new JTextField(20);
    JTextField tf1 = new JTextField(20);
    JButton back = new JButton("BACK"), submit = new JButton("SUBMIT"),next = new JButton("NEXT");
    final JPasswordField pF = new JPasswordField(20);
    JSeparator separator = new JSeparator() ;
    String name, ID ,password;
    JLabel background ;
    ImageIcon icon ;

    public AccountFrame()
    {

        setLayout(null);
        l1 = new JLabel("NEW ACCOUNT");
        lN = new JLabel("Name :",Label.LEFT);
        lI = new JLabel("ID :",Label.RIGHT);
        lP = new JLabel("Password :",Label.LEFT);

        // this code is for setting the BackGround.
        icon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\pic2.jpg") ;
        background = new JLabel(icon) ;
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);

        background.add(l1);
        background.add(separator) ;
        background.add(lN);
        background.add(lI);
        background.add(lP);
        background.add(tf);
        background.add(tf1);
        background.add(pF);
        background.add(back);
        background.add(submit);
        background.add(next);

        add(background) ;


        back.addActionListener(new actions());
        submit.addActionListener(new actions());
        next.addActionListener(new actions());
        addWindowListener(new MyWindow());

        l1.setBounds(480 ,50,400,50);
        tf.setBounds(600 ,250,250,40);
        tf1.setBounds(600 ,350,250,40);
        pF.setBounds(600 ,465,250,40);
        lN.setBounds(475,250,80,50);
        lI.setBounds(485,350,80,50);
        lP.setBounds(475,430,110,110);
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
        lI.setForeground(Color.WHITE);
        lP.setForeground(Color.WHITE);


        back.setBackground(Color.BLACK);
        submit.setBackground(Color.BLACK);
        next.setBackground(Color.BLACK);

        back.setForeground(Color.WHITE);
        submit.setForeground(Color.WHITE);
        next.setForeground(Color.WHITE);

        l1.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        lN.setFont(new Font("Aerial",Font.BOLD,19));
        lI.setFont(new Font("Aerial",Font.BOLD,19));
        lP.setFont(new Font("Aerial",Font.BOLD,19));
        tf.setFont(new Font("Aerial",Font.PLAIN,17));
        tf1.setFont(new Font("Aerial",Font.PLAIN,17));
        pF.setFont(new Font("Aerial",Font.PLAIN,17));
        back.setFont(new Font("Aerial",Font.BOLD,14));
        submit.setFont(new Font("Aerial",Font.BOLD,14));
        next.setFont(new Font("Aerial",Font.BOLD,14));

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
                    ID = tf1.getText();
                    password = new String(pF.getPassword());

                    if(name.length()==0 || ID.length()==0 || password.length()==0)
                    {
                        throw new EmptyException();
                    }

                    for(int i = 0 ; i < name.length() ; i++)
                    {
                        if((name.charAt(i)<='A' && name.charAt(i)>='Z') || (name.charAt(i)<='a' && name.charAt(i) >= 'z'))
                        {
                            // this exception might have Problem
                            // the problem is that when we give space between our Full name
                            // This space is also a CHARACTER so, we also add space  character in if() condition
                            // but this might not working.
                            throw new NameException();
                        }
                    }

                    for(int i = 0 ; i < ID.length() ; i++)
                    {
                        if((ID.charAt(i) >= 'A' && ID.charAt(i)<='Z') || (ID.charAt(i)>='a' && ID.charAt(i)<='z') || (ID.charAt(i)>='0' && ID.charAt(i)<='9') || (ID.charAt(i) == '-') || (ID.charAt(i) =='_') || (ID.charAt(i) =='@') || (ID.charAt(i) =='.'))
                        {
                            // here is the problem with '.' and '@'.
                            // added but still not working.
                        }
                        else if((ID.charAt(0)=='-') || (ID.charAt(0)=='_') || (ID.charAt(ID.length()-1)=='-') || (ID.charAt(ID.length()-1)=='_'))
                        {
                            // function of this Exception here.
                            throw new IDException();
                        }
                        else
                        {
                            throw new IDException();
                        }
                    }

                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }
                    JOptionPane.showMessageDialog(null , "Next Button reached you to the Menu");
                    currentFrame.setVisible(false);
                    new showMenu().setVisible(true);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            // this logic is for Submit button.
            else
            {
                try
                {
                    name = tf.getText();
                    ID = tf1.getText();
                    password = new String(pF.getPassword());

                    if(name.length()==0 || ID.length()==0 || password.length()==0)
                    {
                        throw new EmptyException();
                    }

                    for(int i = 0 ; i < name.length() ; i++)
                    {
                        if((name.charAt(i)<='A' && name.charAt(i)>='Z') || (name.charAt(i)<='a' && name.charAt(i)>='z'))
                        {
                            throw new NameException();
                        }
                    }

                    for(int i=0;i<ID.length();i++)
                    {
                        if((ID.charAt(i)>='A' && ID.charAt(i)<='Z') || (ID.charAt(i)>='a' && ID.charAt(i)<='z') || (ID.charAt(i)>='0' && ID.charAt(i)<='9') || (ID.charAt(i) == '-') || (ID.charAt(i) =='_'))
                        {

                        }
                        else if((ID.charAt(0)=='-') || (ID.charAt(0)=='_') || (ID.charAt(ID.length()-1)=='-') || (ID.charAt(ID.length()-1)=='_'))
                        {
                            throw new IDException();
                        }
                        else
                        {
                            throw new IDException();
                        }
                    }

                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }

                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");

                        // here plms is MYSQL database name, root is username and maadi192000 is password

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plms","root","maadi192000");

                        /*
                            This code is for Inserting record in MySql DataBase
                        */
                        String query = "INSERT INTO `plms`.`accounts` (`personName`, `personalID`, `password`) VALUES ('" + name + "' , '" + ID + "' , '"+ password + "');" ;
                        Statement statement = con.createStatement();

                        int count = statement.executeUpdate(query);
                        if(count > 0)
                        {
                            JOptionPane.showMessageDialog(null , "Thanks for creating New Account!!! \n Your account saved in our Database");
                        }

                        con.close();
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null , "Still Your account is not saved in our Database");
                    }

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
    }
}
