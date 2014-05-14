package Webapp;

import java.sql.*;

public class Dbconnection {
	private static Connection con = null;
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
		System.out.println(u.getName() + u.getAddress() + u.getEmail() + u.getPass());
		Statement statement = con.createStatement();
		//String sql = "INSERT INTO users (id, name, role_id, address, email, password) VALUES ('2', " + u.getName() + ", '1', "+ u.getAddress() +"," + u.getEmail() + "," + u.getPass() + ");";
		//String sql = "INSERT INTO users (id, 'name', role_id, 'address', 'email', 'password') VALUES (2, Henk, 1, Straatweg 5, info@email.nl,w8woord);";
		try
        {
			statement.execute("INSERT INTO user (id, name, role_id, address, email, password)"+ "VALUES (2,'Henk', 1,'Straatweg 5', 'info@email.com','w8woord')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
            	statement.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}
