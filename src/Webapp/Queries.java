package Webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {
	final static String DB_DRIV = "com.mysql.jdbc.Driver";

	private Connection con = null;
	private Statement statement = null;
	private static Statement statement1 = null;
	private ResultSet resultSet = null;
	private static ResultSet rs = null;
	private static int counter = 0;
	private String id = "", name = "", password = "";

	public void leesDataBase() throws Exception {
		try {
			
			// this will load the MySQL driver, each DB has its own driver
			Class.forName(DB_DRIV).newInstance();
			// setup the connection with the DB.
			String databaseURL = "jdbc:mysql://localhost/autototaaldiensten";
			con = DriverManager.getConnection(databaseURL, "root", "");

			// statements allow to issue SQL queries to the database
			statement = con.createStatement();
			statement1 = statement;
			// resultSet gets the result of the SQL query
			resultSet = statement.executeQuery("select * from autototaaldiensten.gebruiker");
			schrijfResultSet(resultSet);
			

		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			resultSet.close();
			con.close();
		}

	}
	public static void saveGebruiker(Gebruiker g) throws SQLException {	
		try {			
			statement1.execute("INSERT INTO Gebruiker (rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, korting, laatstgeweest, openfactuur, blokkade)"+ "VALUES ('" + g.getRol() + "','" + g.getNaam() + "','" + g.getWachtwoord()+ "','"+ g.getAdres() + "','"+ g.getPostcode() + "','"+ g.getWoonplaats() + "','"+ g.getTelefoonnummer() + "','"+ g.getEmailadres() + "','"+ g.getKorting() + "','"+ g.getLaatstgeweest() + "','"+ g.getOpenFactuur() + "','" + '0' + "')");						
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void schrijfResultSet(ResultSet resultSet) throws SQLException {
		while(resultSet.next()){
			counter ++;
		}
		while (resultSet.next()) {
			id = resultSet.getString("id");
			name = resultSet.getString("name");
			password = resultSet.getString("password");
			System.out.println("ID: " + name);
			System.out.println("Naam: " + password);
		}
	}

}