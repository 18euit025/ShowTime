package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AdminLoginPage {
	JFrame f;
	JTextField UserText;
	JPasswordField PasswordText;
	JLabel UserLabel, PasswordLabel;
	JButton LoginButton,RegButton;
    
    AdminLoginPage(){
    	f= new JFrame();
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 	f.setSize(ScreenSize.width,ScreenSize.height);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1=new JPanel(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		JLabel p=new JLabel(new ImageIcon("E:\\BookMyShow\\k4.png"));
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
		//UserText.setBorder(new LineBorder(new Color(255,255,255)));
		UserText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		UserText.setOpaque(false);
		UserText.setCaretColor(Color.WHITE);
		c.gridy=0;
		c.insets=new Insets(0,30,0,0);
		p.add(UserText,c);
		
		
		
		PasswordText=new JPasswordField(20);
		PasswordText.setForeground(Color.white);
		PasswordText.setFont(new Font("verdana",Font.PLAIN,15));
		PasswordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		PasswordText.setCaretColor(Color.WHITE);
		PasswordText.setOpaque(false);
		c.gridy=1;
		
		c.insets=new Insets(30,30,0,0);
		p.add(PasswordText,c);
		
		LoginButton =new JButton("LOGIN");
		LoginButton.setForeground(Color.white);
		LoginButton.setPreferredSize(new Dimension(100,30));
		LoginButton.setBorder(new LineBorder(new Color(255,255,255)));
		LoginButton.setBackground(new Color(0,0,0,0));
		LoginButton.setOpaque(false); 
		LoginButton.setPreferredSize(new Dimension(200,30));
		c.gridy=2;
		c.gridwidth=2;
		c.insets=new Insets(50,100,0,0);
		p.add(LoginButton,c);
		 
    
    LoginButton.addActionListener(new ActionListener(){ 
        @Override 
        @SuppressWarnings("ResultOfObjectAllocationIgnored")
        public void actionPerformed(ActionEvent e)
        {
            String email=UserText.getText();
            String password=PasswordText.getText();
       
        if(email.equals("")){
            JOptionPane.showMessageDialog(f,"Email id is mandatory");  
        }
        else if(password.equals("")){
            JOptionPane.showMessageDialog(f,"Password is mandatory");
        }
        else if(!(email.equals("18euit159@skcet.ac.in"))){
            JOptionPane.showMessageDialog(null,"User name mismatch");
        }  
        else if(!(password.equals("sudha@159"))){
            JOptionPane.showMessageDialog(null,"Password mismatch");
              } 
        else if(!(email.equals("18euit159@skcet.ac.in") && password.equals("sudha@159"))){
                JOptionPane.showMessageDialog(null,"Invalid user name & password!");
              }
        else{
           new adminpage();
           f.dispose();
        }
      
        }});   
  
    	f.add(p1);
       	
        f.setVisible(true);     
    }
    public static void main(String args[]){
        new AdminLoginPage();
    }
}