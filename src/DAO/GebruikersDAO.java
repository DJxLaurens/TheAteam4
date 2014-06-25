package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Onderdelen.Gebruiker;
import Onderdelen.Product;

public class GebruikersDAO {
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
	//haalt alle gegevens uit tabel gebruiker
	public ArrayList<Gebruiker> getAlleGebruikersDB() {
		ArrayList<Gebruiker> alleGebruikersDB = new ArrayList<Gebruiker>();	
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM gebruiker ");
			while (output.next()){
				int rol_id = output.getInt("rol_id");
				String naam = output.getString("naam");
				int gebruiker_id = output.getInt("gebruiker_id");
				String wachtwoord = output.getString("wachtwoord");
				String adres = output.getString("adres");
				String postcode = output.getString("postcode");
				String woonplaats = output.getString("woonplaats");
				String telefoonnummer = output.getString("telefoonnummer");
				String laatstgeweest = output.getString("laatstgeweest");
				String emailadres = output.getString("emailadres");
				double korting = output.getDouble("korting");
				String openFactuur = output.getString("openFactuur");
				boolean blokkade = output.getBoolean("blokkade");
				Gebruiker g = new Gebruiker(rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, laatstgeweest, korting, openFactuur, blokkade);
				g.setID(gebruiker_id);
				alleGebruikersDB.add(g);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return alleGebruikersDB;
	}
	// zet het blokkade veld in tabel gebruiker op 1, oftewel true
	public void setBlokkade(int gId){
	try {
			this.leesDatabase();
			statement = con.createStatement();
			String sql = "UPDATE gebruiker " + "SET blokkade = 1 WHERE gebruiker_id=" + gId;
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// haalt alle gegevens uit tabel gebruiker op met blokkade "0"
	public ArrayList<Gebruiker> getBlokkadeDB() {
		ArrayList<Gebruiker> getBlokkadeDB = new ArrayList<Gebruiker>();
		try {
			this.leesDatabase();
			statement = con.createStatement();
			output = statement.executeQuery("SELECT * FROM gebruiker where blokkade='0'");
			
			while (output.next()) {
				int id = output.getInt("gebruiker_id");
				int roleId = output.getInt("rol_id");
				String naam = output.getString("naam");
				String wachtwoord = output.getString("wachtwoord");
				String adres = output.getString("adres");
				String postcode = output.getString("postcode");
				String woonplaats = output.getString("woonplaats");
				String telefoonnummer = output.getString("telefoonnummer");
				String email = output.getString("emailadres");
				String laatstgeweest = output.getString("laatstgeweest");
				double korting = output.getDouble("korting");
				String openFactuur = output.getString("openFactuur");
				int blokkade = output.getInt("blokkade");
				
				Gebruiker g = new Gebruiker(id, roleId, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, email, laatstgeweest, korting, openFactuur, blokkade);	
				getBlokkadeDB.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return getBlokkadeDB;
		}
	
	public void saveGebruiker(Gebruiker g) throws SQLException {	
		leesDatabase();	
		statement.execute("INSERT INTO Gebruiker (rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, laatstgeweest, korting, openfactuur, blokkade)"+ "VALUES ('" + g.getRol() + "','" + g.getNaam() + "','" + g.getWachtwoord()+ "','"+ g.getAdres() + "','"+ g.getPostcode() + "','"+ g.getWoonplaats() + "','"+ g.getTelefoonnummer() + "','"+ g.getEmailadres() + "','"+ g.getLaatstgeweest() + "','"+ g.getKorting() + "','"+ g.getOpenFactuur() + "','" + '0' + "')");		
	}

}
