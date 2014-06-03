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
				//System.out.println(p.getProductNaam());
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

	public void setOnderdelenDB(){
		
	}
	
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
				
				Product p = new Product(id, naam, type, minVoorraad, voorraad);	
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
	
	public void setBrandstoffenDB(){
		
	}
	
	public Product getOnderdeelFromID(int pId){
		int id = 0;
		String naam = null;
		int type = 0;
		int minVoorraad = 0;
		int voorraad = 0;
		
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
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product p = new Product(id, naam, type, minVoorraad, voorraad);
		
		return p;
	}
	
	
	
	public void saveVoorraad(String vrdNm, int vT, int vrdMin, int vrd) throws SQLException {	
		this.leesDatabase();
		statement = con.createStatement();
		statement.execute("INSERT INTO voorraad (naam, type, minVoorraad, voorraad)"+ "VALUES ('"+ vrdNm + "','" + vT + "','" + vrdMin + "','" + vrd + "')");				
	}
	
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
