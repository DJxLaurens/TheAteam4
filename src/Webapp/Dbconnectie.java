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
		    rs = statement.executeQuery("SELECT * FROM klant");
		    schrijfResultSet(rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public Connection con(){
		return con;
	}
//	public void saveMedewerker(Medewerker m) throws SQLException {	
//		leesDatabase();
//		statement.execute("INSERT INTO medewerker (naam, rol_id, wachtwoord)"+ "VALUES ('"+ m.getNaam() + "','"+ m.getRol()+ "','"+ m.getWw() + "')");			
//			
//	}
	
	public void saveKlant(Klant k) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO klant (naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, korting, laatstgeweest, openfactuur, blokkade)"+ "VALUES ('"+ k.getNaam() + "','" + k.getWachtwoord()+ "','"+ k.getAdres() + "','"+ k.getPostcode() + "','"+ k.getWoonplaats() + "','"+ k.getTelefoonnummer() + "','"+ k.getEmailadres() + "','"+ k.getKorting() + "','"+ k.getLaatstgeweest() + "','"+ k.getOpenFactuur() + "','" + '0' + "')");				
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
