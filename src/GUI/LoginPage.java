package GUI;

import database.login;
//import GUI.SelectMovie;
//import GUI.RegistrationForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class LoginPage implements ActionListener{
	JFrame f;
	JTextField UserText;
	JPasswordField PasswordText;
	JLabel UserLabel, PasswordLabel;
	JButton LoginButton,RegButton;
	public static String emailID;
	public LoginPage(){
		f= new JFrame();
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 	f.setSize(ScreenSize.width,ScreenSize.height);
		//f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1=new JPanel(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		JLabel p=new JLabel(new ImageIcon("E:\\BookMyShow\\k1.png"));
		p.setLayout(new GridBagLayout());
		p1.add(p);
		
		
		UserLabel=new JLabel("Email ID");
		UserLabel.setForeground(Color.white);
		UserLabel.setFont(new Font("verdana",Font.PLAIN,18));
		p.add(UserLabel);
		
		PasswordLabel=new JLabel("Password");
		PasswordLabel.setForeground(Color.white);
		PasswordLabel.setFont(new Font("verdana",Font.PLAIN,18));
		c.gridy=1;
		c.insets=new Insets(30,0,0,0);
		p.add(PasswordLabel,c);
		
		
		
		UserText=new JTextField(20);
//		UserText.setPreferredSize(new Dimension(70,30));
		UserText.setForeground(Color.white);
		UserText.setFont(new Font("verdana",Font.PLAIN,15));
		UserText.setBorder(new LineBorder(new Color(255,255,255)));
		UserText.setOpaque(false);
		
		c.gridy=0;
		c.insets=new Insets(0,30,0,0);
		p.add(UserText,c);
				
		
		PasswordText=new JPasswordField(20);
		PasswordText.setForeground(Color.white);
		PasswordText.setFont(new Font("verdana",Font.PLAIN,15));
		PasswordText.setBorder(new LineBorder(new Color(255,255,255)));
		PasswordText.setOpaque(false);
		c.gridy=1;
		
		c.insets=new Insets(30,30,0,0);
		p.add(PasswordText,c);
		
		LoginButton =new JButton("login");
		LoginButton.setForeground(Color.white);
		LoginButton.setPreferredSize(new Dimension(100,30));
		LoginButton.setBorder(new LineBorder(new Color(255,255,255)));
		LoginButton.setBackground(new Color(0,0,0,0));
		LoginButton.setOpaque(false); 
		LoginButton.addActionListener(this);
		c.gridy=2;
		c.insets=new Insets(30,30,0,0);
		p.add(LoginButton,c);
		 
		RegButton =new JButton("Register");
		RegButton.setForeground(Color.white);
		RegButton.setPreferredSize(new Dimension(100,30));
		RegButton.setBorder(new LineBorder(new Color(255,255,255)));
		RegButton.setBackground(new Color(0,0,0,0));
		RegButton.setOpaque(false);
		RegButton.addActionListener(this);
		c.gridy=2;
		c.gridx=1;
		c.insets=new Insets(30,0,0,0);
		p.add(RegButton,c);
		
		f.add(p);
		f.setVisible(true);
			}
	@Override
	public void actionPerformed(ActionEvent e) {
		String email=UserText.getText();
		String password=PasswordText.getText();
		
		if(e.getSource()==LoginButton) {
			if(new login().LoginCheck(email, password)) {
				emailID=email;
				
				new Canceltickets();
                                f.dispose();
			}
			else
				JOptionPane.showMessageDialog(f,"Invaild Email ID/Password");
		}
		else if(e.getSource()==RegButton)
                {
			new RegistrationForm();
                        f.dispose();
                }
	}
	
	
	
	public static void main(String[] args) {
		new LoginPage();

	}
}