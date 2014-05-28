package Connection;

import java.sql.*;
import java.util.*;

import Webapp.AutoTotaalDienst;
import Webapp.Gebruiker;
import Webapp.Klus;
import Webapp.Product;

public class Dbconnectie {
	private Connection con = null;
	private Statement statement;
	private AutoTotaalDienst atdRef;
	
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
	public Connection con(){
		return con;
	}	
	
	public void saveVoorraad(Product p) throws SQLException {	
		leesDatabase();
		statement.execute("INSERT INTO voorraad (naam, type, minVoorraad, voorraad)"+ "VALUES ('"+ p.getProductNaam() + "','" + p.getType() + "','" + p.getMinVoorraad() + "','" + p.getVoorraad() + "')");				
	}

}
