package GUI;

import database.login;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.border.LineBorder;
//import java.sql.ResultSet;
import java.sql.Statement;
public class Receipt implements ActionListener {
	JTextArea MovieNameText,DateText,ShowTimingText,SeatNumberText,TotalAmountText,gt;
        JPanel p1;
	JFrame f;
	JButton Booking,back,code;
        JTextField couponCode;
	static  String discountAmount;
	static double grantTotal=MovieScreen.TotalCost;
	public Receipt(){
		JFrame f= new JFrame();
		f.setSize(500, 500);
		//f.setLayout(null);
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 	f.setSize(ScreenSize.width,ScreenSize.height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 p1=new JPanel(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
                JLabel p=new JLabel(new ImageIcon("E:\\BookMyShow\\k7.png"));
                p.setLayout(new GridBagLayout());
                p1.add(p);
		JLabel MovieName=new JLabel("Movie Name:");
                MovieName.setForeground(Color.white);
                MovieName.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=1;
		c.gridx=0;
		c.insets=new Insets(10,0,0,0);
		p.add(MovieName,c);
		JLabel Date=new JLabel("Date:");
                Date.setForeground(Color.white);
                Date.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=2;
		c.insets=new Insets(10,40,0,0);
		p.add(Date,c);
		JLabel ShowTiming=new JLabel("Show Timing:");
                ShowTiming.setForeground(Color.white);
                ShowTiming.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=3;
		c.insets=new Insets(10,0,0,0);
		p.add(ShowTiming,c);
		JLabel SeatNumber=new JLabel("Seat number:");
                SeatNumber.setForeground(Color.white);
                SeatNumber.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=4;
		c.insets=new Insets(10,0,0,0);
		p.add(SeatNumber,c);
		JLabel TotalAmount=new JLabel(" Total Amount:");
                TotalAmount.setForeground(Color.white);
                TotalAmount.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=5;
		c.insets=new Insets(10,0,0,0);
		p.add(TotalAmount,c);
	        JLabel coupon=new JLabel(" Add Coupon Code:");
                coupon.setForeground(Color.white);
                coupon.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=6;
		c.insets=new Insets(10,0,0,20);
		p.add(coupon,c);
		couponCode=new JTextField(10);
                couponCode.setFont(new Font("verdana",Font.PLAIN,18));
                couponCode.setForeground(Color.white);
                couponCode.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(255,255,255)));
                couponCode.setOpaque(false);
                couponCode.setCaretColor(Color.white);
		c.gridy=6;
		c.gridx=1;
		c.insets=new Insets(10,0,0,0);
                p.add(couponCode,c);
		code=new JButton("Enter");
                code.setForeground(Color.white);
                code.setPreferredSize(new Dimension(100,25));
  		code.setBorder(new LineBorder(new Color(255,255,255)));
                code.setBackground(new Color(0,0,0,0));
                code.setOpaque(false);
		c.gridy=6;
		c.gridx=2;
		c.insets=new Insets(10,20,0,0);
		p.add(code,c);
		JLabel total=new JLabel(" Grant Total:");
                total.setForeground(Color.white);
                total.setFont(new Font("verdana",Font.PLAIN,18));
                total.setVisible(false);
 		c.gridy=7;
 		c.gridx=0;
 		c.insets=new Insets(10,0,0,20);
 		p.add(total,c);
 		MovieNameText=new JTextArea();
                MovieNameText.setFont(new Font("verdana",Font.PLAIN,18));
                MovieNameText.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(255,255,255)));
                MovieNameText.setForeground(Color.white);
                MovieNameText.setOpaque(false);
                MovieNameText.setCaretColor(Color.white);
		MovieNameText.setText(selectmovie.movieStr);
                MovieNameText.setEditable(false);
                c.gridy=1;
                c.gridx=1;
                c.insets=new Insets(0,30,0,0);
		p.add(MovieNameText,c);
		DateText=new JTextArea();
                DateText.setFont(new Font("verdana",Font.PLAIN,18));
                DateText.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(255,255,255)));
                DateText.setForeground(Color.white);
                DateText.setOpaque(false);
                DateText.setCaretColor(Color.white);
		DateText.setText(selectmovie.dateStr);
                DateText.setEditable(false);
		c.gridy=2;
                c.insets=new Insets(10,30,0,0);
		p.add(DateText,c);
		ShowTimingText=new JTextArea();
		ShowTimingText.setText(selectmovie.timeStr);
                ShowTimingText.setFont(new Font("verdana",Font.PLAIN,18));
                ShowTimingText.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(255,255,255)));
                ShowTimingText.setForeground(Color.white);
                ShowTimingText.setOpaque(false);
                ShowTimingText.setCaretColor(Color.white);
                ShowTimingText.setEditable(false);
                c.gridy=3;
		c.insets=new Insets(10,30,0,0);
		p.add(ShowTimingText,c);
		SeatNumberText=new JTextArea(MovieScreen.seat);
                SeatNumberText.setFont(new Font("verdana",Font.PLAIN,18));
                SeatNumberText.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(255,255,255)));
                SeatNumberText.setForeground(Color.white);
                SeatNumberText.setOpaque(false);
                SeatNumberText.setCaretColor(Color.white);
                SeatNumberText.setEditable(false);
		c.gridy=4;
		c.insets=new Insets(10,30,0,0);
		p.add(SeatNumberText,c);
		TotalAmountText=new JTextArea();
		TotalAmountText.setText(MovieScreen.cost);
                TotalAmountText.setFont(new Font("verdana",Font.PLAIN,18));
                TotalAmountText.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(255,255,255)));
                TotalAmountText.setForeground(Color.white);
                TotalAmountText.setOpaque(false);
                TotalAmountText.setCaretColor(Color.white);
                TotalAmountText.setEditable(false);
		c.gridy=5;
		c.insets=new Insets(10,30,0,0);
		p.add(TotalAmountText,c);
		gt=new JTextArea();
 		gt.setText(MovieScreen.cost);
                gt.setFont(new Font("verdana",Font.PLAIN,18));
                gt.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(255,255,255)));
                gt.setForeground(Color.white);
                gt.setOpaque(false);
                gt.setCaretColor(Color.white);
 		gt.setEditable(false);
 		gt.setVisible(false);
 		c.gridy=7;
 		c.gridx=1;
 		c.insets=new Insets(10,0,0,0);
 		p.add(gt,c);
		back=new JButton("Back");
                back.setForeground(Color.white);
                back.setPreferredSize(new Dimension(100,30));
  		back.setBorder(new LineBorder(new Color(255,255,255)));
                back.setBackground(new Color(0,0,0,0));
                back.setOpaque(false);
		c.gridy=8;
		c.gridx=0;
		c.gridwidth=2;
		c.insets=new Insets(40,0,0,30);
		p.add(back,c);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovieScreen();
				
			}
		});
		code.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://127.0.0.1:3306/bookmymovie","###","####");  
					Statement st=con.createStatement();
					discountAmount=null;
					grantTotal=0;
					ResultSet rs=st.executeQuery("select Discount from coupon where Code='"+couponCode.getText()+"'");
					
					if(rs.next()) {
							
							
			    int d=Integer.parseInt(rs.getString(1));
	                    grantTotal=MovieScreen.TotalCost -(MovieScreen.TotalCost*d/100);
	                    discountAmount=String.valueOf(grantTotal);
	                    
	                    gt.setText(discountAmount);
                             gt.setFont(new Font("verdana",Font.PLAIN,18));
                             gt.setForeground(Color.white);


                            
	                    //System.out.println(discountAmount);
	                    gt.setVisible(true);
	                    total.setVisible(true);
						}
					else	            		
						JOptionPane.showMessageDialog(f, "Invaild Coupon");
					
					

					st.executeUpdate("delete from coupon where Code='"+couponCode.getText()+"'");	
					 con.setAutoCommit(true);
					 con.close();
                    }
				
                    catch(Exception exp)
                    {
                      
                        JOptionPane.showMessageDialog(f, "Something was Wrong");
                        System.out.println(exp);
                    }
				}
			});
		Booking=new JButton("BOOK");	
                Booking.setForeground(Color.white);
                Booking.setPreferredSize(new Dimension(100,30));
  		Booking.setBorder(new LineBorder(new Color(255,255,255)));
                Booking.setBackground(new Color(0,0,0,0));
                Booking.setOpaque(false);
		Booking.addActionListener(this);
		c.gridy=8;
		c.gridx=1;
		c.gridwidth=2;
		//c.weightx = 10;
		c.insets=new Insets(40,30,0,0);
		p.add(Booking,c);
		
		f.add(p);
		f.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		login.getUsername(LoginPage.emailID);
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://127.0.0.1:3306/bookmymovie","###","####");  
			Statement st=con.createStatement();
			
			st.executeUpdate("insert into user values('"+LoginPage.emailID+"','"+login.username+"','"+MovieNameText.getText()+"',"
					+ "'"+selectmovie.Datecombo.getSelectedItem()+"','"+selectmovie.Time.getSelectedItem()+"',"
							+ "'"+SeatNumberText.getText()+"','"+grantTotal+"')");
				
				
			 con.setAutoCommit(true);
			 con.close();
			 JOptionPane.showMessageDialog(f, "Congrats!!Its SHOW TIME");
                         new Canceltickets();		
		}
		catch(Exception exception) {
			System.out.println(exception.getMessage());
			 JOptionPane.showMessageDialog(f, "Something was Wrong");
			 
		}
		
		
			
	}
	
	public static void main(String[] args) {
		new Receipt();
		
	}
}