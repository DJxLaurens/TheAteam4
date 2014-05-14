package Webapp;

import java.sql.*;

public class Dbconnection {
	private static Connection con = null;
	private static Statement statement;
	private static ResultSet resultSet = null, resultSet1 = null;
	private static int counter = 1;
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
			System.out.println("Connectie is goed");
		} catch (SQLException e) {
			System.out.println("Er gaat iets verkeerd");
			e.printStackTrace();
		}
		try {
			statement = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		try {
			resultSet1 = statement.executeQuery("SELECT * FROM autototaaldiensten.user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void saveUser(User u) throws SQLException {
		System.out.println(u.getName() + u.getAddress() + u.getEmail()
				+ u.getPass() + " dit is de invoer");		
		while (resultSet.next()) {			
			counter++;
		}
		try {
			statement.execute("INSERT INTO user (id, name, role_id, address, email, password)"+ "VALUES ('"+counter+"','"+u.getName() + "','"+ u.getRol()+ "','"+ u.getAddress() + "', '"+ u.getEmail()+ "','"+ u.getPass() + "')");
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
	public static ResultSet resultset() throws SQLException{
		return resultSet1;
	}
}
