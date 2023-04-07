package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.* ;
class AddBook extends Frame
{

    TextField bName = new TextField(20);
    TextField AName = new TextField(20);
    TextField isbn = new TextField(20);
    JButton back = new JButton("BACK");
    JButton store = new JButton("STORE");
    AddBook currentFrame =this;
    JLabel lB , lA , lI , l1;
    String AName1,bName1,isbn1;
    ImageIcon icon ;


    public AddBook()
    {
        setSize(1280,850);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        JSeparator separator = new JSeparator() ;
        //this code is for setting backGround image
        icon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\pic2.jpg") ;
        JLabel background = new JLabel(icon);
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);

        l1 = new JLabel("Add Records");
        lB = new JLabel("Book Name:");
        lA = new JLabel("Author Name:");
        lI = new JLabel("ISBN Number:");


        background.add(separator);
        background.add(l1) ;
        background.add(bName);
        background.add(AName);
        background.add(isbn);
        background.add(lB);
        background.add(lA);
        background.add(lI);
        background.add(back);
        background.add(store);
        add(background) ;


        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);

        back.setBorder(border);
        store.setBorder(border);

        back.setBackground(Color.BLACK);
        store.setBackground(Color.BLACK);

        back.setForeground(Color.WHITE);
        store.setForeground(Color.WHITE);

        l1.setForeground(Color.WHITE);

        l1.setBounds(480 ,50,400,50);
        bName.setBounds(630 ,255,250,30);
        AName.setBounds(630 ,355,250,30);
        isbn.setBounds(630 ,470,250,30);
        lB.setBounds(475,250,120,50);
        lA.setBounds(475,350,140,50);
        lI.setBounds(475,430,140,110);
        back.setBounds(350,600,120,50);
        store.setBounds(900,600,120,50);
        separator.setBounds(0, 120 ,1350,50 );

        back.addActionListener(new actions());
        store.addActionListener(new actions());


        lB.setForeground(Color.WHITE);
        lI.setForeground(Color.WHITE);
        lA.setForeground(Color.WHITE);


        l1.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        back.setFont(new Font("Aerial",Font.BOLD,14));
        store.setFont(new Font("Aerial",Font.BOLD,14));
        lB.setFont(new Font("Aerial",Font.BOLD,19));
        lA.setFont(new Font("Aerial",Font.BOLD,19));
        lI.setFont(new Font("Aerial",Font.BOLD,19));
        bName.setFont(new Font("Aerial",Font.PLAIN,17));
        AName.setFont(new Font("Aerial",Font.PLAIN,17));
        isbn.setFont(new Font("Aerial",Font.PLAIN,17));


        addWindowListener(new MyWindow());
    }

    private class actions implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==back)
            {
                currentFrame.setVisible(false);
                new showMenu().setVisible(true);
            }

            else if(ae.getSource()==store)
            {
                bName1 = bName.getText();
                AName1 = AName.getText();
                isbn1 = isbn.getText();

                try
                {
                    if(bName1.length()==0 || AName1.length()==0 || isbn1.length()==0)
                    {
                        throw new EmptyException();
                    }

                    if(isbn1.length()==13)
                    {
                        for(int i = 0 ; i < 13 ; i++)
                        {
                            if((isbn1.charAt(i)>='0' && isbn1.charAt(i) <= '9'))
                            {

                            }
                            else
                            {
                                throw new IsbnException();
                            }
                        }
                    }
                    else
                    {
                        throw new IsbnSizeException();
                    }

                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");

                        // here plms is MYSQL database name, root is username and maadi192000 is password

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plms","root","maadi192000");

                        /*
                            This code is for Inserting record in MySql DataBase
                        */
                        String query = "INSERT INTO `plms`.`books` (`bookName`, `authorName`, `bookISBN`) VALUES ('" + bName1 + "' , '" + AName1 + "' , '"+ isbn1 + "');" ;
                        Statement statement = con.createStatement();

                        int count = statement.executeUpdate(query);
                        if(count > 0)
                        {
                            JOptionPane.showMessageDialog(null , "Your new Book Record is added Successfully");
                        }

                        con.close();

                    }
                    catch (Exception  e)
                    {
                        JOptionPane.showMessageDialog(null , "Record is not Added");
                    }
                }
                catch(IsbnSizeException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
                catch(EmptyException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
                catch(IsbnException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }

        }
    }
}
