package GUI;

import database.updation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class updateprofile implements ActionListener {
	static JTextField FirstNameText,LastNameText,emailText,OldPasswordText,PasswordText,ConPasswordText;
        JButton pass,save,update;
        JFrame f;
        JPanel p1;
        JLabel p,OldPasswordLabel,PasswordLabel,ConPasswordLabel;
        boolean flag=false,flagUpdate=false;
        String s1,s2,s3,s4,s5,s6,password;
        GridBagConstraints c;
	 public updateprofile(){
	        f= new JFrame();
		
		
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setSize(ScreenSize.width,ScreenSize.height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	f.setLayout(new GridBagLayout());
	   	p1=new JPanel(new GridBagLayout());
	   	p=new JLabel(new ImageIcon("E:\\BookMyShow\\k3.PNG"));
		p.setLayout(new GridBagLayout());
		p1.add(p);
		c=new GridBagConstraints();
		
		JLabel heading=new JLabel("----------USER UPDATE----------");
		heading.setFont(new Font("verdana",Font.PLAIN,15));
		heading.setForeground(Color.white);
		c.gridy=0;
		c.gridx=1;
		c.insets=new Insets(0,0,30,100);
		p.add(heading,c);
		JLabel FirstName=new JLabel("First Name");
		FirstName.setFont(new Font("verdana",Font.PLAIN,15));
		FirstName.setForeground(Color.white);
		c.gridy=1;
		c.gridx=0;
		c.insets=new Insets(10,0,0,0);
		p.add(FirstName,c);
		JLabel LastName=new JLabel("Last Name");
		LastName.setFont(new Font("verdana",Font.PLAIN,15));
		LastName.setForeground(Color.white);
		c.gridy=2;
		c.insets=new Insets(20,0,0,0);
		p.add(LastName,c);
		JLabel email=new JLabel("Email");
		email.setFont(new Font("verdana",Font.PLAIN,15));
		email.setForeground(Color.white);
		c.gridy=3;
		c.insets=new Insets(20,0,0,0);
		p.add(email,c);
        OldPasswordLabel=new JLabel("Old Password");
        OldPasswordLabel.setFont(new Font("verdana",Font.PLAIN,15));
		OldPasswordLabel.setForeground(Color.white);
        c.gridy=4;
        c.insets=new Insets(20,0,0,0);
        OldPasswordLabel.setVisible(false);
        p.add(OldPasswordLabel,c);
        PasswordLabel=new JLabel("New Password");
        PasswordLabel.setFont(new Font("verdana",Font.PLAIN,15));
		PasswordLabel.setForeground(Color.white);
		c.gridy=5;
		c.insets=new Insets(20,0,0,0);
		PasswordLabel.setVisible(false);
		p.add(PasswordLabel,c);
		ConPasswordLabel=new JLabel(" Confirm Password");
		ConPasswordLabel.setFont(new Font("verdana",Font.PLAIN,15));
		ConPasswordLabel.setForeground(Color.white);
		c.gridy=6;
		c.insets=new Insets(20,0,0,0);
		ConPasswordLabel.setVisible(false);
		p.add(ConPasswordLabel,c);
		
		FirstNameText=new JTextField(15);
		FirstNameText.setFont(new Font("verdana",Font.PLAIN,15));
		//FirstNameText.setPreferredSize(new Dimension(100,30));
  		FirstNameText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		FirstNameText.setBackground(Color.yellow);
		FirstNameText.setForeground(Color.white);
		FirstNameText.setCaretColor(Color.white);
		FirstNameText.setOpaque(false);
		c.gridy=1;
		c.gridx=1;
                
		c.insets=new Insets(10,0,0,0);
		p.add(FirstNameText,c);
		LastNameText=new JTextField(15);
		LastNameText.setFont(new Font("verdana",Font.PLAIN,15));
		
  		LastNameText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		LastNameText.setBackground(Color.yellow);
		LastNameText.setForeground(Color.white);
		LastNameText.setCaretColor(Color.white);
		LastNameText.setOpaque(false);
		c.gridy=2;
		c.insets=new Insets(20,0,0,0);
        p.add(LastNameText,c);
		
//        emailText=new JTextField(20);
        emailText=new JTextField(15);
		emailText.setFont(new Font("verdana",Font.PLAIN,15));
		
  		emailText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		emailText.setBackground(Color.yellow);
		emailText.setForeground(Color.white);
		emailText.setCaretColor(Color.white);
		emailText.setOpaque(false);
        c.gridy=3;
		c.insets=new Insets(20,0,0,0);
		emailText.setText(LoginPage.emailID);
		emailText.setEditable(false);
		p.add(emailText,c);
		
		OldPasswordText=new JPasswordField(15);
		OldPasswordText.setFont(new Font("verdana",Font.PLAIN,15));
		OldPasswordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		OldPasswordText.setBackground(Color.yellow);
		OldPasswordText.setForeground(Color.white);
		OldPasswordText.setCaretColor(Color.white);
		OldPasswordText.setOpaque(false);
		c.gridy=4;
		c.insets=new Insets(20,0,0,0);
		OldPasswordText.setVisible(false);
		p.add(OldPasswordText,c);
		password=updateprofile.data();

		PasswordText=new JPasswordField(15);
		PasswordText.setFont(new Font("verdana",Font.PLAIN,15));
  		PasswordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		PasswordText.setBackground(Color.yellow);
		PasswordText.setForeground(Color.white);
		PasswordText.setCaretColor(Color.white);
		PasswordText.setOpaque(false);
		c.gridy=5;
		c.insets=new Insets(20,0,0,0);
		PasswordText.setVisible(false);
		p.add(PasswordText,c);
		ConPasswordText=new JPasswordField(15);
		ConPasswordText.setFont(new Font("verdana",Font.PLAIN,15));
  		ConPasswordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		ConPasswordText.setBackground(Color.yellow);
		ConPasswordText.setForeground(Color.white);
		ConPasswordText.setCaretColor(Color.white);
		ConPasswordText.setOpaque(false);
		c.gridy=6;
		c.insets=new Insets(20,0,0,0);
		ConPasswordText.setVisible(false);
		p.add(ConPasswordText,c);

		 
	    pass =new JButton("Change Password");
	    pass.setFont(new Font("verdana",Font.PLAIN,15));
  		pass.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(255,255,255)));
		pass.setBackground(Color.yellow);
		pass.setForeground(Color.white);pass.setOpaque(false);
		pass.addActionListener(this);
		pass.setPreferredSize(new Dimension(200,25));
		c.gridy=8;
		c.gridx=1;
		c.gridwidth=1;
		//c.weightx = 10;
		c.insets=new Insets(20,0,0,0);
		p.add(pass,c);
		
		f.add(p);
		f.setVisible(true);
             
		JButton update =new JButton("Update");
		update.setFont(new Font("verdana",Font.PLAIN,15));
		update.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(255,255,255)));
		update.setBackground(Color.yellow);
		update.setForeground(Color.white);update.setOpaque(false);
		update.addActionListener(this);
		update.setPreferredSize(new Dimension(200,25));	
		c.gridy=7;
		c.gridx=1;
		c.gridwidth=1;
		update.setPreferredSize(new Dimension(200,25));
		c.insets=new Insets(20,0,0,0);
		p.add(update,c);
      
                
		update.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    FirstNameText.setEditable(true);
                    LastNameText.setEditable(true);
                    update.setVisible(false);
                    flagUpdate=true;
                }
        });
		
	
                
        save =new JButton("Save");
		save.addActionListener(this);
		save.setFont(new Font("verdana",Font.PLAIN,15));
		save.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(255,255,255)));
		save.setBackground(Color.yellow);
		save.setForeground(Color.white);
		save.setOpaque(false);
		save.addActionListener(this);
		save.setPreferredSize(new Dimension(200,25));
		
		c.gridy=9;
		c.gridx=1;
		c.gridwidth=1;
		//c.weightx = 10;
		c.insets=new Insets(20,0,0,0);
		p.add(save,c);
		
		f.add(p);
		f.setVisible(true);
		
	 }
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==pass)
                {
                    OldPasswordLabel.setVisible(true);
                    PasswordLabel.setVisible(true);
                    ConPasswordLabel.setVisible(true);
                    OldPasswordText.setVisible(true);
                    PasswordText.setVisible(true);
                    ConPasswordText.setVisible(true);
                    flag=true;
                    pass.setVisible(false);
//                    c.insets=new Insets(10,110,0,10);
//            		p.add(save,c);
                }
                if(e.getSource()==save)
                {
                    s1=FirstNameText.getText();
                    s2=LastNameText.getText();
                    s6=emailText.getText();
                    s3=OldPasswordText.getText();
                    s4=PasswordText.getText();
                    s5=ConPasswordText.getText();
                    
                    String regex3 = "^(?=.*[0-9])"
                    		+ "(?=.[a-z])(?=.[A-Z])"
                    		+ "(?=.*[@#$%^&+=])"
                    		+ "(?=\\S+$).{8,20}$";
                    Pattern p3=Pattern.compile(regex3);
                    Matcher m3=p3.matcher(s4);
                    
                if(s1.isEmpty())
                	JOptionPane.showMessageDialog(f,"FirstName can't be empty");
                else if(s2.isEmpty())
                	JOptionPane.showMessageDialog(f,"LastName can't be empty");
               
                else if(flag==true)
                    {
                    if(s3 == null ? password != null : !s3.equals(password))
                         JOptionPane.showMessageDialog(f,"Old Password is InCorrect");
                    else if(s4.isEmpty())
                    	JOptionPane.showMessageDialog(f,"Password can't be empty");
                    else if(!m3.matches())
                         JOptionPane.showMessageDialog(f,"Password is not strong!");
                    else if(s5.isEmpty())
                    	JOptionPane.showMessageDialog(f,"Please enter the password again");
                    else if(!s4.equals(s5)) 
                    	JOptionPane.showMessageDialog(f,"Password are not same");
                    
                    if(!s1.isEmpty()&& !s2.isEmpty()&& s3 == null ? password != null : !s3.equals(password)==false &&s4.isEmpty()==false &&
                    		s5.isEmpty()==false && s4.equals(s5)  &&m3.matches()) 
                    if(!new updation().updatepass(s1,s2,s4,s5,s6)) {
                    	JOptionPane.showMessageDialog(f,"Not Updated");
            		}
                    else {
                    		JOptionPane.showMessageDialog(f,"sucess");
                    		FirstNameText.setEditable(false);
                    		LastNameText.setEditable(false);
		                 	OldPasswordLabel.setVisible(false);
		                 	PasswordLabel.setVisible(false);
                                 ConPasswordLabel.setVisible(false);
                                 OldPasswordText.setVisible(false);
                                 PasswordText.setVisible(false);
                                 ConPasswordText.setVisible(false);   
                                 pass.setVisible(true);
                                 if(flagUpdate==true)
                                	 update.setVisible(true);
                                 
                    }
                 }
                else
                    {
                        if(!s1.isEmpty()&& !s2.isEmpty())
                        {
                            if(!new updation().updatename(s1,s2,s6)) {
                            	JOptionPane.showMessageDialog(f,"Not Updated");
                            }
                      else {
                    	 // JOptionPane.showMessageDialog(f,"sucess");
                    	  FirstNameText.setEditable(false);
                    	  LastNameText.setEditable(false);
                    	  new Canceltickets();
                    	  f.dispose();
//                    	 
                      }
                      }
                    }
                }
	}
        public static String data()
        {
            String password="";
            try 
            {
            	Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");  
				
			Statement statement=con.createStatement();
                        ResultSet resultset=statement.executeQuery("select * from registration");
                        while(resultset.next())
                        {
                            String email=resultset.getString("email");
                            if(email == null ? LoginPage.emailID == null : email.equals(LoginPage.emailID))
                            {
                                FirstNameText.setText(resultset.getString("FirstName"));
                                LastNameText.setText(resultset.getString("LastName"));
                                password=resultset.getString("Password");
                                FirstNameText.setEditable(false);
                                LastNameText.setEditable(false);
                            }
                        }           
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
            return password;
        }
    	public static void main(String[] args) {
    		new updateprofile();
    		
    	}

    }