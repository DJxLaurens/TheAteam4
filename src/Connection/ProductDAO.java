package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Webapp.Klus;
import Webapp.Product;

public class ProductDAO {
	private Connection con = null;
	private Statement statement;
	private ResultSet rs = null;
	
	public void leesDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost/autototaaldiensten";
		String user = "root";
		String password = ""; 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Product> getAlleOnderdelenDB() {
		ArrayList<Product> alleOnderdelenDB = new ArrayList<Product>();
		try {
			this.leesDatabase();
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM voorraad where type='2'");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String naam = rs.getString("naam");
				int type = rs.getInt("type");
				int minVoorraad = rs.getInt("minVoorraad");
				int voorraad = rs.getInt("voorraad");
				
				Product p = new Product(id, naam, type, minVoorraad, voorraad);	
				alleOnderdelenDB.add(p);
				System.out.println(p.getProductNaam());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		//TO DO: Data uit de DB halen en toevoegen aan de ArrayList.
		
		return alleOnderdelenDB;
	}

	public void setOnderdelenDB(){
		
	}
	
	public ArrayList<Product> getAlleBrandstoffenDB() {
		ArrayList<Product> alleBrandstoffenDB = new ArrayList<Product>();
		
		//TO DO: Data uit de DB halen en toevoegen aan de ArrayList.
		
		return alleBrandstoffenDB;
	}
	
	public void setBrandstoffenDB(){
		
	}
	public void saveVoorraad(Product p) throws SQLException {	
		this.leesDatabase();
		statement.execute("INSERT INTO voorraad (naam, type, minVoorraad, voorraad)"+ "VALUES ('"+ p.getProductNaam() + "','" + p.getType() + "','" + p.getMinVoorraad() + "','" + p.getVoorraad() + "')");				
	}
	
	public void changeVoorraad(Product p) throws SQLException {	
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
		String sql = "UPDATE voorraad " + "SET voorraad = "+ p.getVoorraad() +" WHERE id=" + p.getProductNummer();
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAlleOnderdelenDB();
	}
}
