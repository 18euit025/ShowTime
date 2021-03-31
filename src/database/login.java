package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import GUI.LoginPage;

//import com.mysql.cj.protocol.Resultset;

public class login {
		public static String username;
		 public boolean LoginCheck(String email,String password){
	try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");  
				Statement st=con.createStatement();
			
//				username ="";
//				ResultSet rs=st.executeQuery( "select FirstName,LastName from registration where email='"+LoginPage.emailID+"'");
				
		
				 ResultSet rs=st.executeQuery( "select * from registration where email='"+email+"' and Password='"+password+"'");
				 if(rs.next()) {
					
					 return true;
				 }
				 else
					 return false;
				 
//				 con.setAutoCommit(true);
//				 con.close();
				 //System.out.println("Success! show");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
				
			}
			
		}
	 public static void getUsername(String email){
				try {
							
							Class.forName("com.mysql.cj.jdbc.Driver");  
							Connection con=DriverManager.getConnection(  
							"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");  
							Statement st=con.createStatement();
						
							username ="";
					
							 ResultSet rs=st.executeQuery( "select FirstName,LastName from registration where email='"+email+"'");
							
							while(rs.next())
										username+=rs.getString(1)+" "+rs.getString(2);
						
							 
							 con.setAutoCommit(true);
							 con.close();
							 
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						
						}	
				}

		
		public static void main(String[] args) {
//			System.out.println(LoginCheck("spidy@gmail.com","aA2@aA2@"));
//			getUsername("spidy@gmail.com");
//			 System.out.println(username);
		}
}