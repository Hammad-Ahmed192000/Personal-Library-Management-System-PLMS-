package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class DeleteBook extends Frame
{

    TextField bName = new TextField(20);
    TextField AName = new TextField(20);
    // TextField isbn = new TextField(20);
    JButton back = new JButton("BACK");
    JButton reset = new JButton("RESET");
    DeleteBook currentFrame =this;
    JLabel lB , lA , l1 ;
    String AName1,bName1;
    ImageIcon icon ;
    JSeparator separator ;

    public DeleteBook()
    {
        setSize(1280,850);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        separator = new JSeparator() ;

        l1 = new JLabel("Delete Record") ;
        lB = new JLabel("*Book Name:");
        lA = new JLabel("Author Name:");


        //this code is for setting backGround image
        icon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\pic2.jpg") ;
        JLabel background = new JLabel(icon);
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);

        background.add(l1) ;
        background.add(separator) ;
        background.add(bName);
        background.add(AName);
        background.add(lB);
        background.add(lA);
        background.add(back);
        background.add(reset);
        add(background) ;


        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);
        back.setBorder(border);
        reset.setBorder(border);

        back.setForeground(Color.WHITE);
        reset.setForeground(Color.WHITE);

        back.setBackground(Color.BLACK);
        reset.setBackground(Color.BLACK);






        l1.setBounds(480 ,50,400,50);
        bName.setBounds(630 ,300,230,30);
        AName.setBounds(630 ,400,230,30);
        lB.setBounds(475,285,120,50);
        lA.setBounds(475,390,140,50);
        back.setBounds(350,600,120,50);
        reset.setBounds(900,600,120,50);
        separator.setBounds(0, 120 ,1350,50 );

        back.addActionListener(new actions());
        reset.addActionListener(new actions());

        l1.setForeground(Color.WHITE);
        lB.setForeground(Color.WHITE);
        lA.setForeground(Color.WHITE);


        l1.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        back.setFont(new Font("Aerial",Font.BOLD,14));
        reset.setFont(new Font("Aerial",Font.BOLD,14));
        lB.setFont(new Font("Aerial",Font.BOLD,19));
        lA.setFont(new Font("Aerial",Font.BOLD,19));
        bName.setFont(new Font("Aerial",Font.PLAIN,17));
        AName.setFont(new Font("Aerial",Font.PLAIN,17));


        addWindowListener(new MyWindow());
    }

    private class actions implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == back)
            {
                currentFrame.setVisible(false);
                new showMenu().setVisible(true);
            }
            else if (ae.getSource() == reset)
            {
                bName1 = bName.getText();
                AName1 = AName.getText();

                if (bName1.length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Must fill Book Name Field!!!");
                }
                else
                {
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");

                        // here plms is MYSQL database name, root is username and maadi192000 is password
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plms", "root", "maadi192000");

                        String sql = "DELETE FROM `plms`.`books` WHERE (`bookName` = ?) ";
                        PreparedStatement st = con.prepareStatement(sql);

                        st.setString(1, bName1);
                        int count = st.executeUpdate();
                        if (count > 0)
                        {
                            JOptionPane.showMessageDialog(null, "Book Record have been successfully Deleted");
                        }
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage() + "Record is not Deleted!!!");
                    }
                }
            }
        }
    }
}
