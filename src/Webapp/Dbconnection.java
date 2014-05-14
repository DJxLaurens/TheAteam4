package Webapp;

import java.sql.*;

public class Dbconnection {
	private static Connection con = null;
	private static ResultSet alleRecords = null;
	private static int counter = 0;
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
	}

	public Connection getConnection() {
		return con;
	}

	public static void saveUser(User u) throws SQLException {
		System.out.println(u.getName() + u.getAddress() + u.getEmail()
				+ u.getPass() + " dit is de invoer");
		Statement statement = con.createStatement();
		alleRecords = statement.executeQuery("SELECT COUNT(*) FROM autototaaldiensten.user");
		AantalRecords(alleRecords);
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

	private static void AantalRecords(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			counter ++;
		}
	}
}
