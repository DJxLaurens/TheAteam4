package Webapp;

import java.sql.*;

public class Dbconnectie {
	private Connection con = null;
	private Statement statement;
	private ResultSet rs = null;
	private String naam = "", ww = "";
	
	public void leesDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = ""; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
			statement = con.createStatement();
			System.out.println("Connectie is goed");
		    rs = statement.executeQuery("SELECT * FROM Gebruiker");
		    schrijfResultSet(rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public Connection con(){
		return con;
	}
	
	public void saveGebruiker(Gebruiker g) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO Gebruiker (rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, korting, laatstgeweest, openfactuur, blokkade)"+ "VALUES ('" + g.getRol() + "','" + g.getNaam() + "','" + g.getWachtwoord()+ "','"+ g.getAdres() + "','"+ g.getPostcode() + "','"+ g.getWoonplaats() + "','"+ g.getTelefoonnummer() + "','"+ g.getEmailadres() + "','"+ g.getKorting() + "','"+ g.getLaatstgeweest() + "','"+ g.getOpenFactuur() + "','" + '0' + "')");				
	}
	
	public void saveKlus(Klus k) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO klussen (id, naam, omschrijving, auto_id, werknemer_id)"+ "VALUES (null,'"+ k.getKlusNaam() + "','" + k.getKlusOmschrijving() + "','" + k.getAutoId() + "','" + k.getWerknemerId() + "')");				
	}
	
	public void saveVoorraad(Product p) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO voorraad (id, naam, type, minVoorraad, voorraad)"+ "VALUES (null,'"+ p.getProductNaam() + "','" + p.getType() + "','" + p.getMinVoorraad() + "','" + p.getVoorraad() + "')");				
	}
	
	private void schrijfResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			naam = resultSet.getString("naam");
			ww = resultSet.getString("wachtwoord");
		}
	}
	public String getDbNaam(){
		return naam;
	}
	public String getDbPass(){
		return ww;
	}
}
