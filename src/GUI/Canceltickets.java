package GUI;
import database.BookingHistory;
import database.login;
import database.Cancel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.LineBorder;
 
public class Canceltickets{
    JTextArea t1,t2;
	static JTextArea t3,t4,t5,t6;
	
    JButton b,b1,b2,logout;
	static JButton Mback;
	static JButton Mnext;
    
    JPanel panel,panel2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,p;
    static JFrame f;
    GridBagConstraints c;
   
    public Canceltickets()
    {
        f=new JFrame();
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 	f.setSize(ScreenSize.width,ScreenSize.height);
        panel=new JPanel(new GridBagLayout());
        c=new GridBagConstraints();
      
        p=new JLabel(new ImageIcon("E:\\BookMyShow\\k5.png"));
		p.setLayout(new GridBagLayout());
		panel.add(p);
		
        l1=new JLabel("USER DETAILS");
        l1.setFont(new Font("verdana",Font.BOLD,20));
        l1.setForeground(Color.white);
	     c.gridy=0;
	     c.gridx=0;
	     c.gridwidth=4;
	     c.fill=GridBagConstraints.CENTER;
	     c.insets=new Insets(0,0,10,0);
	     p.add(l1,c);
	
	     
	     l2=new JLabel("MAIL ID:");
	     l2.setFont(new Font("verdana",Font.BOLD,12));
	     l2.setForeground(Color.white);
	     c.gridy=1;
	     c.gridx=0;
	     c.gridwidth=1;
	     c.insets=new Insets(30,0,0,0);
	     p.add(l2,c);
	     t1=new JTextArea(LoginPage.emailID);
	     t1.setFont(new Font("verdana",Font.BOLD,12));
	     t1.setForeground(Color.white);
	     t1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
	     t1.setOpaque(false);
	     c.gridy=1;
	     c.gridx=1;
	     c.gridwidth=1;
	     c.insets=new Insets(30,30,0,0);
	     t1.setEditable(false);
	     p.add(t1,c);
	     l3=new JLabel("NAME:");
	     l3.setForeground(Color.white);
	     l3.setFont(new Font("verdana",Font.BOLD,12));
	     c.gridy=2;
	     c.gridx=0;
	    
	     c.insets=new Insets(30,0,0,0);
	     p.add(l3,c);
	        
	     login.getUsername(LoginPage.emailID); //this method is used get username
	     t2=new JTextArea(login.username); 
	     t2.setFont(new Font("verdana",Font.BOLD,12));
	     t2.setForeground(Color.white);
	     t2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
	     t2.setOpaque(false);
	     c.gridy=2;
	     c.gridx=1;
	     c.insets=new Insets(30,30,0,0);
	     t2.setEditable(false);
	     p.add(t2,c);
	     b=new JButton("UPDATE");
	     b.setPreferredSize(new Dimension(100,30));
	     b.setBackground(new Color(100,170,140,255));
	     b.setBorder(new LineBorder(new Color(255,255,255)));
	     b.setForeground(Color.white);
	     b.setOpaque(false);
	     c.gridy=3;
	     c.gridx=0;
	     c.gridwidth=1;
	     c.insets=new Insets(30,0,0,10);
	     p.add(b,c);
	     logout=new JButton("LOGOUT");
	     logout.setPreferredSize(new Dimension(100,30));
	     logout.setBackground(new Color(100,170,140,255));
	     logout.setBorder(new LineBorder(new Color(255,255,255)));
	     logout.setForeground(Color.white);
	     logout.setOpaque(false);
	     c.gridy=3;
	     c.gridx=1;
	     c.gridwidth=1;
	     
	     c.insets=new Insets(30,10,0,0);
	     p.add(logout,c);
	     l4=new JLabel("RECENTLY BOOKED");
	     l4.setFont(new Font("verdana",Font.BOLD,20));
	     l4.setForeground(Color.white);
	     c.gridy=4;
	     c.gridx=0;
	     c.gridwidth=3;
	     c.insets=new Insets(30,0,10,0);
	     p.add(l4,c);
	     
	   
        
	     history();
	     logout.addActionListener(new ActionListener() {
				
				@Override
	                
				public void actionPerformed(ActionEvent e) {
				 new demo1();
				f.dispose();
				}
			});
	     b.addActionListener(new ActionListener() {
			
			@Override
                       
			public void actionPerformed(ActionEvent e) {
			 new updateprofile();
			
			
			}
		});
	     
	   
	    
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        f.setVisible(true);
}
       
   
    public void history() {
    	new BookingHistory().FetchingHistory(LoginPage.emailID);
        LocalDate date1  = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String str=BookingHistory.HDate;
        String str1=BookingHistory.HTime;
        LocalTime time=LocalTime.now();
         boolean flag=false;
         boolean flag1=false;
         if(str!=null)
         {
                                System.out.println("2");
                                String strarray[]=str1.split(":");
                                int hours=Integer.parseInt(strarray[0]);
                                int minutes=Integer.parseInt(strarray[1]);
                                LocalTime time1 = LocalTime.of(hours,minutes,00);
                                LocalDate sqldate = LocalDate.parse(str, formatter);
                                if(sqldate.compareTo(date1)>0)
                                {
                                    flag=true;
                                    System.out.println("3");
                                }
                                System.out.println(sqldate);
                                System.out.println(date1);
                                if(sqldate.compareTo(date1)==0) {
                                	flag1=true;
                                        System.out.println("4");
                                }
                                if(flag1==true && time1.isAfter(time))
                                {
                                    flag=true;
                                    System.out.println("5");
                                   
                                }
         }
    	 if(new BookingHistory().HistoryCheck() && flag) {
                        System.out.println("6");
    			new BookingHistory().FetchingHistory(LoginPage.emailID);
    			l5=new JLabel("MOVIE NAME:");
    			l5.setForeground(Color.white);
   	         	c.gridwidth=1;
   	         	c.gridy=5;
   	         	c.gridx=0;
   	         	c.insets=new Insets(30,0,0,0);
   	         	l5.setFont(new Font("verdana",Font.BOLD,12));
   	         	p.add(l5,c);
   	         	t3=new JTextArea();
   	         	t3.setText(BookingHistory.HMovie);
   	         	t3.setFont(new Font("verdana",Font.BOLD,12));
   	         	t3.setForeground(Color.white);
   	         	t3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
   	         	t3.setOpaque(false);
   	         	c.gridy=5;
   	         	c.gridx=1;
   	         	c.insets=new Insets(30,30,0,0);
   	         	t3.setEditable(false);
   	         	p.add(t3,c);
   	         	l6=new JLabel("DATE:");
   	         	l6.setFont(new Font("verdana",Font.BOLD,12));
   	         	l6.setForeground(Color.white);
    	         c.gridy=6;
    	         c.gridx=0;
    	         c.insets=new Insets(30,0,0,0);
    	         p.add(l6,c);
    	         t4=new JTextArea(BookingHistory.HDate);
                 t4.setFont(new Font("verdana",Font.BOLD,12));
                 t4.setForeground(Color.white);
                 t4.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
                 t4.setOpaque(false);
    	         c.gridy=6;
    	         c.gridx=1;
    	         c.insets=new Insets(30,30,0,0);
    	         t4.setEditable(false);
    	         p.add(t4,c);
    	         l7=new JLabel("TIME:");
    	         l7.setFont(new Font("verdana",Font.BOLD,12));
                 l7.setForeground(Color.white);
    	         c.gridy=7;
    	         c.gridx=0;
    	         c.insets=new Insets(30,0,0,0);
    	         p.add(l7,c);
    	         t5=new JTextArea(BookingHistory.HTime);
                 t5.setFont(new Font("verdana",Font.BOLD,12));
                 t5.setForeground(Color.white);
                 t5.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
                 t5.setOpaque(false);
    	         c.gridy=7;
    	         c.gridx=1;
    	         c.insets=new Insets(30,30,0,0);
    	         t5.setEditable(false);
    	         p.add(t5,c);
    	         l8=new JLabel("SEAT NO:");
    	         l8.setFont(new Font("verdana",Font.BOLD,12));
                 l8.setForeground(Color.white);
    	         c.gridy=8;
    	         c.gridx=0;
    	         c.insets=new Insets(30,0,0,0);
    	         p.add(l8,c);
    	         t6=new JTextArea(BookingHistory.HSeat);
                 t6.setFont(new Font("verdana",Font.BOLD,12));
                 t6.setForeground(Color.white);
                 t6.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,new Color(255,255,255)));
                 t6.setOpaque(false);
    	         c.gridy=8;
    	         c.gridx=1;
    	         c.insets=new Insets(30,30,0,0);
    	         t6.setEditable(false);
    	         p.add(t6,c);
    	         Mback=new JButton("<");
    	         Mback.setPreferredSize(new Dimension(70,30));
    	         Mback.setBackground(new Color(100,170,140,255));
    	         Mback.setBorder(new LineBorder(new Color(255,255,255)));
    	         Mback.setForeground(Color.white);
    	         Mback.setOpaque(false);
    	         c.gridy=9;
    	         c.gridx=0;
    	         c.gridwidth=1;
    	         c.insets=new Insets(30,60,0,0);
    	         Mback.setEnabled(true);
    	         p.add(Mback,c);
    	         Mnext=new JButton(">");
    	         Mnext.setPreferredSize(new Dimension(70,30));
    	         Mnext.setBackground(new Color(100,170,140,255));
    	         Mnext.setBorder(new LineBorder(new Color(255,255,255)));
    	         Mnext.setForeground(Color.white);
    	         Mnext.setOpaque(false);
    	         c.gridy=9;
    	         c.gridx=1;
    	         c.gridwidth=1;
    	         c.insets=new Insets(30,0,0,0);
    	         Mnext.setEnabled(true);
    	         p.add(Mnext,c);
    	         b1=new JButton("CANCEL TICKETS");
    	         b1.setPreferredSize(new Dimension(200,30));
                 b1.setBackground(new Color(100,170,140,255));
                 b1.setBorder(new LineBorder(new Color(255,255,255)));
                 b1.setForeground(Color.white);
                 b1.setOpaque(false);
    	         c.gridy=10;
    	         c.gridx=0;
    	         c.gridwidth=3;
    	         c.insets=new Insets(30,0,0,0);
    	         b1.setEnabled(true);
    	         p.add(b1,c);
    	         b2=new JButton("BOOK NEW TICKETS");
    	         b2.setPreferredSize(new Dimension(200,30));
                 b2.setBackground(new Color(100,170,140,255));
                 b2.setBorder(new LineBorder(new Color(255,255,255)));
                 b2.setForeground(Color.white);
                 b2.setOpaque(false);
    	         c.gridy=11;
    	         c.gridx=0;
    	         c.insets=new Insets(30,0,0,0);
    	         p.add(b2,c);
    	         b1.addActionListener(new ActionListener() {
    	 			
    	 			@Override
                               
    	 			public void actionPerformed(ActionEvent e) {
    	 				// TODO Auto-generated method stub
    	 				new Cancel().Canceling(LoginPage.emailID, login.username, BookingHistory.HMovie, 
    	 	    				BookingHistory.HDate, BookingHistory.HTime, BookingHistory.HSeat);
    	 	    		JOptionPane.showMessageDialog(f,"Ticket Cancelled");
    	 	    		f.dispose();
    	 	    		new Canceltickets();
    	 			}
    	 		});
    	         
    	         b2.addActionListener(new ActionListener() {
    	 	    	@Override                           //next button
                              
    	 	    	public void actionPerformed(ActionEvent e) {
    	 	    		new selectmovie();
                        f.dispose();
    	 	    	}
    	 	    }); 
//    	 		if(BookingHistory.CurrentMovie==0) {
////	 	    		BookingHistory.CurrentMovie++;
//	 	    		Mback.setEnabled(false);
//	 	    	}      	 	    
    	 	  Mback.addActionListener(new ActionListener() {
   	 	    	@Override                           // refresh button
                            
   	 	    		public void actionPerformed(ActionEvent e) {
   	 	    			BookingHistory.CurrentMovie--;
   	 	    			refresh();   
   	 	    	}
   	 	    }); 
//    	 	if(BookingHistory.CurrentMovie==BookingHistory.MovieSize-1) {
////	 	    		BookingHistory.CurrentMovie++;
//	 	    		Mnext.setEnabled(false);
//	 	    	}  
    	 	 Mnext.addActionListener(new ActionListener() {
    	 	    	@Override                           // refresh button
                 
    	 	    	public void actionPerformed(ActionEvent e) {
    	 	    		BookingHistory.CurrentMovie++;
    	 	    		refresh();
    	 	    	
    	 	    	}
    	 	    }); 
   		     
    	 }
    	 else {
    		l5=new JLabel("NO TICKETS BOOKED");
    		l5.setForeground(Color.white);
 	        c.gridwidth=2;
 	        c.gridheight=3;
 	        c.gridy=5;
 	        c.gridx=0;
 	        c.insets=new Insets(30,0,0,0);
 	        l5.setFont(new Font("verdana",Font.BOLD,15));
 	        p.add(l5,c);
 	        b2=new JButton("BOOK TICKETS");
 	        b2.setPreferredSize(new Dimension(200,30));
 	        b2.setForeground(Color.white);
 	        b2.setBackground(new Color(100,170,140,255));
 	        b2.setBorder(new LineBorder(new Color(255,255,255)));
 	        b2.setOpaque(false);
 	        c.gridy=9;
 	        c.gridx=0;
 	        c.insets=new Insets(30,0,0,0);
 	        p.add(b2,c);
 	        b2.addActionListener(new ActionListener() {
	 	    	@Override                           //next button
                             
	 	    	public void actionPerformed(ActionEvent e) {
	 	    			new selectmovie();
                        f.dispose();
	 	    	}
	 	    });
    	 }
     }         
                
    public static void refresh() {
    	Mnext.setEnabled(true);
    	Mnext.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
    	Mnext.setForeground(Color.white);
    	Mback.setEnabled(true);
    	Mback.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
    	Mback.setForeground(Color.white);
    	new BookingHistory().FetchingHistory(LoginPage.emailID);
    	if(BookingHistory.CurrentMovie==BookingHistory.MovieSize-1) {
//	    		BookingHistory.CurrentMovie++;
	    		Mnext.setEnabled(false);
	    		Mnext.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	    		Mnext.setForeground(Color.gray);
	    	}  
  		if(BookingHistory.CurrentMovie==0) {
//	    		BookingHistory.CurrentMovie++;
	    		Mback.setEnabled(false);
	    		Mback.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	    		Mback.setForeground(Color.gray);
	    	}
  		t3.setText(BookingHistory.HMovie);
  		t4.setText(BookingHistory.HDate);
  		t5.setText(BookingHistory.HTime);
  		t6.setText(BookingHistory.HSeat);
  		f.validate();
  		f.repaint();
    }            
    
  
    public static void main(String[] args) {
        new Canceltickets();
    }
}