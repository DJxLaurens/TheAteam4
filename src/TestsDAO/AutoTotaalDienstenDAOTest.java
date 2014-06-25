package TestsDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.AutoTotaalDienstenDAO;
import DAO.AutosDAO;
import DAO.GebruikersDAO;
import DomeinModel.AutoTotaalDienst;

public class AutoTotaalDienstenDAOTest {
	AutoTotaalDienstenDAO aDao = new AutoTotaalDienstenDAO();
	
	@Before
	public void setUp(){
		try {
			aDao.leesDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void getATD(){
		AutoTotaalDienst atd = aDao.getATD();
		assertEquals(10, atd.getLiterPrijs(),0);
		assertEquals(12, atd.getWerkUurPrijs(),0);
		assertEquals(2, atd.getMaandPrijs(),0);
		assertEquals(1, atd.getWeekPrijs(),0);
		assertEquals(23, atd.getDagPrijs(),0);
	}
	
	@Test
	public void saveAutoTotaalDienst() throws SQLException{
		double lp = 69;
		double wup = 69;
		double mp = 69;
		double wp = 69;
		double dp = 69;
		AutoTotaalDienst atd = new AutoTotaalDienst();
		atd.setLiterPrijs(lp);
		atd.setWerkUurPrijs(wup);
		atd.setMaandPrijs(mp);
		atd.setWeekPrijs(wp);
		atd.setDagPrijs(dp);
		aDao.saveAutoTotaalDienst(atd);
		fail("kan niet controleren op meerdere autototaaldiensten en de gegevens daarvan");
	}
	
	@Test
	public void deleteAutoTotaalDienst() throws SQLException{
		AutoTotaalDienst atd = aDao.getATD();
		assertEquals(10, atd.getLiterPrijs(),0);
		assertEquals(12, atd.getWerkUurPrijs(),0);
		assertEquals(2, atd.getMaandPrijs(),0);
		assertEquals(1, atd.getWeekPrijs(),0);
		assertEquals(23, atd.getDagPrijs(),0);
		aDao.deleteAutoTotaalDienst(1);
		assertNotEquals(atd, aDao.getATD());
		fail("geen check op wanneer de arraylist binnen getATD geen objecten heeft");
	}
}