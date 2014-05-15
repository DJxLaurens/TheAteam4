package Webapp;

import java.sql.*;

public class Dbconnection {
	private Connection con = null;
	private static Statement statement;
	private static ResultSet rs = null;
	private static int counter = 1;
	private static String naam;
	
	public void readDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
			statement = con.createStatement();
			System.out.println("Connectie is goed");
			rs = statement.executeQuery("SELECT *");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection con(){
		return con;
	}
	public void saveUser(User u) throws SQLException {	
		readDatabase();
		statement.execute("INSERT INTO user (name, role_id, address, email, password)"+ "VALUES ('"+ u.getName() + "','"+ u.getRol()+ "','"+ u.getAddress() + "', '"+ u.getEmail()+ "','"+ u.getPass() + "')");			
			
	}
	public ResultSet resultset(){
		return rs;
		
	}
	
}
