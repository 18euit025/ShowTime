package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Cancel {
	public void Canceling(String email,String name,String movie,String date,String time,String seat){
		try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://127.0.0.1:3306/bookmymovie","####","####");  
					Statement st=con.createStatement();
					
					
			
					st.executeUpdate("delete from user where emailID='"+email+"' and movie='"+movie+"' "
							+ "and showdate='"+date+"' and showtime='"+time+"' and seat='"+seat+"'");
						
						
					 con.setAutoCommit(true);
					 con.close();
					 //System.out.println("Success! show");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					
					
				}
				
			}
			public static void main(String[] args) {
				
					
			}
}