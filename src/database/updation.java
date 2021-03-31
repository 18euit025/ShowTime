
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class updation 
{
   public boolean updatepass(String s1,String s2,String s3,String s4,String s5)
         {
            try
            {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");
			Statement st=con.createStatement();	
	
			st.executeUpdate("update registration set FirstName='"+s1+"',LastName='"+s2+"',Password='"+s3+"',ConPassword='"+s4+"' where email='"+s5+"'");
					
			 con.setAutoCommit(true);
			 con.close();
			 System.out.println("Success! show");
	   }
	   catch(Exception e) 
           {
			System.out.println(e.getMessage());
			return false;
			
           }
		return true;
	}
   public boolean updatename(String s1,String s2,String s3)
         {
            try
            {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/bookmymovie","root","haritn38ap5586");
			Statement st=con.createStatement();	
	
			st.executeUpdate("update registration set FirstName='"+s1+"',LastName='"+s2+"' where email='"+s3+"'");
					
			 con.setAutoCommit(true);
			 con.close();
			 System.out.println("Success! show");
	   }
	   catch(Exception e) 
           {
			System.out.println(e.getMessage());
			return false;
			
           }
		return true;
	}
	public static void main(String[] args) 
        {
		
			
	}
	    
}
