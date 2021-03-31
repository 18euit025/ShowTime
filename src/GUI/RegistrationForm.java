package GUI;
import database.Registration;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.LineBorder;
public class RegistrationForm implements ActionListener {
	JFrame f;
	JPanel p1;
	String s1,s2,s3,s4,s5;
	JTextField FirstNameText,LastNameText,emailText,PasswordText,ConPasswordText;
	 public RegistrationForm(){
		 f= new JFrame();
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 	f.setSize(ScreenSize.width,ScreenSize.height);
		
	 	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1=new JPanel(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
                
		JLabel p=new JLabel(new ImageIcon("E:\\BookMyShow\\l1.png"));
		p.setLayout(new GridBagLayout());
		p1.add(p);
                
		JLabel heading=new JLabel("----------Register----------");
                heading.setForeground(Color.white);
		heading.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=0;
		c.gridx=1;
		c.insets=new Insets(10,0,30,100);
		p.add(heading,c);
                
		JLabel FirstName=new JLabel("First Name");
                FirstName.setForeground(Color.white);
		FirstName.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=1;
		c.gridx=0;
		c.insets=new Insets(0,0,0,0);
		p.add(FirstName,c);
                
		JLabel LastName=new JLabel("Last Name");
                LastName.setForeground(Color.white);
		LastName.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=2;
		c.insets=new Insets(10,0,0,0);
		p.add(LastName,c);

		JLabel email=new JLabel("email");
                email.setForeground(Color.white);
		email.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=3;
		c.insets=new Insets(10,0,0,0);
		p.add(email,c);
                
		JLabel PasswordLabel=new JLabel("Password");
                PasswordLabel.setForeground(Color.white);
		PasswordLabel.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=4;
		c.insets=new Insets(10,0,0,0);
		p.add(PasswordLabel,c);
                
                
		JLabel ConPasswordLabel=new JLabel(" Confirm Password");
                ConPasswordLabel.setForeground(Color.white);
		ConPasswordLabel.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=5;
		c.insets=new Insets(10,0,0,0);
		p.add(ConPasswordLabel,c);
		
		FirstNameText=new JTextField(20);
		c.gridy=1;
		c.gridx=1;
                FirstNameText.setFont(new Font("verdana",Font.PLAIN,16));
                FirstNameText.setForeground(Color.white);
		c.insets=new Insets(13,30,0,0);
		p.add(FirstNameText,c);
                
                FirstNameText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		FirstNameText.setOpaque(false);
		FirstNameText.setCaretColor(Color.WHITE);
                        
		LastNameText=new JTextField(20);
		c.gridy=2;
		c.insets=new Insets(13,30,0,0);
                LastNameText.setFont(new Font("verdana",Font.PLAIN,16));
                LastNameText.setForeground(Color.white);
		p.add(LastNameText,c);
                LastNameText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		LastNameText.setOpaque(false);
		LastNameText.setCaretColor(Color.WHITE);
                        
		emailText=new JTextField(20);
		c.gridy=3;
		c.insets=new Insets(10,30,0,0);
                emailText.setForeground(Color.white);
                emailText.setFont(new Font("verdana",Font.PLAIN,16));
		p.add(emailText,c);
                emailText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		emailText.setOpaque(false);
                emailText.setCaretColor(Color.WHITE);
                
		PasswordText=new JPasswordField(20);
		c.gridy=4;
		c.insets=new Insets(10,30,0,0);
                PasswordText.setForeground(Color.white);
                PasswordText.setFont(new Font("verdana",Font.PLAIN,16));
		p.add(PasswordText,c);
                PasswordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		PasswordText.setOpaque(false);
                PasswordText.setCaretColor(Color.WHITE);
                
                
		ConPasswordText=new JPasswordField(20);
		c.gridy=5;
		c.insets=new Insets(10,30,0,0);
                ConPasswordText.setForeground(Color.white);
                ConPasswordText.setFont(new Font("verdana",Font.PLAIN,16));
		p.add(ConPasswordText,c);
                ConPasswordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		ConPasswordText.setOpaque(false);
                ConPasswordText.setCaretColor(Color.WHITE);
		 
		JButton RegButton =new JButton("Register");
                RegButton.setForeground(Color.white);
		RegButton.setPreferredSize(new Dimension(100,30));
		RegButton.setBorder(new LineBorder(new Color(255,255,255)));
		RegButton.setBackground(new Color(0,0,0,0));
		RegButton.setOpaque(false); 
		RegButton.addActionListener(this);
		
		
		c.gridy=6;
		c.gridx=0;
		c.gridwidth=2;
		//c.weightx = 10;
		c.insets=new Insets(10,0,0,0);
		p.add(RegButton,c);
		
		f.add(p);
		f.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		s1=FirstNameText.getText();
		 s2=LastNameText.getText();
		 s3=emailText.getText();
		 s4=PasswordText.getText();
		s5=ConPasswordText.getText();
		
		String regex1 = "^[A-Za-z0-9+_]+@(.+)$";
        Pattern p1=Pattern.compile(regex1);
        Matcher m1=p1.matcher(s3);
        
        String regex3 = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";;
        Pattern p3=Pattern.compile(regex3);
        Matcher m3=p3.matcher(s4); 
        
		if(s1.isEmpty())
			JOptionPane.showMessageDialog(f,"FirstName can't be empty");
		else if(s2.isEmpty())
			JOptionPane.showMessageDialog(f,"LastName can't be empty");
		else if(s3.isEmpty())
			JOptionPane.showMessageDialog(f,"email can't be empty");
		else if(!m1.matches())
             JOptionPane.showMessageDialog(f,"E-mail is not in correct format!");
   		else if(s4.isEmpty())
			JOptionPane.showMessageDialog(f,"Password can't be empty");
   		else if(!m3.matches())
            JOptionPane.showMessageDialog(f,"Password is not strong!");
		else if(s5.isEmpty())
			JOptionPane.showMessageDialog(f,"Please enter the password again");
		else if(!s4.equals(s5)) 
			JOptionPane.showMessageDialog(f,"Password are not same"); 	 
	    
	        
		
		if(!s1.isEmpty()&& !s2.isEmpty()&& s3.isEmpty()==false &&s4.isEmpty()==false &&
				s5.isEmpty()==false && s4.equals(s5) &&m1.matches() &&m3.matches())
			if(!new Registration().Register(s1,s2,s3,s4,s5)) {
				JOptionPane.showMessageDialog(f,"Duplicate entry ");
                                FirstNameText.setText(null);
                                LastNameText.setText(null);
                                emailText.setText(null);
                                PasswordText.setText(null);
                                ConPasswordText.setText(null);
			}
			else {
				JOptionPane.showMessageDialog(f,"sucess");
				new LoginPage();
                                f.dispose();
			}			
	}
	public static void main(String[] args) {
		//String s1,s2,s3,s4,s5;
		new RegistrationForm();	
	}

}