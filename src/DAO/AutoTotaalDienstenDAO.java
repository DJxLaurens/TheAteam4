package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DomeinModel.AutoTotaalDienst;
import Onderdelen.Auto;
import Onderdelen.Gebruiker;

public class AutoTotaalDienstenDAO {
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
	
	public AutoTotaalDienst getATD() {
		ArrayList<AutoTotaalDienst> alleATDDB = new ArrayList<AutoTotaalDienst>();	
		try {
			this.leesDatabase();
			output = statement.executeQuery("SELECT * FROM autototaaldienst");
			while (output.next()){
				double lp = output.getDouble("literprijs");
				double wup = output.getDouble("werkuurprijs");
				double mp = output.getDouble("maandprijs");
				double wp = output.getDouble("weekprijs");
				double dp = output.getDouble("dagprijs");
				
				AutoTotaalDienst atd = new AutoTotaalDienst();
				atd.setLiterPrijs(lp);
				atd.setWerkUurPrijs(wup);
				atd.setMaandPrijs(mp);
				atd.setWeekPrijs(wp);
				atd.setDagPrijs(dp);
				
				alleATDDB.add(atd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		AutoTotaalDienst atd = alleATDDB.get(0);
		
		return atd;
	}
	public void saveAutoTotaalDienst(AutoTotaalDienst a) throws SQLException {	
		this.leesDatabase();
		statement.execute("INSERT INTO autototaaldienst (literprijs, werkuurprijs, maandprijs, weekprijs, dagprijs)"+ "VALUES ('"+ a.getLiterPrijs() + "','" + a.getWerkUurPrijs() + "','" + a.getMaandPrijs() + "','" + a.getWeekPrijs() + "','" + a.getDagPrijs() + "')");				
	}
	public void deleteAutoTotaalDienst(int id) throws SQLException {	
		try {
			this.leesDatabase();
			statement = con.createStatement();
			
		String sql = "DELETE FROM autototaaldienst WHERE id=" + id;
		statement.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
