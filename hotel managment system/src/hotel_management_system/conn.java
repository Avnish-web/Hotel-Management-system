package hotel_management_system;

import java.sql.*;
 public class conn {

		Connection c; 
		Statement s;
		 conn() {
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","0000");
				 s = c.createStatement();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new conn();
	}

}
