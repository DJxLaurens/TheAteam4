package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Onderdelen.Klus;
import Onderdelen.Product;

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

	// haalt alle gegevens uit de tabel voorraad met type "2"
	public ArrayList<Product> getAlleOnderdelenDB() {
		ArrayList<Product> alleOnderdelenDB = new ArrayList<Product>();
		try {
			this.leesDatabase();
			statement = con.createStatement();
			rs = statement
					.executeQuery("SELECT * FROM voorraad where type='2'");

			while (rs.next()) {
				int id = rs.getInt("id");
				String naam = rs.getString("naam");
				int type = rs.getInt("type");
				int minVoorraad = rs.getInt("minVoorraad");
				int voorraad = rs.getInt("voorraad");
				int inBestelling = rs.getInt("inbestelling");
				
				Product p = new Product(id, naam, type, minVoorraad, voorraad, inBestelling);
				alleOnderdelenDB.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    		
		//TO DO: Data uit de DB halen en toevoegen aan de ArrayList.		
		return alleOnderdelenDB;
	}
	
	public int getSizeOnderdelen(){
		int size = this.getAlleOnderdelenDB().size();
		
		return size;
	}
	// haalt de voorraad op met meegegeven voorraadId
	public int getVoorraadById(int id){
		int voorraad = 0;
		try {
			this.leesDatabase();
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT voorraad FROM voorraad where id='"+ id +"'");
			
			while (rs.next()) {
				voorraad = rs.getInt("voorraad");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return voorraad;
		
	}
	// haalt de inbestelling op de meegegeven voorraadId;
	public int getBestellingById(int id){
		int inbestelling = 0;
		try {
			this.leesDatabase();
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT inbestelling FROM voorraad where id='"+ id +"'");
			
			while (rs.next()) {
				inbestelling = rs.getInt("inbestelling");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inbestelling;
		
	}
	// haalt alle voorraden op met type 1
	public ArrayList<Product> getAlleBrandstoffenDB() {
		ArrayList<Product> alleBrandstoffenDB = new ArrayList<Product>();
		try {
			this.leesDatabase();
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM voorraad where type='1'");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String naam = rs.getString("naam");
				int type = rs.getInt("type");
				int minVoorraad = rs.getInt("minVoorraad");
				int voorraad = rs.getInt("voorraad");
				int inBestelling = rs.getInt("inbestelling");
				
				Product p = new Product(id, naam, type, minVoorraad, voorraad, inBestelling);	
				alleBrandstoffenDB.add(p);
				//System.out.println(p.getProductNaam());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		//TO DO: Data uit de DB halen en toevoegen aan de ArrayList.
		
		return alleBrandstoffenDB;
	}
	// haalt de voorraad met meegegeven id op
	
	public Product getOnderdeelFromID(int pId){
		int id = 0;
		String naam = null;
		int type = 0;
		int minVoorraad = 0;
		int voorraad = 0;
		int inBestelling = 0;
		
		try {
			this.leesDatabase();
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM voorraad where id='"+ pId +"'");
			
			while (rs.next()) {
				id = rs.getInt("id");
				naam = rs.getString("naam");
				type = rs.getInt("type");
				minVoorraad = rs.getInt("minVoorraad");
				voorraad = rs.getInt("voorraad");
				inBestelling = rs.getInt("inbestelling");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product p = new Product(id, naam, type, minVoorraad, voorraad, inBestelling);
		
		return p;
	}
	
	public void saveVoorraad(String vrdNm, int vT, int vrdMin, int vrd) throws SQLException {	
		int inBestelling = 0;
		this.leesDatabase();
		statement = con.createStatement();
		statement.execute("INSERT INTO voorraad (naam, type, minVoorraad, voorraad, inbestelling)"+ "VALUES ('"+ vrdNm + "','" + vT + "','" + vrdMin + "','" + vrd + "', '"+ inBestelling +"')");				
	}
	//verandert de voorraad in de db met de voorraad die megegeven wordt
	public void changeVoorraad(int id, int nwVrd, int odVrd) throws SQLException {	
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
		int voorraad = nwVrd + odVrd;	
		String sql = "UPDATE voorraad " + "SET voorraad = "+ voorraad +" WHERE id=" + id;
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAlleOnderdelenDB();
	}
	// set inbestelling met meegegeven data
	public void vrdInBestelling(int id, int nwVrd, int odVrd) throws SQLException {	
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
		int voorraad = nwVrd + odVrd;
		System.out.println("Voorraad: " + voorraad);
		String sql = "UPDATE voorraad " + "SET inbestelling = "+ voorraad +" WHERE id=" + id;
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.getAlleOnderdelenDB();
	}
	
	public void getAlleOnderdelen(){
		this.getAlleOnderdelenDB();
	}
	
	public void changeMinVoorraad(int id, int nwMVrd) throws SQLException {	
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
		String sql = "UPDATE voorraad " + "SET minVoorraad = "+ nwMVrd +" WHERE id=" + id;
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAlleOnderdelenDB();
	}
	
	public void haalBestellingOp(int id, int ib, int vrd) throws SQLException {	
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
			int nwvrd = ib + vrd;
			
		String sql = "UPDATE voorraad " + "SET voorraad = "+ nwvrd +", inbestelling = 0 WHERE id=" + id;
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAlleOnderdelenDB();
	}
	
	public void deleteVoorraad(int id) throws SQLException {	
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
		String sql = "DELETE FROM voorraad WHERE id=" + id;
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAlleOnderdelenDB();
	}
}
