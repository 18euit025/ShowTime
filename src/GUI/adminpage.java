package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.jdesktop.swingx.JXDatePicker;
import java.util.Date;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import database.Movies;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import javax.swing.filechooser.FileNameExtensionFilter;


public class adminpage implements ActionListener
{
	JTextField MovieNameText,LanguageText,RatingText;
        JButton logout,update,delete,addbutton,upload;
        JXDatePicker fromdate,todate;
        JTable table;
        DefaultTableModel model;
        InputStream in;
        String path="";
        java.sql.Date releasedateDB;
        java.sql.Date enddateDB;
     //   @SuppressWarnings({"OverridableMethodCallInConstructor", "LeakingThisInConstructor", "Convert2Lambda"})
        @SuppressWarnings("Convert2Lambda")
	 public adminpage()
         {
		JFrame frame= new JFrame();
		frame.setSize(500, 500);
		
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(ScreenSize.width,ScreenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p=new JPanel(new GridBagLayout());
		p=new JPanel(new GridBagLayout());
		
		JLabel panel=new JLabel(new ImageIcon("E:\\BookMyShow\\k8.png"));
		panel.setLayout(new GridBagLayout());
		p.add(panel);
		
		GridBagConstraints grid=new GridBagConstraints();
//		panel.setBackground(new Color(100,170,140,255));
		JLabel heading=new JLabel("--ADMIN--");
		heading.setForeground(Color.white);
		heading.setFont(new Font("verdana",Font.PLAIN,25));
		grid.gridy=0;
		grid.gridx=1;
		grid.gridwidth=1;
		grid.insets=new Insets(60,30,0,0);
		panel.add(heading,grid);
		JLabel Language=new JLabel("LANGUAGE");
		Language.setForeground(Color.white);
		Language.setFont(new Font("verdana",Font.PLAIN,18));
		grid.gridy=1;
		grid.gridx=0;
		grid.gridwidth=1;
		grid.insets=new Insets(30,200,0,0);
		panel.add(Language,grid);
		JLabel MovieName=new JLabel("MOVIE");
		MovieName.setForeground(Color.white);
		MovieName.setFont(new Font("verdana",Font.PLAIN,18));
		grid.gridy=2;
		grid.insets=new Insets(30,235,0,0);
		panel.add(MovieName,grid);
                
		JLabel rating=new JLabel("RATING");
		rating.setForeground(Color.white);
		rating.setFont(new Font("verdana",Font.PLAIN,18));
		grid.gridy=3;
		grid.insets=new Insets(30,220,0,0);
		panel.add(rating,grid);
                
		JLabel FromDate=new JLabel("RELEASE DATE");
		FromDate.setForeground(Color.white);
		FromDate.setFont(new Font("verdana",Font.PLAIN,18));
		grid.gridy=4;
		grid.insets=new Insets(30,165,0,0);
		panel.add(FromDate,grid);
		JLabel ToDate=new JLabel("END DATE");
		ToDate.setForeground(Color.white);
		ToDate.setFont(new Font("verdana",Font.PLAIN,18));
		grid.gridy=5;
		grid.insets=new Insets(30,200,0,0);
		panel.add(ToDate,grid);
                
		
		LanguageText=new JTextField(14);
		LanguageText.setFont(new Font("verdana",Font.PLAIN,15));
		LanguageText.setHorizontalAlignment(JTextField.CENTER);
		LanguageText.setForeground(Color.white);
		LanguageText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		LanguageText.setOpaque(false);
		grid.gridy=1;
		grid.gridx=1;
		grid.insets=new Insets(30,90,0,0);
		panel.add(LanguageText,grid);
                
		MovieNameText=new JTextField(14);
		MovieNameText.setFont(new Font("verdana",Font.PLAIN,15));
		MovieNameText.setHorizontalAlignment(JTextField.CENTER);
		MovieNameText.setForeground(Color.white);
		MovieNameText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		MovieNameText.setOpaque(false);
		grid.gridy=2;
		grid.insets=new Insets(30,90,0,0);
		panel.add(MovieNameText,grid);
		
		RatingText=new JTextField(14);
		RatingText.setFont(new Font("verdana",Font.PLAIN,15));
		RatingText.setHorizontalAlignment(JTextField.CENTER);
		RatingText.setForeground(Color.white);
		RatingText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(255,255,255)));
		RatingText.setOpaque(false);
		grid.gridy=3;
		grid.insets=new Insets(30,90,0,0);
		panel.add(RatingText,grid);
                
        

		fromdate = new JXDatePicker();
		fromdate.setDate(Calendar.getInstance().getTime());
		fromdate.setFormats(new SimpleDateFormat("yyyy.MM.dd"));
		fromdate.setFont(new Font("verdana",Font.PLAIN,15));
		fromdate.setPreferredSize(new Dimension(210,30));
		grid.gridy=4;
		grid.insets=new Insets(30,90,0,0);
		panel.add(fromdate,grid);
		frame.getContentPane().add(panel);
             
		todate = new JXDatePicker();
		todate.setDate(Calendar.getInstance().getTime());
		todate.setFormats(new SimpleDateFormat("yyyy.MM.dd"));
		todate.setFont(new Font("verdana",Font.PLAIN,15));
		todate.setPreferredSize(new Dimension(210,30));
		todate.setBackground(new Color(218,251,216));
		todate.setOpaque(false);
		grid.gridy=5;
		grid.insets=new Insets(30,90,0,0);
		panel.add(todate,grid);
		frame.getContentPane().add(panel);
		Date d=todate.getDate();
                
                upload=new JButton("UPLOAD");
                upload.setBackground(new Color(100,170,140,255));
		upload.setBorder(new LineBorder(new Color(255,255,255)));
		upload.setForeground(Color.white);
                upload.addActionListener(this);
		upload.setPreferredSize(new Dimension(100,30));
		upload.setOpaque(false);
                grid.gridy=6;
		grid.gridx=0;
		grid.gridwidth=2;
		grid.insets=new Insets(40,100,0,0);
		panel.add(upload,grid);
            
		addbutton =new JButton("ADD");
		addbutton.addActionListener(this);
		addbutton.setBackground(new Color(100,170,140,255));
		addbutton.setBorder(new LineBorder(new Color(255,255,255)));
		addbutton.setForeground(Color.white);
		addbutton.setPreferredSize(new Dimension(100,30));
		addbutton.setOpaque(false);
		grid.gridy=7;
		grid.gridx=0;
		grid.gridwidth=2;
		grid.insets=new Insets(40,0,0,300);
		panel.add(addbutton,grid);
		
		frame.add(panel);
		frame.setVisible(true);
		
		frame.add(panel);
		frame.setVisible(true);
	       
		update =new JButton("UPDATE");
		update.addActionListener(this);
		update.setForeground(Color.white);
		update.setPreferredSize(new Dimension(100,30));
		update.setBackground(new Color(100,170,140,255));
		update.setBorder(new LineBorder(new Color(255,255,255)));
		update.setOpaque(false);
		grid.gridy=7;
		grid.gridx=0;
//		grid.gridwidth=1;
		grid.insets=new Insets(40,100,0,0);
		panel.add(update,grid);
		
		frame.add(panel);
		frame.setVisible(true);
	       
		delete =new JButton("DELETE");
		delete.addActionListener(this);
		delete.setForeground(Color.white);
		delete.setPreferredSize(new Dimension(100,30));
		delete.setBackground(new Color(100,170,140,255));
		delete.setBorder(new LineBorder(new Color(255,255,255)));
		delete.setOpaque(false);
		grid.gridy=7;
		grid.gridx=1;
		//grid.gridwidth=1;
		grid.insets=new Insets(40,200,0,0);
                
	       panel.add(delete,grid);
               
               logout=new JButton("LOGOUT");
               logout.setForeground(Color.white);
               logout.setPreferredSize(new Dimension(100,30));
               logout.setBackground(new Color(100,170,140,255));
               logout.setBorder(new LineBorder(new Color(255,255,255)));
               logout.setOpaque(false);
               grid.gridx=0;
               grid.gridy=0;
               grid.insets=new Insets(60,0,0,300);
               logout.addActionListener(new ActionListener() {
               //   @SuppressWarnings({"override", "ResultOfObjectAllocationIgnored"})
                  @SuppressWarnings({"ResultOfObjectAllocationIgnored", "override"})
                  public void actionPerformed(ActionEvent e) 
                  {
                     new demo1();
                     frame.dispose();
                  }
               });
               
               panel.add(logout,grid);
                
               String columnheadings[]={"SID","LANGUAGE","MOVIE","RATING","RELEASE_DATE","END_DATE"};
               int rows=0;
               model=new DefaultTableModel(rows,6);
               model.setColumnIdentifiers(columnheadings);
               table=new JTable(model);
               grid.insets=new Insets(0,102,0,0);
                
               grid.gridx=3;
               grid.gridy=0;
//               grid.gridwidth=4;
               grid.gridheight=9;
               JScrollPane sp = new JScrollPane(table);
               table.setPreferredSize(new Dimension(100,710));
               sp.setPreferredSize(new Dimension(640,710));
              
               sp.setBorder(new LineBorder(new Color(238,238,238)));
               table.setRowHeight(30);
               TableColumnModel columnWidth =table.getColumnModel();
               columnWidth.getColumn(0).setPreferredWidth(40);
               columnWidth.getColumn(1).setPreferredWidth(100);
               columnWidth.getColumn(2).setPreferredWidth(200);
               columnWidth.getColumn(3).setPreferredWidth(100);
               columnWidth.getColumn(4).setPreferredWidth(100);
               columnWidth.getColumn(5).setPreferredWidth(100);
               
               showmoviestable();
               table.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt){
                        int i=table.getSelectedRow();
                        LanguageText.setText(model.getValueAt(i, 1).toString());
                        MovieNameText.setText(model.getValueAt(i, 2).toString());
                        RatingText.setText(model.getValueAt(i, 3).toString());
                        fromdate.setDate((Date)model.getValueAt(i, 4));
                        todate.setDate((Date)model.getValueAt(i, 5));
                    }
                });
                panel.add(sp,grid);
                
		frame.add(panel);
		frame.setVisible(true);
		
	}
        @Override
      //  @SuppressWarnings("UseSpecificCatch")
	public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==addbutton)
            {
                try
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date releaseDate=fromdate.getDate();
                    String movie=MovieNameText.getText();
                    String language=LanguageText.getText();
                    String rating=RatingText.getText();
                    Date endingDate=todate.getDate();
                    Date d=new Date();
                    String date3=formatter.format(d);
                    String date1=formatter.format(releaseDate);
                    String date2=formatter.format(endingDate);
                    java.util.Date releasedateStr = formatter.parse(date1);
                    java.util.Date enddateStr = formatter.parse(date2);
                    java.util.Date curdate=formatter.parse(date3);
                     releasedateDB = new java.sql.Date(releasedateStr.getTime());
                     enddateDB=new java.sql.Date(enddateStr.getTime());
                    if(path!="")
                    {
                        File file=new File(path);
                        in = new FileInputStream(file);
                    }
                    if(movie.equals("") || language.equals("") || rating.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Enter The Values");
                    }
                    else if(releasedateDB.compareTo(enddateDB)>=0 || curdate.compareTo(enddateStr)>=0)
                    {
                        JOptionPane.showMessageDialog(null,"Enter Correct Date");
                    }
                    else if("".equals(path))
                    {
                        JOptionPane.showMessageDialog(null,"Select Poster");
                    }
                    else
                    {
                       executeSQLQuery("INSERTED");
                       path="";
                    }
                }
                catch(Exception en)
                {
                    System.out.println(en);
                }
            }
            if(e.getSource()==delete)
            {
                try
                {
                 String movie=MovieNameText.getText();
                 String language=LanguageText.getText();
                 String rating=RatingText.getText();
                 int i=table.getSelectedRow();
                 
                 if(movie.equals("") || language.equals("") || rating.equals(""))
                 {
                        JOptionPane.showMessageDialog(null,"Enter The Values");
                 }
                 
                 else
                 {   
                     
                     executeSQLQuery("DELETED");
                 }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
            if(e.getSource()==update)
            {
                try
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String movie=MovieNameText.getText();
                    String language=LanguageText.getText();
                    String rating=RatingText.getText();
                     Date d=new Date();
                    String date3=formatter.format(d);
                    Date releaseDate=fromdate.getDate();
                    Date endingDate=todate.getDate();
                    String date1=formatter.format(releaseDate);
                    String date2=formatter.format(endingDate);
                    java.util.Date releasedateStr = formatter.parse(date1);
                    java.util.Date enddateStr = formatter.parse(date2);
                    releasedateDB = new java.sql.Date(releasedateStr.getTime());
                    enddateDB=new java.sql.Date(enddateStr.getTime());
                     java.util.Date curdate=formatter.parse(date3);
                    if(path!="")
                    {
                     in = new FileInputStream(path);
                    }
                    if(movie.equals("") || language.equals("") || rating.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Enter The Values");
                    }
                    else if(releasedateDB.compareTo(enddateDB)>=0 || curdate.compareTo(enddateStr)>=0)
                    {
                        JOptionPane.showMessageDialog(null,"Enter Correct Date");
                    }
                  /*  else if("".equals(path))
                    {
                        JOptionPane.showMessageDialog(null,"Select Poster");
                    }*/
                    else
                    {   
                        executeSQLQuery("UPDATED");
                    }
                }
                catch(Exception en)
                {
                    System.out.println(en);
                }
            }
            if(e.getSource()==upload)
            {
                JFileChooser file = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                 file.addChoosableFileFilter(filter);
                 int result = file.showSaveDialog(null);
                 if(result == JFileChooser.APPROVE_OPTION)
                 {
                     File selectedFile = file.getSelectedFile();
                     path = selectedFile.getAbsolutePath();
                    //label.setIcon(ResizeImage(path));
                 }
                 else if(result == JFileChooser.CANCEL_OPTION)
                 {
                    System.out.println("No File Select");
                 }
            }
	}
   //     @SuppressWarnings("UseSpecificCatch")
        public Connection getConnection()
        {
            Connection connection=null;
            try
            {
                connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookmymovie", "root", "haritn38ap5586");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return connection;
        }
       // @SuppressWarnings("UseSpecificCatch")
        public ArrayList<Movies> ListMovies()
        {
        //@SuppressWarnings("Convert2Diamond")
            ArrayList<Movies> MoviesList=new ArrayList<Movies>();
            Statement statement;
            ResultSet resultset;
            try
            {
                Connection connection=getConnection();
                statement=connection.createStatement();
                String query="select * from movie1";
                resultset=statement.executeQuery(query);
                Movies movies;
                while(resultset.next())
                {
                    movies=new Movies(
                            resultset.getInt("SID"),
                            resultset.getString("LANGUAGE"),
                            resultset.getString("MOVIE"),
                            resultset.getFloat("RATING"),
                            resultset.getDate("RELEASE_DATE"),
                            resultset.getDate("END_DATE"));
                    MoviesList.add(movies);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return MoviesList;
        }
        public void showmoviestable()
        {
            ArrayList<Movies> list=ListMovies();
             model=(DefaultTableModel)table.getModel();
             Object[] row=new Object[6];
             for(int i=0;i<list.size();i++)
             {
                 row[0]=list.get(i).getId();
                 row[1]=list.get(i).getLanguage();
                 row[2]=list.get(i).getMovie();
                 row[3]=list.get(i).getRating();
                 row[4]=list.get(i).getRelease();
                 row[5]=list.get(i).getEnd();
                 model.addRow(row);
             }
        }
        //@SuppressWarnings("UseSpecificCatch")
        public void executeSQLQuery(String message)
        {
            Connection connection=getConnection();
            PreparedStatement statement;
            Statement statement1;
            boolean flag=true;
            try
            {
                statement1=connection.createStatement();
                if("INSERTED".equals(message))
                {
                    ResultSet resultset=statement1.executeQuery("select * from movie1");
                    while(resultset.next())
                    {
                           String language=LanguageText.getText();
                           String movie=MovieNameText.getText();
                           String sql_language=resultset.getString("LANGUAGE");
                           String sql_movie=resultset.getString("MOVIE");
                           if(movie.equals(sql_movie))
                           {
                               if(language.equals(sql_language))
                               {
                                   flag=false;
                               }
                           }
                    }
                }
                if(flag)
                {
                    int i=table.getSelectedRow();
                    if("INSERTED".equals(message))
                    {
                        statement=connection.prepareStatement("insert into movie1(LANGUAGE,MOVIE,RATING,RELEASE_DATE,END_DATE,POSTER) values(?,?,?,?,?,?)");
                        statement.setString(1,LanguageText.getText());
                        statement.setString(2,MovieNameText.getText());
                        statement.setString(3,RatingText.getText());
                        statement.setDate(4,releasedateDB );
                        statement.setDate(5, enddateDB);
                        statement.setBlob(6, in);
                    }
                    else if("UPDATED".equals(message))
                    {
                        statement=connection.prepareStatement("update movie1 set LANGUAGE=?,MOVIE=?,RATING=?,RELEASE_DATE=?,END_DATE=?,POSTER=? where SID=?");
                        statement.setString(1,LanguageText.getText());
                        statement.setString(2,MovieNameText.getText());
                        statement.setString(3,RatingText.getText());
                        statement.setDate(4,releasedateDB );
                        statement.setDate(5, enddateDB);
                        statement.setBlob(6, in);
                        statement.setInt(7,Integer.valueOf(model.getValueAt(i, 0).toString()));
                    }
                    else
                    {
                        statement=connection.prepareStatement("delete from movie1 where SID=?");
                        statement.setInt(1,Integer.valueOf(model.getValueAt(i, 0).toString()));
                    }
                    if(statement.executeUpdate()==1)
                    {
                       model=(DefaultTableModel)table.getModel();
                       model.setRowCount(0);
                       showmoviestable();
                       JOptionPane.showMessageDialog(null,"Data "+message+" Successfully");
                       LanguageText.setText(null);
                       MovieNameText.setText(null);
                       RatingText.setText(null);
                       path="";
                    }
                    else
                    {
                       JOptionPane.showMessageDialog(null,"Data Not "+message);
                    }
                }
                else
                {
                   JOptionPane.showMessageDialog(null,"Data Not "+message);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        //@SuppressWarnings("ResultOfObjectAllocationIgnored")
	public static void main(String[] args) 
        {
		new adminpage();
	}
}