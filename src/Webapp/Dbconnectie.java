package Webapp;

import java.sql.*;

public class Dbconnectie {
	private Connection con = null;
	private static Statement statement;
	private ResultSet rs = null;
	private AutoTotaalDienst atdRef;
	
	public void leesDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = "root"; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
			statement = con.createStatement();		
			rs = statement.executeQuery("SELECT * FROM klussen");
		    System.out.println(rs + " dit is RS");
		    onderdeelResultset(rs);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	public Connection con(){
		return con;
	}
	public static ResultSet getAlleBrandstoffen() throws SQLException{
		return statement.executeQuery("SELECT * FROM voorraad WHERE type = '1'");
	}
	public static ResultSet getAlleOnderdelen() throws SQLException{
		return statement.executeQuery("SELECT * FROM Gebruiker");		
	}
	
	public void saveGebruiker(Gebruiker g) throws SQLException {	
		leesDatabase();	
		statement.execute("INSERT INTO Gebruiker (rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, laatstgeweest, korting, openfactuur, blokkade)"+ "VALUES ('" + g.getRol() + "','" + g.getNaam() + "','" + g.getWachtwoord()+ "','"+ g.getAdres() + "','"+ g.getPostcode() + "','"+ g.getWoonplaats() + "','"+ g.getTelefoonnummer() + "','"+ g.getEmailadres() + "','"+ g.getLaatstgeweest() + "','"+ g.getKorting() + "','"+ g.getOpenFactuur() + "','" + '0' + "')");		
	}
	
	public void saveKlus(Klus k) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO klussen (naam, omschrijving, auto_id, werknemer_id)"+ "VALUES ('"+ k.getKlusNaam() + "','" + k.getKlusOmschrijving() + "','" + k.getAutoId() + "','" + k.getWerknemerId() + "')");				
	}
	
	public void saveVoorraad(Product p) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO voorraad (naam, type, minVoorraad, voorraad)"+ "VALUES ('"+ p.getProductNaam() + "','" + p.getType() + "','" + p.getMinVoorraad() + "','" + p.getVoorraad() + "')");				
	}
	
	public void onderdeelResultset(ResultSet resultSet) throws SQLException {
		System.out.println(" aaa");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String naam = resultSet.getString("naam");
			String omschrijving = resultSet.getString("omschrijving");
			int autoId = resultSet.getInt("auto_id");
			int werknemerId = resultSet.getInt("werknemer_id");
			Klus u = new Klus(id, naam, omschrijving, autoId, werknemerId);			
			atdRef.voegKlusToe(u);			
		}
	}
}
