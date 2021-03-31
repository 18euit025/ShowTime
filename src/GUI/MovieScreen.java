package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class MovieScreen implements ActionListener{
	JFrame f;
	JPanel p1;
	JButton back,next,confirm;
	JLabel ss,gs,ps;
	 
	static int TicketCount,TotalCost;
	static String cost,seat;
	String seatArr[];

	List<Component> components = new ArrayList<Component>();
	MovieScreen(){
		   	f = new JFrame();
		   	//f.setSize(500,500);
		   	Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 	f.setSize(ScreenSize.width,ScreenSize.height);
		 	
		   	f.setLayout(new GridBagLayout());
		   	p1=new JPanel(new GridBagLayout());
		   	JLabel p=new JLabel(new ImageIcon("E:\\BookMyShow\\k2.PNG"));
			p.setLayout(new GridBagLayout());
			p1.add(p);
		   	
			GridBagConstraints c=new GridBagConstraints();
		   	
		    for(int i=0;i<8;i++) {
		    	components.add(new JButton("S"+(i+1)));
		    }
		    for(int i=0;i<8;i++) {
		    	components.add(new JButton("G"+(i+1)));
		    }
		    for(int i=0;i<8;i++) {
		    	components.add(new JButton("P"+(i+1)));
		    }
		    //components.get(8).setBackground(Color.blue);
		    String seatArr[]= {"S1","S2","S3","S4","S5","S6","S7","S8","G1","G2","G3","G4","G5","G6","G7","G8",
		    		"P1","P2","P3","P4","P5","P6","P7","P8"};
		  
		    
		    for(int i=0;i<24;i++) {
		    	JButton b=(JButton)components.get(i);
		    	b.addActionListener(this);
		    	b.setForeground(Color.white);
		    	b.setBorder(new LineBorder(Color.white));
				b.setBackground(Color.white);
				b.setForeground(Color.white);
				b.setOpaque(false);
		    	p.add(components.get(i));
		    	if(!b.isEnabled())
		    		b.setEnabled(true);
		    }
		    String decode=selectmovie.pass;
		    String decodeArray[]=decode.split(",");
			   for(String temp: decodeArray) {
				  for(int i=0;i<24;i++)
			    			if(seatArr[i].equals(temp)) {
			    				JButton b=(JButton)components.get(i);
			    				b.setBackground(Color.red);
			    				b.setForeground(Color.red);
			    				b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(255,0,0)));
			    				
			    				b.setOpaque(false);
			    				b.setEnabled(false);
			    			}
			   }
		    back=new JButton("BACK");
		    next=new JButton("NEXT");
		    confirm= new JButton("CONFIRM");
		    
		    back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					new selectmovie();
				}
		    	
		    });
		    confirm.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
				
//				next.setEnabled(true);
				confirm.setEnabled(false);
				confirm.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.GRAY));
				for(int i=0;i<24;i++)
	            	if(components.get(i).getBackground().equals(Color.green) ) {
	            		next.setEnabled(true);
				 		next.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(255,255,0)));
	            	}
				}
		    });
		  
		    next.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					//write the amount calculation in last step of ticket booking....
					TotalCost=0;
					TicketCount=0;
					seat="";
					int array[]=new int[24];
					int arrvar=0;
					for(int i=0;i<24;i++) {
						if(components.get(i).getBackground().equals(Color.green)) {
							array[arrvar]=i;
							arrvar++;
							if(i>=0 && i<8) {
								TotalCost+=100;
								TicketCount++;}
							else if(i>=8 && i<15) {
								TotalCost+=150;
								TicketCount++;}
							else if(i>=15 && i<24) {
								TotalCost+=200;
								TicketCount++;}
							
							
						}		
					}
					for(int j=0;j<arrvar;j++) {
						seat+=seatArr[array[j]]+",";
						
					}
					cost=String.valueOf(TotalCost);
//					System.out.println(seat);
					new Receipt();
					f.dispose();
				}
		    });
		    
		    
		    
		    c.gridy=7;
            c.gridx=0;
            c.insets=new Insets(50,30,0,0);
            back.setPreferredSize(new Dimension(70,30));
			back.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(255,255,0)));
            back.setBackground(new Color(135,206,250));
            back.setForeground(new Color(255,255,0));
            back.setOpaque(false);
            p.add(back,c);
            
            c.gridy=7;
            c.gridx=1;
            c.gridwidth=6;
            c.insets=new Insets(50,30,0,0);
            confirm.setPreferredSize(new Dimension(100,30));
            confirm.setBackground(new Color(135,206,250));
          //  confirm.setBorder(new LineBorder(new Color(255,255,0)));
            confirm.setForeground(new Color(255,255,0));
            confirm.setOpaque(false);
            confirm.setEnabled(false);
            p.add(confirm,c);


            c.gridy=7;
            c.gridx=7;
            c.insets=new Insets(50,30,0,0);
            next.setPreferredSize(new Dimension(70,30));
            next.setBackground(new Color(135,206,250));
           // next.setBorder(new LineBorder(new Color(255,255,0)));
            next.setForeground(new Color(255,255,0));
            next.setOpaque(false);
            next.setEnabled(false);
            
            
            		
            p.add(next,c);

            
		    ss=new JLabel("SILVER SEATS-RS 100");
		    ss.setHorizontalAlignment(JLabel.CENTER);
            ss.setFont(new Font("verdana",Font.BOLD,18));
            ss.setForeground(Color.white);
            c.gridx=0;
            c.gridy=0;
            c.gridwidth=8;
            c.insets=new Insets(0,100,30,0); 
            p.add(ss,c);
            
            gs=new JLabel("GOLDEN SEATS-RS 150");
		    gs.setHorizontalAlignment(JLabel.CENTER);
		    gs.setForeground(Color.white);

            gs.setFont(new Font("verdana",Font.BOLD,18));
            c.gridx=0;
            c.gridy=2;
            c.gridwidth=8;
            c.insets=new Insets(15,100,0,0); 
            p.add(gs,c);
            
            ps=new JLabel("PLATINUM SEATS-RS 200");
            ps.setForeground(Color.white);

            ps.setHorizontalAlignment(JLabel.CENTER);
            ps.setFont(new Font("verdana",Font.BOLD,18));
            c.gridx=0;
            c.gridy=4;
            c.gridwidth=8;
            c.insets=new Insets(15,100,0,0); 
            p.add(ps,c);
		    for(int i=0;i<8;i++) {
		    	c.gridy=1;
		    	c.gridx=i;
		    	c.gridwidth=1;
		    	c.insets=new Insets(0,30,0,0);
		    	components.get(i).setPreferredSize(new Dimension(70,70));
		    	p.add(components.get(i),c);
		    }
		    for(int i=0;i<8;i++) {
		    	c.gridy=3;
		    	c.gridx=i;
		    	c.gridwidth=1;
		    	c.insets=new Insets(30,30,0,0);
		    	components.get(i+8).setPreferredSize(new Dimension(70,70));
		    	p.add(components.get(i+8),c);
		    }
		    for(int i=0;i<8;i++) {
		    	c.gridy=5;
		    	c.gridx=i;
		    	c.gridwidth=1;
		    	c.insets=new Insets(30,30,0,0);
		    	components.get(i+16).setPreferredSize(new Dimension(70,70));
		    	p.add(components.get(i+16),c);
		    }	
		    
		    f.add(p);
		   
		    f.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
 	   	if(b.getBackground().equals(Color.white)) {
 	   		b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(0,255,0)));
 	   		b.setBackground(Color.green);
 	   		b.setForeground(Color.green);
 	   		b.setOpaque(false);}
   	 	else {
   	 		b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(255,255,255)));
   	 		b.setBackground(Color.white);
   	 		b.setForeground(Color.WHITE);
   	 		b.setOpaque(false);
   	 	}
 	   	if(!confirm.isEnabled()) {
 	   		confirm.setEnabled(true);
 	   	    confirm.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(255,255,0)));
 	   		}
 	   	if(next.isEnabled()) {
 	   		next.setEnabled(false);
 	   	    next.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.gray));
 	   		}
	}
	

	
	public static void main(String[] args) {
	
	  new MovieScreen();
	  
	}



}