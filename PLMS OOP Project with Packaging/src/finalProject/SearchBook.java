package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class SearchBook extends Frame
{
    TextField bName = new TextField(20);
    TextField AName = new TextField(20);
    TextField isbn = new TextField(20);
    Button back = new Button("BACK");
    Button store = new Button("STORE");
    SearchBook currentFrame = this;
    Label lB , lA , lI ;
    String AName1 , bName1 , isbn1 ;
    int bookID ;

    public SearchBook()
    {
        setSize(1280,850);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        lB = new Label("*Book Name");
        lA = new Label("Author Name");

        add(bName);
        add(AName);
        add(lB);
        add(lA);
        add(back);
        add(store);

        bName.setBounds(400,250,250,40);
        AName.setBounds(400,350,250,40);
        lB.setBounds(250,225,120,90);
        lA.setBounds(250,325,125,90);
        back.setBounds(350,600,120,50);
        store.setBounds(550,600,120,50);

        back.addActionListener(new actions());
        store.addActionListener(new actions());

        back.setFont(new Font("Aerial",Font.PLAIN,19));
        store.setFont(new Font("Aerial",Font.PLAIN,19));
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
            if(ae.getSource()==back)
            {
                currentFrame.setVisible(false);
                new showMenu().setVisible(true);
            }

            else if(ae.getSource()==store)
            {
                bName1 = bName.getText();
                // AName1 = AName.getText();

                if (bName1.length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Must filled Book Name Field!!!");
                }


                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                        // here plms is MYSQL database name, root is username and maadi192000 is password
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plms", "root", "maadi192000");

                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    String query = "SELECT * FROM books where bookName =  " + bName1 ;

                    ResultSet rs = stmt.executeQuery(query) ;

                    bookID = rs.getInt(1) ;
                    // bName1 = rs.getString("bookName") ;
                    AName1 = rs.getString(3) ;
                    isbn1 = rs.getString(4) ;

                    JOptionPane.showMessageDialog(null , bookID + "\t"  + bName1 + "\t" + AName1 + "\t" + isbn1);

                    stmt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null , e.getMessage());
                }

            }
        }
    }
}

