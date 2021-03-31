package GUI;
 


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class demo1 implements ActionListener
{
 	JFrame f;
 	//JLabel b;
	JButton b1,b2;
 	demo1()
 	{	
 		f=new JFrame();
 		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 	f.setSize(ScreenSize.width,ScreenSize.height);
  		
  		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		
  		JPanel p1 =new JPanel(new GridBagLayout());
  		GridBagConstraints c=new GridBagConstraints();
  		JLabel p=new JLabel(new ImageIcon("E:\\BookMyShow\\m2.jpg"));
		p.setLayout(new GridBagLayout());
		p1.add(p);
		
		JButton b1=new JButton("ADMIN LOGIN");
		b1.setFont(new Font("verdana",Font.BOLD,20));
  		b1.setPreferredSize(new Dimension(200,50));
  		b1.setBorder(BorderFactory.createMatteBorder(3, 3, 0, 3,new Color(255,255,255)));
//		b1.setBorder(new LineBorder(Color.BLACK));
		b1.setBackground(Color.yellow);
		b1.setForeground(Color.white);
		b1.setOpaque(false);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminLoginPage();
                                f.dispose();
			}
		});
		c.gridx=1;
  		c.gridy=0;
  		
  		c.fill=GridBagConstraints.NORTH;
  		c.insets=new Insets(0,1000,30,0);
  		p.add(b1,c);
		
		JButton b2=new JButton("USER LOGIN");
		b2.setFont(new Font("verdana",Font.BOLD,20));
		b2.setBorder(BorderFactory.createMatteBorder(0, 3, 3, 3,new Color(255,255,255)));
  		b2.setPreferredSize(new Dimension(200,50));
//		b2.setBorder(new LineBorder(Color.BLACK));
		b2.setBackground(Color.yellow);
		b2.setForeground(Color.white);
		b2.setOpaque(false);
  		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new LoginPage();
                        f.dispose();
			}
		});
  		
   		c.gridx=1;
  		c.gridy=1;
  		
  		c.insets=new Insets(0,1000,350,0);
  		p.add(b2,c);
  		 	
  		f.add(p1);
  		f.setVisible(true);
 	}
 	
	public static void main(String aa[])
 	{
  		new demo1();
 	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}