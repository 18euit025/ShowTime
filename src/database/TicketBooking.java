package database;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Time;

import GUI.LoginPage;


public class TicketBooking {
	
	public boolean booking(String email,String name,String movie,Object date,Object time,String seat,double cost) {
		login.getUsername(LoginPage.emailID);
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://127.0.0.1:3306/bookmymovie","####","####");  
			Statement st=con.createStatement();
			
			st.executeUpdate("insert into user values('"+email+"','"+name+"','"+movie+"',"
					+ "'"+date+"','"+time+"',"+seat+"','"+cost+"')");
				
				
			 con.setAutoCommit(true);
			 con.close();
			return true;
		}
		catch(Exception exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}