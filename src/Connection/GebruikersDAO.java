package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Webapp.Gebruiker;
import Webapp.Klus;

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
				Klus u = new Klus(id, naam, omschrijving, autoId, werknemerId);
				alleKlussenDB.add(u);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return alleKlussenDB;
	}
	
	public void saveGebruiker(Gebruiker g) throws SQLException {	
		leesDatabase();	
		statement.execute("INSERT INTO Gebruiker (rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, laatstgeweest, korting, openfactuur, blokkade)"+ "VALUES ('" + g.getRol() + "','" + g.getNaam() + "','" + g.getWachtwoord()+ "','"+ g.getAdres() + "','"+ g.getPostcode() + "','"+ g.getWoonplaats() + "','"+ g.getTelefoonnummer() + "','"+ g.getEmailadres() + "','"+ g.getLaatstgeweest() + "','"+ g.getKorting() + "','"+ g.getOpenFactuur() + "','" + '0' + "')");		
	}

}
