package Webapp;

import java.sql.*;

public class Dbconnection {
	private static Connection con = null;
	private static Statement statement;
	private static ResultSet resultSet = null, rs = null;
	private static int counter = 1;
	private static String naam;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found: " + e);
		}

		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = "root";

		try {
			con = (Connection) DriverManager.getConnection(url, user, password);
			statement = con.createStatement();
			System.out.println("Connectie is goed");
		} catch (SQLException e) {
			System.out.println("Er gaat iets verkeerd");
			e.printStackTrace();
			
		}
		try {
			ResultSet rs = statement.executeQuery("SELECT @@IDENTITY");
			if (rs.next()) {
				counter = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection con(){
		return con;
	}
	public static void saveUser(User u) throws SQLException {	
		try {			
			statement.execute("INSERT INTO user (id, name, role_id, address, email, password)"+ "VALUES ('"+counter+"','"+ resultSet + "','"+ u.getRol()+ "','"+ u.getAddress() + "', '"+ u.getEmail()+ "','"+ u.getPass() + "')");			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static ResultSet resultset(){
		return resultSet;
		
	}
}
