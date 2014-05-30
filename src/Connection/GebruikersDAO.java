package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Webapp.Gebruiker;

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
	public ArrayList<Gebruiker> getAlleGebruikersDB() {
		ArrayList<Gebruiker> alleGebruikersDB = new ArrayList<Gebruiker>();	
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM gebruiker ");
			while (output.next()){
//				int bouwjaar = output.getInt("bouwjaar");
//				int rol_id = output.getInt("rol_id");
				String naam = output.getString("naam");
				int id = output.getInt("gebruiker_id");
//				String wachtwoord = output.getString("wachtwoord");
//				String adres = output.getString("adres");
//				String postcode = output.getString("postcode");
//				String woonplaats = output.getString("woonplaats");
//				String telefoonnummer = output.getString("telefoonnummer");
//				String laatstgeweest = output.getString("laatstgeweest");
//				String emailadres = output.getString("emailadres");
//				double korting = output.getDouble("korting");
//				String openFactuur = output.getString("openFactuur");
//				boolean blokkade = output.getBoolean("blokkade");
				Gebruiker g = new Gebruiker(naam);
				g.setID(id);
				alleGebruikersDB.add(g);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return alleGebruikersDB;
	}
	
	public void saveGebruiker(Gebruiker g) throws SQLException {	
		leesDatabase();	
		statement.execute("INSERT INTO Gebruiker (rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, laatstgeweest, korting, openfactuur, blokkade)"+ "VALUES ('" + g.getRol() + "','" + g.getNaam() + "','" + g.getWachtwoord()+ "','"+ g.getAdres() + "','"+ g.getPostcode() + "','"+ g.getWoonplaats() + "','"+ g.getTelefoonnummer() + "','"+ g.getEmailadres() + "','"+ g.getLaatstgeweest() + "','"+ g.getKorting() + "','"+ g.getOpenFactuur() + "','" + '0' + "')");		
	}

}
