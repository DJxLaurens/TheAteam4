package Webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySqlAccess {
	final static String DB_DRIV = "com.mysql.jdbc.Driver";

	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName(DB_DRIV).newInstance();
			// setup the connection with the DB.
			String databaseURL = "jdbc:mysql://localhost";
			con = DriverManager.getConnection(databaseURL, "root", "");

			// statements allow to issue SQL queries to the database
			statement = con.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement.executeQuery("select * from autototaaldiensten.Klant");
			writeResultSet(resultSet);
			
		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			resultSet.close();
			con.close();
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String naam = resultSet.getString("naam");
			String adres = resultSet.getString("adres");
			String postcode = resultSet.getString("postcode");
			Date date = resultSet.getDate("geboren");
			System.out.println("ID: " + id);
			System.out.println("Naam: " + naam);
			System.out.println("Adres: " + adres);
			System.out.println("Postcode: " + postcode);
			System.out.println("Geboren: " + date);
		}
	}

}