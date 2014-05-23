package Webapp;

import java.sql.*;

public class Dbconnection {
	private Connection con = null;
	private Statement statement;
	private ResultSet rs = null;
	private String name = "", pass = "";
	private boolean b = false;
	
	public void readDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = "root"; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
			statement = con.createStatement();
			System.out.println("Connectie is goed");
		    rs = statement.executeQuery("SELECT * FROM user");
		    writeResultSet(rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public Connection con(){
		return con;
	}
	public void saveUser(User u) throws SQLException {
		System.out.println(u);
		System.out.println(statement);
		Statement st = con.createStatement();
		st.execute("INSERT INTO user (name, role_id, address, email, password)"+ "VALUES ('"+ u.getName() + "','"+ u.getRol()+ "','"+ u.getAddress() + "', '"+ u.getEmail()+ "','"+ u.getPass() + "')");			
			
	}
	public void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String nm = resultSet.getString("name");
			String ps = resultSet.getString("password");
			if(nm.equals(name)&&ps.equals(pass)){
				b = true;
			}
		}
	}
	public boolean getLogin() throws SQLException{
		readDatabase();
		return b;
	}
	public String getDbNaam(){
		return name;
	}
	public String getDbPass(){
		return pass;
	}
}
