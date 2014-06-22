package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;
import Onderdelen.Klus;

public class KlussenDAO {
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
	//zoek alle klussen in de database
	public ArrayList<Klus> getAlleKlussenDB() {
		ArrayList<Klus> alleKlussenDB = new ArrayList<Klus>();	
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM klussen");
			while (output.next()){
				int id = output.getInt("id");
				String naam = output.getString("naam");
				String omschrijving = output.getString("omschrijving");
				int autoId = output.getInt("auto_id");
				int werknemerId = output.getInt("werknemer_id");
				Klus u = new Klus(naam, omschrijving, autoId, werknemerId);
				u.setKlusNummer(id);
				alleKlussenDB.add(u);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return alleKlussenDB;
	}
	//voegt een klus toe aan de database
	public void saveKlus(Klus k) throws SQLException {	
		this.leesDatabase();
		statement.execute("INSERT INTO klussen (naam, omschrijving, auto_id, werknemer_id)"+ "VALUES ('"+ k.getKlusNaam() + "','" + k.getKlusOmschrijving() + "','" + k.getAutoId() + "','" + k.getWerknemerId() + "')");				
	}
	public Auto getAuto(int id){
		Auto a = new Auto();
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM auto WHERE auto_id =" + id);
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
			a = new Auto(id, kenteken, merk, bouwjaar, type, eigenaar, brandstoftype);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void setBlokkade(int gId){
		try {
				this.leesDatabase();
				statement = con.createStatement();
				System.out.println("Voer Query uit");
				String sql = "UPDATE gebruiker " + "SET blokkade = 1 WHERE gebruiker_id=" + gId;
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}