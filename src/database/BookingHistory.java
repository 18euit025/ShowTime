package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;



import GUI.LoginPage;

public class BookingHistory {
	public static String HMovie,HDate,HTime,HSeat;
	public static int CurrentMovie=0,MovieSize=0;
	public ArrayList<MovieDetails> moviedetails=new ArrayList<MovieDetails>();
	public boolean HistoryCheck() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");
			Statement st=con.createStatement();
		
			
	
			 ResultSet rs=st.executeQuery( "select * from user where emailID='"+LoginPage.emailID+"'");
			 if(rs.next()) 
				 return true;
			 else
				 return false;
			     				 
//			 con.setAutoCommit(true);
//			 con.close();
			
		}
		catch(Exception exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}
	public void FetchingHistory(String email) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");
			Statement st=con.createStatement();	
	
			ResultSet rs=st.executeQuery( "select movie,showdate,showtime,seat from user where emailID='"+email+"'");
//			ResultSetMetaData rsmd = rs.getMetaData();
		//	int columnsNumber = rsmd.get
			while(rs.next()) {
				 MovieDetails md=new MovieDetails();
				 
				 md.HMovie=rs.getString(1);
				 md.HDate=rs.getString(2);
				 md.HTime=rs.getString(3);
				 md.HSeat=rs.getString(4);
				 moviedetails.add(md);
				// System.out.println(rs.getString(1)+"  -- "+rs.getString(2));
			 }
//			 CurrentMovie=0;
			 MovieSize=moviedetails.size();
			 DisplayCurrentMovie(CurrentMovie);
			     				 
			 con.setAutoCommit(true);
			 con.close();
			
		}
		catch(Exception exception) {
			System.out.println(exception.getMessage());
			
		}}
	public void DisplayCurrentMovie(int index) {
		 MovieDetails md1=moviedetails.get(index);
		 HMovie=md1.HMovie;
		 HDate=md1.HDate;
		 HTime=md1.HTime;
		 HSeat=md1.HSeat;
	}

	public static void main(String args[]) {
		
	
	}
	
}