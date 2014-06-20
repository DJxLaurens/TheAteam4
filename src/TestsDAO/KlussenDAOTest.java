package TestsDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.KlussenDAO;

public class KlussenDAOTest {
	KlussenDAO kDao = new KlussenDAO();
	
	@Before
	public void setUp(){
		try {
			kDao.leesDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAlleKlussenDB(){
		kDao.getAlleKlussenDB();
		assertEquals(null, kDao.getAlleKlussenDB());
	}
	
	@Test
	public void saveKlus(){
		
	}
}