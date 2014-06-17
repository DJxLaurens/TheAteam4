package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Onderdelen.Auto;
import Onderdelen.Klus;

public class AutosDAO {
	private Connection con = null;
	private Statement statement;
	private ResultSet output;
	
	public void leesDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = ""; 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
			statement = con.createStatement();		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Auto> getAlleAutosDB() {
		ArrayList<Auto> alleAutosDB = new ArrayList<Auto>();	
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM auto ");
			while (output.next()){
				int bouwjaar = output.getInt("bouwjaar");
				int id = output.getInt("gebruiker_id");
				Auto a = new Auto(bouwjaar);
				a.setEigenaarID(id);
				alleAutosDB.add(a);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return alleAutosDB;
	}
	
	public void saveAuto(Auto a) throws SQLException {	
		this.leesDatabase();
		statement.execute("INSERT INTO auto (kenteken, merk, bouwjaar, type, brandstoftype)"+ "VALUES ('"+ a.getKenteken() + "','" + a.getMerk() + "','" + a.getBouwjaar() + "','" + a.getType() + "','" + a.getBrandstoftype() + "')");				
	}
}
