package TestsDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import DAO.GebruikersDAO;
import Onderdelen.Gebruiker;

public class GebruikersDAOTest {
	GebruikersDAO gDao = new GebruikersDAO();

	@Before
	public void setUp(){
		try {
			gDao.leesDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getAlleGebruikersDB(){
		assertEquals(1, gDao.getAlleGebruikersDB().get(0).getGebruikerID());
		assertEquals(4, gDao.getAlleGebruikersDB().get(0).getRol());
		assertEquals("Jan", gDao.getAlleGebruikersDB().get(0).getNaam());
		assertEquals("Jan", gDao.getAlleGebruikersDB().get(0).getWachtwoord());
		assertEquals("Bananenlaan 1", gDao.getAlleGebruikersDB().get(0).getAdres());
		assertEquals("1234AB", gDao.getAlleGebruikersDB().get(0).getPostcode());
		assertEquals("Zaandam", gDao.getAlleGebruikersDB().get(0).getWoonplaats());
		assertEquals("12345678", gDao.getAlleGebruikersDB().get(0).getTelefoonnummer());
		assertEquals("jan@lolmail.com", gDao.getAlleGebruikersDB().get(0).getEmailadres());
		assertEquals("11-03-2013", gDao.getAlleGebruikersDB().get(0).getLaatstgeweest());
		assertEquals("01-01-2012", gDao.getAlleGebruikersDB().get(0).getOpenFactuur());
		assertEquals(true, gDao.getAlleGebruikersDB().get(0).getBlokkade());
	}

	@Test
	public void setBlokkade(){
		gDao.setBlokkade(1);
		assertEquals(true,gDao.getAlleGebruikersDB().get(0).getBlokkade());
	}

	@Test
	public void getBlokkade(){
		gDao.getBlokkadeDB();
		assertEquals(false,gDao.getBlokkadeDB().get(1).getBlokkade());
		assertEquals(false,gDao.getBlokkadeDB().get(2).getBlokkade());
	}

	@Test
	public void saveGebruiker() throws SQLException{
		Gebruiker g = new Gebruiker(1, "Theo", null, null, null, null, null, "theo@lolmail.com", null, 1, null, false);
		gDao.saveGebruiker(g);
		assertEquals(g.getNaam(), gDao.getAlleGebruikersDB().get(5).getNaam());
		assertEquals(g.getEmailadres(), gDao.getAlleGebruikersDB().get(5).getEmailadres());
	}
}