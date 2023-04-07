package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.* ;

class showMenu1 extends Frame
{
    JLabel l1 = new JLabel("FURTHER UPDATES"); ;
    JButton bAdd = new JButton("Add Book");
    // Button bSearch = new Button("Search Book");
    JButton bDelete = new JButton("Remove Book");
    JButton bShow = new JButton("Show All Book");
    JButton bTotal = new JButton("Total Books");
    JButton bExit = new JButton("Exit");
    JButton back = new JButton("BACK");
    JSeparator separator =new JSeparator() ;
    showMenu1 currentFrame = this;
    ImageIcon icon , addBookIcon , deleteBookIcon , searchBookIcon , totalBooksIcon ;
    JLabel addBooKLogo , deleteBookLogo ,  searchBookLogo , totalBooksLogo ;
    int numOfBooks = 0 ;

    showMenu1()
    {

        setSize(1350,850);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        addBookIcon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\addBook4.png") ;
        addBooKLogo = new JLabel(addBookIcon);
        addBooKLogo.setBounds(450,170,200 , 200);
        addBooKLogo.setVisible(true);
        addBooKLogo.setLayout(null);


        deleteBookIcon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\deleteBook2.png") ;
        deleteBookLogo = new JLabel(deleteBookIcon);
        deleteBookLogo.setBounds(815,170,200,200);
        deleteBookLogo.setVisible(true);
        deleteBookLogo.setLayout(null);

        searchBookIcon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\searchBook.png") ;
        searchBookLogo = new JLabel(searchBookIcon);
        searchBookLogo.setBounds(450,375,200 ,200);
        searchBookLogo.setVisible(true);
        searchBookLogo.setLayout(null);


        totalBooksIcon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\totalBooks2.png") ;
        totalBooksLogo = new JLabel(totalBooksIcon);
        totalBooksLogo.setBounds(815,375,260 ,280);
        totalBooksLogo.setVisible(true);
        totalBooksLogo.setLayout(null);

        //this code is for setting backGround image
        icon = new ImageIcon("H:\\BS (CS) 3\\OOP Th Dr.Sher\\After_Break_Revised_Course\\OOP Project\\Final Project Code with Packaging\\src\\finalProject\\images\\pic2.jpg") ;
        JLabel background = new JLabel(icon);
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);


        l1.setForeground(Color.WHITE);
        // l1.setBackground(null);
        l1.setLayout(null);

        bAdd.setBackground(Color.WHITE);
        bDelete.setBackground(Color.WHITE);
        bShow.setBackground(Color.WHITE);
        bTotal.setBackground(Color.WHITE);

        bAdd.setForeground(Color.BLACK);
        bDelete.setForeground(Color.BLACK);
        bShow.setForeground(Color.BLACK);
        bTotal.setForeground(Color.BLACK);

        Border border = BorderFactory.createLineBorder(Color.BLACK ,3);

        bAdd.setBorder(border);
        bDelete.setBorder(border);
        bTotal.setBorder(border);
        bShow.setBorder(border);

        Border border2 = BorderFactory.createLineBorder(Color.white ,3);

        bExit.setBorder(border2);
        back.setBorder(border2);

        bExit.setBackground(Color.BLACK);
        back.setBackground(Color.BLACK);

        bExit.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        l1.setBounds(450,50,500,60);
        bAdd.setBounds(450,340,120 ,40);
        // bSearch.setBounds(150,250,120,40);
        bDelete.setBounds(805 ,330,120,40);
        bShow.setBounds(450,530,120,40);
        bTotal.setBounds(805,530,120,40);
        back.setBounds(220,650,120,40);
        bExit.setBounds(1070,650,120,40);
        separator.setBounds(0, 120 ,1350,50);


        l1.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        back.setFont(new Font("Aerial",Font.BOLD,14));
        bAdd.setFont(new Font("Aerial",Font.BOLD,14));
        // bSearch.setFont(new Font("Aerial",Font.BOLD,14));
        bDelete.setFont(new Font("Aerial",Font.BOLD,14));
        bShow.setFont(new Font("Aerial",Font.BOLD,14));
        bTotal.setFont(new Font("Aerial",Font.BOLD,14));
        bExit.setFont(new Font("Aerial",Font.BOLD,14));

        bAdd.addActionListener(new actions());
        // bSearch.addActionListener(new actions());
        bDelete.addActionListener(new actions());
        bShow.addActionListener(new actions());
        bTotal.addActionListener(new actions());
        bExit.addActionListener(new actions());
        back.addActionListener(new actions());
        addWindowListener(new MyWindow());


        background.add(l1);
        background.add(separator) ;
        background.add(addBooKLogo) ;
        background.add(bAdd);
        // background.add(bSearch);
        background.add(deleteBookLogo) ;
        background.add(bDelete);
        background.add(searchBookLogo) ;
        background.add(bShow);
        background.add(totalBooksLogo);
        background.add(bTotal);
        background.add(bExit);
        background.add(back);
        add(background) ;
    }

    private class actions implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==bAdd)
            {
                currentFrame.setVisible(false);
                new AddBook().setVisible(true);
            }
            /*
            else if(ae.getSource()==bSearch)
            {
                currentFrame.setVisible(false);
                new SearchBook().setVisible(true);
            }
             */
            else if(ae.getSource()==bDelete)
            {
                currentFrame.setVisible(false);
                new DeleteBook().setVisible(true);
            }
            else if(ae.getSource()==bShow){
					currentFrame.setVisible(false);
					new ShowAllBooks() ;
            }
            else if(ae.getSource()==bTotal)
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");

                    // here plms is MYSQL database name, root is username and maadi192000 is password

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plms","root","maadi192000");

                    Statement stmt = con.createStatement();
                    //Retrieving the data
                    ResultSet rs = stmt.executeQuery("SELECT * FROM books;");
                    //Moving the cursor to the last row
                    int i = 0 ;
                    while(rs.next())
                    {
                        i++ ;
                    }
                    int rowCount = i ;

                    JOptionPane.showMessageDialog(null,"Total number of book you added are :" + rowCount);

                    stmt.close();
                    con.close();

                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null , e.getMessage());
                }


            }
				else if(ae.getSource()==bExit)
				{
                    currentFrame.setVisible(false);
                    new project().setVisible(true);
				}
            else if(ae.getSource()==back)
            {
                currentFrame.setVisible(false);
                new project().setVisible(true);
            }
        }
    }
}
