package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;
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
			output = statement.executeQuery("SELECT * FROM auto");
			while (output.next()){
				int id = output.getInt("auto_id");
				String kenteken = output.getString("kenteken");
				String merk = output.getString("merk");
				int bouwjaar = output.getInt("bouwjaar");
				String type = output.getString("type");
				int gebruikersId = output.getInt("gebruiker_id");
				String brandstoftype = output.getString("brandstoftype");
				GebruikersDAO geb = new GebruikersDAO();
				Gebruiker eigenaar = null;
				for(Gebruiker g : geb.getAlleGebruikersDB()){
					if(gebruikersId == g.getGebruikerID()){
						eigenaar = g;
					}
				}
				Auto a = new Auto(id, kenteken, merk, bouwjaar, type, eigenaar, brandstoftype);
				a.setEigenaarID(gebruikersId);
				alleAutosDB.add(a);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return alleAutosDB;
	}
	
	public String getAutoById(String ai) throws SQLException{
		String merk = null;
		String type = null;
		Integer.parseInt(ai);
		
		this.leesDatabase();
		output = statement.executeQuery("SELECT merk, type FROM auto WHERE auto_id =" + ai);
		
		while (output.next()) {
			merk = output.getString("merk");
			type = output.getString("type");
		}
		
		String auto = merk + " " + type;
		
		return auto;
	}
	
	public void saveAuto(Auto a) throws SQLException {	
		this.leesDatabase();
		statement.execute("INSERT INTO auto (kenteken, merk, bouwjaar, type, brandstoftype)"+ "VALUES ('"+ a.getKenteken() + "','" + a.getMerk() + "','" + a.getBouwjaar() + "','" + a.getType() + "','" + a.getBrandstoftype() + "')");				
	}
}
