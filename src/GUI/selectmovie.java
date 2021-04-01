package GUI;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



public class selectmovie extends JFrame implements ActionListener
{
    static Date fromdate,enddate;
    static JComboBox Language,Movie,Datecombo,Time;
    Time time;
    static JLabel image=new JLabel(),panel;
    static String movieStr,dateStr,timeStr,pass;
    static GridBagConstraints grid;
    public selectmovie()
    {
        JFrame frame=new JFrame();
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 	frame.setSize(ScreenSize.width,ScreenSize.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1=new JPanel(new GridBagLayout());
	 grid=new GridBagConstraints();
        
        panel=new JLabel(new ImageIcon("E:\\BookMyShow\\k6.png"));
		panel.setLayout(new GridBagLayout());
		panel1.add(panel);
                
        
        
        JLabel language=new JLabel("LANGUAGE");
        language.setForeground(Color.white);
        language.setFont(new Font("verdana",Font.PLAIN,18));
	grid.gridy=1;
	grid.gridx=1;
	grid.insets=new Insets(10,0,0,40);
        grid.gridwidth=1;
	panel.add(language,grid);
        
        JLabel movie=new JLabel("MOVIE");
        movie.setForeground(Color.white);
        movie.setFont(new Font("verdana",Font.PLAIN,18));
	grid.gridy=2;
	grid.insets=new Insets(10,0,0,10);
        grid.gridwidth=1;
	panel.add(movie,grid);
        
        JLabel date=new JLabel("DATE");
        date.setForeground(Color.white);
        date.setFont(new Font("verdana",Font.PLAIN,18));
	grid.gridy=3;
	grid.insets=new Insets(10,0,0,0);
        grid.gridwidth=1;
	panel.add(date,grid);
        
        JLabel time=new JLabel("TIME");
        time.setForeground(Color.white);
        time.setFont(new Font("verdana",Font.PLAIN,18));
	grid.gridy=4;
	grid.insets=new Insets(10,0,0,0);
        grid.gridwidth=1;
	panel.add(time,grid);
                
       	Language=new JComboBox();
       	Language.setPreferredSize(new Dimension(200,30));
       	Language.setBackground(new Color(227, 229, 81));
       	Language.setOpaque(false);
       	grid.gridy=1;
       	grid.gridx=2;
        grid.gridwidth=1;
       	grid.insets=new Insets(0,0,0,80);
        Language.addItem("ALL");
        Language.addItem("TAMIL");
        Language.addItem("MALAYALAM");
        Language.addItem("TELUGU");
        Language.addItem("KANNADA");
        Language.addItem("ENGLISH");
        Language.setOpaque(false);
        Language.addActionListener(this);
        
        String lang=Language.getSelectedItem().toString();
        panel.add(Language,grid);
        
        Movie=new JComboBox();
        Movie.setPreferredSize(new Dimension(200,30));
       	Movie.setBackground(new Color(227, 229, 81));
        grid.gridy=2;
        Movie.setOpaque(true);
        grid.insets=new Insets(10,0,0,80);
        grid.gridwidth=1;
        Movie=selectmovie.data(Movie, lang);
        Movie.addActionListener(this);
        panel.add(Movie,grid);
        
        Datecombo=new JComboBox();
        Datecombo.setPreferredSize(new Dimension(200,30));
       	Datecombo.setBackground(new Color(227, 229, 81));
        grid.gridy=3;
        Datecombo.setOpaque(false);
        grid.gridwidth=1;
        grid.insets=new Insets(10,0,0,80);
        Datecombo.addActionListener(this);
        panel.add(Datecombo,grid);
	
        Time=new JComboBox();
        Time.setPreferredSize(new Dimension(200,30));
       	Time.setBackground(new Color(227, 229, 81));
        grid.gridy=4;
        grid.gridwidth=1;
        grid.insets=new Insets(10,0,0,80);
        panel.add(Time,grid);
        
        JButton nextButton =new JButton("PROCEED");
        nextButton.setForeground(Color.white);
        nextButton.setPreferredSize(new Dimension(100,30));
        nextButton.setBackground(new Color(100,170,140,255));
        nextButton.setBorder(new LineBorder(new Color(255,255,255)));
        nextButton.setOpaque(false);
        grid.gridy=6;
        grid.gridx=1;
        grid.gridwidth=2;
        grid.insets=new Insets(30,260,0,0);
        nextButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                	pass="";
                        if(Datecombo.getSelectedItem()==null || Time.getSelectedItem()==null)
                        {
                            JOptionPane.showMessageDialog(null,"Select a movie");
                        }
                        else
                        {
                	try {     				
        				Class.forName("com.mysql.cj.jdbc.Driver");  
        				Connection con=DriverManager.getConnection(  
        				"jdbc:mysql://127.0.0.1:3306/bookmymovie","####","####"); 
        				Statement st=con.createStatement();
        			
        				
        		
        				 ResultSet rs=st.executeQuery( "select seat from user where movie='"+Movie.getSelectedItem()+
        						 "' and showdate='"+Datecombo.getSelectedItem()+"' and showtime='"+Time.getSelectedItem()+"'");
        				 while(rs.next()) {
        					 String temp=rs.getString(1);
        					 pass+=temp;
        					
        				 }
        				
        					System.out.println(pass);
        			        				 
        				 //con.setAutoCommit(true);
        				 //con.close();
        				 //System.out.println("Success! show");
        			}
        			catch(Exception exception) {
        				System.out.println(exception.getMessage());
        			}
                	movieStr=Movie.getSelectedItem().toString();
                	dateStr=Datecombo.getSelectedItem().toString();
                	timeStr=Time.getSelectedItem().toString();
                	
                	new MovieScreen();
                        frame.dispose();
                        }
                }
            }
        );
	panel.add(nextButton,grid);
       
	JButton backButton =new JButton("BACK");
        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    new Canceltickets();
                    frame.dispose();
                }
        });
        backButton.setForeground(Color.white);
        backButton.setPreferredSize(new Dimension(100,30));
        backButton.setBackground(new Color(100,170,140,255));
         backButton.setBorder(new LineBorder(new Color(255,255,255)));
         backButton.setOpaque(false);
	grid.gridy=6;
	grid.gridx=0;
	grid.gridwidth=2;
	grid.insets=new Insets(30,40,0,100);
	panel.add(backButton,grid);
        	
	frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String arg[])
    {
        new selectmovie();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==Language)
        {
           Movie.removeAllItems();
           String value=Language.getSelectedItem().toString();
           selectmovie.data(Movie, value);
        }
        else if(e.getSource()==Movie)
        {
              if(Movie.getSelectedItem()!=null)
              {
                 String value=Movie.getSelectedItem().toString();
                 selectmovie.data(Datecombo, value);
                 selectmovie.retrieve(value);
              }
        }
        else if(e.getSource()==Datecombo)
        {
            if(Datecombo.getSelectedItem()!=null)
            {
                LocalDate localDate = LocalDate.parse(Datecombo.getSelectedItem().toString());
                LocalDate date1  = LocalDate.now();
                if(date1.compareTo(localDate)!=0)
                {
                            Time.removeAllItems();
                            Time.addItem("11:00");
                            Time.addItem("14:30");
                            Time.addItem("18:00");
                            Time.addItem("21:30");
                }
            }
        }
    }
    public static Connection getConnection()
        {
            Connection connection=null;
            try
            {
                connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookmymovie", "###", "####");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return connection;
        }
    public static JComboBox data(JComboBox ch,String value)
    {
        try
        {
              //  Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection=getConnection();
                Statement statement=connection.createStatement();
                ResultSet resultset;
                resultset=statement.executeQuery("select * from movie1");
                while(resultset.next())
                {
                    String movie=resultset.getString("MOVIE");
                    String language=resultset.getString("LANGUAGE");
                    fromdate=resultset.getDate("RELEASE_DATE");
                    enddate=resultset.getDate("END_DATE");
                    if(language.equals(value) || value.equals("ALL"))
                    {
                        ch.addItem(movie);
                    }
                    if(movie.equals(value))
                    {
                        String s;
                        LocalDate date1  = LocalDate.now(),flag;
                        flag=date1;
                        LocalDate fromdate1 = fromdate.toLocalDate();
                        LocalDate enddate1 =  enddate.toLocalDate();
                        
                        ch.removeAllItems();
                        
                        if(flag.compareTo(fromdate1)>0)
                        {
                            while (!flag.isAfter(enddate1))
                            {
                                s=flag.toString();
                                ch.addItem(s);
                                
                                flag = flag.plusDays(1);
                            }
                            
                        }
                        else if(date1.compareTo(fromdate1)<=0)
                        {
                            while(!fromdate1.isAfter(enddate1))
                            {
                                s=fromdate1.toString();
                                ch.addItem(s);
                                 
                                fromdate1 = fromdate1.plusDays(1);
                            }
                        }
                        LocalDate localDate = LocalDate.parse(Datecombo.getSelectedItem().toString());
                        if(date1.compareTo(localDate)==0)
                        {
                            Time.removeAllItems();
                            String showtime[]={"11:00","14:30","18:00","21:30"};
                            LocalTime time=LocalTime.now();
                            for(String i : showtime)
                            {
                                String str[]=i.split(":");
                                int hours=Integer.parseInt(str[0]);
                                int minutes=Integer.parseInt(str[1]);
                                LocalTime time1 = LocalTime.of(hours,minutes,00);
                                if(time1.isAfter(time))
                                {
                                    Time.addItem(time1);
                                }
                            }
                        }
                    }
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return ch;
    }
    public static void retrieve(String value)
    {
        try 
        {
             grid=new GridBagConstraints();
                Connection connection=getConnection();
                Statement statement=connection.createStatement();
                ResultSet resultset=statement.executeQuery("select * from movie1");
                while(resultset.next())
                {
                    String movie=resultset.getString("MOVIE");
                    
                    if(movie.equals(value))
                    {
                           Blob b=resultset.getBlob("POSTER");
                           int len = (int) b.length();
                           byte[] imagedata = b.getBytes(1, len);
                      
                           Image img = Toolkit.getDefaultToolkit().createImage(imagedata);
                           
                          
                           ImageIcon icon =new ImageIcon(img);
                            
                           
                     //      image.setBounds(100,20,500,1000);
                           image.setIcon(icon);
                            image.setPreferredSize(new Dimension(500,300));
                           grid.gridy=0;
                           grid.gridx=1;
                           grid.insets=new Insets(0,0,30,10);
                           
                           grid.gridwidth=3;
                           panel.add(image,grid);
                           
                    }
                }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}