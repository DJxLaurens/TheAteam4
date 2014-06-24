package TestsDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.GebruikersDAO;
import DAO.KlussenDAO;
import Onderdelen.Auto;
import Onderdelen.Klus;
import Onderdelen.Weekplanning;

public class KlussenDAOTest {
	KlussenDAO kDao = new KlussenDAO();
	GebruikersDAO gDao = new GebruikersDAO();
	
	@Before
	public void setUp(){
		try {
			kDao.leesDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getWeekplanning(){
		assertEquals(1, kDao.getWeekplanning().get(0).getId());
		assertEquals("Wielen vervangen", kDao.getWeekplanning().get(0).getKlusNaam());
		assertEquals("Henk", kDao.getWeekplanning().get(0).getMonteur());
		assertEquals("Opel Astra", kDao.getWeekplanning().get(0).getAuto());
	}
	
	@Test
	public void getAlleKlussenDB(){
		assertEquals(1, kDao.getAlleKlussenDB().get(0).getKlusNummer());
		assertEquals("Wielen vervangen", kDao.getAlleKlussenDB().get(0).getKlusNaam());
		assertEquals("De wielen van meneer Eijkeleburg vervangen.", kDao.getAlleKlussenDB().get(0).getKlusOmschrijving());
		assertEquals(3, kDao.getAlleKlussenDB().get(0).getAutoId());
		assertEquals("", kDao.getAlleKlussenDB().get(0).getDatum());
		assertEquals(1, kDao.getAlleKlussenDB().get(0).getIngepland());
	}
	
	@Test
	public void saveKlus() throws SQLException{
		Klus k = new Klus(4, "Velgen poetsen", "De velgen van Hans poetsen", 3, 0, "24-06-2014", 0);
		kDao.saveKlus(k);
		assertEquals(k.toStringTest(), kDao.getAlleKlussenDB().get(3).toStringTest());
	}
	
	@Test
	public void getAuto(){
		assertEquals(1, kDao.getAuto(1).getAutoID());
		assertEquals("11-AA-BB", kDao.getAuto(1).getKenteken());
		assertEquals("BMW", kDao.getAuto(1).getMerk());
		assertEquals("1982", kDao.getAuto(1).getBouwjaar());
		assertEquals("M3 GTR", kDao.getAuto(1).getType());
		assertEquals(1, kDao.getAuto(1).getEigenaarID());
		assertEquals("Diesel", kDao.getAuto(1).getBrandstoftype());
	}

	@Test
	public void setBlokkade(){
		assertEquals(false, gDao.getAlleGebruikersDB().get(7).getBlokkade());
		kDao.setBlokkade(8);
		assertEquals(true, gDao.getAlleGebruikersDB().get(7).getBlokkade());
	}
	
	@Test
	public void setIngepland() throws SQLException{
		assertEquals(0, kDao.getAlleKlussenDB().get(0).getIngepland());
		kDao.setIngepland(1);
		fail("geen mogelijkheid om ingeplande klussen op te halen");
	}
	
	@Test
	public void saveWeekplanning() throws SQLException{
		kDao.saveWeekplanning("Velgen poetsen", "Henk", "3");
		assertEquals(10, kDao.getWeekplanningByID(10).getId());
		assertEquals("Velgen poetsen", kDao.getWeekplanningByID(7).getKlusNaam());
	}
	
	@Test
	public void verwijderWeekplanning(){
		assertEquals(4, kDao.getWeekplanning().size());
		kDao.verwijderWeekplanning(6);
		assertEquals(3, kDao.getWeekplanning().size());
	}
}