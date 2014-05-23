package Webapp;

import java.sql.*;

public class Dbconnectie {
	private Connection con = null;
	private Statement statement;
	private ResultSet rs = null;
	private String name = "", pass = "";
	
	public void leesDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = ""; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
			statement = con.createStatement();
			System.out.println("Connectie is goed");
		    rs = statement.executeQuery("SELECT * FROM user");
		    schrijfResultSet(rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public Connection con(){
		return con;
	}
	public void saveUser(User u) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO user (name, role_id, address, email, password)"+ "VALUES ('"+ u.getName() + "','"+ u.getRol()+ "','"+ u.getAddress() + "', '"+ u.getEmail()+ "','"+ u.getPass() + "')");			
			
	}
	private void schrijfResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			name = resultSet.getString("name");
			pass = resultSet.getString("password");
		}
	}
	public String getDbNaam(){
		return name;
	}
	public String getDbPass(){
		return pass;
	}
}
