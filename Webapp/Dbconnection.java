package Webapp;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class Dbconnection {
	private static Connection con = null;
	static{ 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Driver found");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found: " + e);
		}
		
		String url="jdbc:mysql://localhost/autototaaldienst";
		String user="root";
		String password="";
		
		
		
		try{
		con=(Connection) DriverManager.getConnection(url, user, password);
		System.out.println("Connectie is goed");
		}catch (SQLException e){
			System.out.println("Er gaat iets verkeerd");
		}
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public static void saveUser(User u){
		
	}

}
