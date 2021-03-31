package database;


import java.sql.*;

public class Registration {
	
	 public boolean Register(String s1,String s2,String s3,String s4,String s5){
try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");  
			Statement st=con.createStatement();
			
			
	
			st.executeUpdate("insert into registration values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
				
				
			 con.setAutoCommit(true);
			 con.close();
			 System.out.println("Success! show");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
			
		}
		return true;
	}
	public static void main(String[] args) {
		
			
	}
	
}