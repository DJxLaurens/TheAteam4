package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Webapp.Klus;

public class KlussenDAO {
	private Connection con = null;
	private Statement statement;
	private ResultSet output, insert;
	
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
	
	public ArrayList<Klus> getAlleKlussen() {
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
				System.out.println("Dit is een klus: "+ id + naam + omschrijving + autoId + werknemerId);
				Klus u = new Klus(id, naam, omschrijving, autoId, werknemerId);
				alleKlussenDB.add(u);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return alleKlussenDB;
	}
	
	public void saveKlus(Klus k) throws SQLException {	
		this.leesDatabase();
		statement.execute("INSERT INTO klussen (naam, omschrijving, auto_id, werknemer_id)"+ "VALUES ('"+ k.getKlusNaam() + "','" + k.getKlusOmschrijving() + "','" + k.getAutoId() + "','" + k.getWerknemerId() + "')");				
	}
}
