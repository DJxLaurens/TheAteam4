package TestsDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.AutosDAO;
import DAO.GebruikersDAO;
import Onderdelen.Auto;
import Onderdelen.Gebruiker;

public class AutosDAOTest {
	AutosDAO aDao = new AutosDAO();
	GebruikersDAO gDao = new GebruikersDAO();
	
	@Before
	public void setUp(){
		try {
			aDao.leesDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void getAlleAutosDB(){
		assertEquals(1, aDao.getAlleAutosDB().get(0).getAutoID());
		assertEquals("11-AA-BB", aDao.getAlleAutosDB().get(0).getKenteken());
		assertEquals("BMW", aDao.getAlleAutosDB().get(0).getMerk());
		assertEquals(1982, aDao.getAlleAutosDB().get(0).getBouwjaar());
		assertEquals("M3 GTR", aDao.getAlleAutosDB().get(0).getType());
		assertEquals(1, aDao.getAlleAutosDB().get(0).getEigenaarID());
		assertEquals("Diesel", aDao.getAlleAutosDB().get(0).getBrandstoftype());
	}
	
	@Test
	public void saveAuto(){
		Gebruiker g = gDao.getAlleGebruikersDB().get(0);
		Auto a = new Auto(5, "SU-19-91", "Trabant", 1968, "600-S", g, "Benzine");
		try {
			aDao.saveAuto(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(a, aDao.getAlleAutosDB().get(4));
	}
}