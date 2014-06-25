package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;
import Onderdelen.Klus;
import Onderdelen.Product;
import Onderdelen.Weekplanning;

public class KlussenDAO {
	private Connection con = null;
	private Statement statement;
	private ResultSet output;
	
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
	
	public ArrayList<Weekplanning> getWeekplanning(){
		ArrayList<Weekplanning> weekplanning = new ArrayList<Weekplanning>();
		
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM weekplanning");
			while (output.next()){
				int id = output.getInt("id");
				String klusNaam = output.getString("klusnaam");
				String monteur = output.getString("monteur");
				String auto = output.getString("auto");
				String datum = output.getString("datum");
				
				Weekplanning w = new Weekplanning(id, klusNaam, monteur, auto, datum);
				weekplanning.add(w);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return weekplanning;
	}
	
	//zoek alle klussen in de database
	public ArrayList<Klus> getAlleKlussenDB() {
		ArrayList<Klus> alleKlussenDB = new ArrayList<Klus>();	
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM klussen WHERE ingepland = 0");
			while (output.next()){
				int id = output.getInt("id");
				String naam = output.getString("naam");
				String omschrijving = output.getString("omschrijving");
				int autoId = output.getInt("auto_id");
				int werknemerId = output.getInt("werknemer_id");
				String datum = output.getString("datum");
				int ingepland = output.getInt("ingepland");
				Klus u = new Klus(id, naam, omschrijving, autoId, werknemerId, datum, ingepland);
				u.setKlusNummer(id);
				alleKlussenDB.add(u);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return alleKlussenDB;
	}
	//voegt een klus toe aan de database
	public void saveKlus(Klus k) throws SQLException {	
		this.leesDatabase();
		statement.execute("INSERT INTO klussen (naam, omschrijving, auto_id, werknemer_id, datum, ingepland)"+ "VALUES ('"+ k.getKlusNaam() + "','" + k.getKlusOmschrijving() + "','" + k.getAutoId() + "','" + k.getWerknemerId() + "','" + k.getDatum() + "','" + "0" +"')");				
	}
	public Auto getAuto(int id){
		Auto a = new Auto();
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM auto WHERE auto_id =" + id);
			String kenteken = output.getString("kenteken");
			String merk = output.getString("merk");
			int bouwjaar = output.getInt("bouwjaar");
			String type = output.getString("type");
			int gebruikersId = output.getInt("gebruiker_id");
			String brandstoftype = output.getString("brandstoftype");
			GebruikersDAO geb = new GebruikersDAO();
			Gebruiker eigenaar = null;
			for(Gebruiker g : geb.getAlleGebruikersDB()){
				if(gebruikersId == g.getGebruikerID()){
					eigenaar = g;
				}
			}
			a = new Auto(id, kenteken, merk, bouwjaar, type, eigenaar, brandstoftype);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void setBlokkade(int gId){
		try {
				this.leesDatabase();
				statement = con.createStatement();
				String sql = "UPDATE gebruiker " + "SET blokkade = 1 WHERE gebruiker_id=" + gId;
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void setIngepland(int id) throws SQLException{
		this.leesDatabase();
		statement.execute("UPDATE klussen " + "SET ingepland = 1 WHERE id=" + id);
	}
	
	public void saveWeekplanning(String kN, String mN, String aI, String dtm) throws SQLException{
		this.leesDatabase();
		
		AutosDAO ad = new AutosDAO();
		String autoNaam = ad.getAutoById(aI);
		
		statement.execute("INSERT INTO weekplanning (klusnaam, monteur, auto, datum)"+ "VALUES ('"+ kN + "','" + mN + "','" + autoNaam + "','" + dtm +  "')");	
	}
	
	public Weekplanning getWeekplanningByID(int id){
		int Wid = 0;
		String klusNaam = null;
		String monteur = null;
		String auto = null;
		String datum = null;
		
		try {
			this.leesDatabase();
			statement = con.createStatement();
			output = statement.executeQuery("SELECT * FROM klussen where id='"+ id +"'");
			
			while (output.next()) {
				Wid = output.getInt("id");
				klusNaam = output.getString("klusnaam");
				monteur = output.getString("monteur");
				auto = output.getString("auto");
				datum = output.getString("datum");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Weekplanning week = new Weekplanning(id, klusNaam, monteur, auto, datum);
		
		return week;
	}
	
	public void verwijderWeekplanning(int id){
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
		String sql = "DELETE FROM weekplanning WHERE id=" + id;
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getWeekplanning();
	}
	
	
}
