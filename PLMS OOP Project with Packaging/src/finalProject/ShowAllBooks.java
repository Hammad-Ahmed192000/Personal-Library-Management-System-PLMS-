package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.* ;

class ShowAllBooks
{
    JFrame frame ;
    JPanel panel ;
    JScrollPane scrollPane ;
    JLabel label ;
    // JTabbedPane tabbedPane ;
    JTable booksTable ;
    JButton back ;
    ShowAllBooks()
    {
        frame = new JFrame("Records Of All Books") ;
        label = new JLabel("All Books Record") ;
        back = new JButton("Back") ;

        panel = new JPanel() ;
        panel.setLayout(null);
        panel.setBackground(new Color(153, 102,  0));


        int dim1 = 0 ;
        String columns [] = {"bookID" , "bookName" , "authorName" , "bookISBN"};

        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);

        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(border);

        label.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        back.setFont(new Font("Aerial",Font.BOLD,19));
//        scrollPane.setFont(new Font("Aerial",Font.BOLD,14));



        label.setBounds(480 ,30,400,50);
//         scrollPane.setBounds(200 ,150,500 ,500);
        back.setBounds(650,610,120,50);




        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                frame.setVisible(false);
                new showMenu().setVisible(true);
            }
        });




        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            // here plms is MYSQL database name, root is username and maadi192000 is password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plms","root","maadi192000");
            Statement stmt = con.createStatement();

            //Retrieving the data from plms.books table
            ResultSet rs = stmt.executeQuery("SELECT * FROM books;");

            while(rs.next())
            {
                ++dim1 ;
            }

            String bookRecords [][] = new String[dim1][4] ;

            rs = stmt.executeQuery("SELECT * FROM books;");

            int index = 0 ;
            while (rs.next())
            {
                bookRecords[index][0] = Integer.toString(rs.getInt(1));
                bookRecords[index][1] = rs.getString(2) ;
                bookRecords[index][2] = rs.getString(3) ;
                bookRecords[index][3] = rs.getString(4) ;
                ++index ;
            }

            booksTable = new JTable(bookRecords , columns) ;
            // booksTable.setBounds(200 , 200 , 400 , 500);


            Border border2 = BorderFactory.createLineBorder(Color.BLACK ,3);
            scrollPane = new JScrollPane(booksTable) ;
            scrollPane.setSize(700,500);
            scrollPane.setLocation(350,100);


            scrollPane.setBorder(border2);

            // scrollPane.setBounds(200 , 200 , 400 , 500);

            stmt.close();
            con.close();

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null , e.getMessage());
        }


        // panel.setBounds(0 , 850 ,1280,850);
        // back.setBounds(850,650,120,40);

        panel.add(label);
        panel.add(scrollPane) ;
        panel.add(back) ;
        frame.add(panel);

        frame.setVisible(true);
        // frame.setLayout(null);
        frame.setSize(1350,850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
