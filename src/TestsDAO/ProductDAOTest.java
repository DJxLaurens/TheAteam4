package TestsDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.ProductDAO;
import Onderdelen.Product;

public class ProductDAOTest {
	ProductDAO pDao = new ProductDAO();
	
	@Before
	public void setUp(){
		try {
			pDao.leesDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAlleOnderdelenDB(){
		assertEquals(1, pDao.getAlleOnderdelenDB().get(0).getProductID());
		assertEquals("Buisje", pDao.getAlleOnderdelenDB().get(0).getProductNaam());
		assertEquals(2, pDao.getAlleOnderdelenDB().get(0).getType());
		assertEquals(11, pDao.getAlleOnderdelenDB().get(0).getMinVoorraad());
		assertEquals(45, pDao.getAlleOnderdelenDB().get(0).getVoorraad());
		assertEquals(0, pDao.getAlleOnderdelenDB().get(0).getInBestelling());
	}
	
	@Test
	public void getSizeOnderdelen(){
		assertEquals(pDao.getAlleOnderdelenDB().size(), pDao.getSizeOnderdelen());
	}
	
	@Test
	public void getVoorraadById(){
		assertEquals(pDao.getAlleOnderdelenDB().get(0).getVoorraad(), pDao.getVoorraadById(1));
	}
	
	@Test
	public void getAlleBrandstoffenDB(){
		assertEquals(2, pDao.getAlleBrandstoffenDB().get(0).getProductID());
		assertEquals("Euro 95 ongelood", pDao.getAlleBrandstoffenDB().get(0).getProductNaam());
		assertEquals(1, pDao.getAlleBrandstoffenDB().get(0).getType());
		assertEquals(100, pDao.getAlleBrandstoffenDB().get(0).getMinVoorraad());
		assertEquals(222, pDao.getAlleBrandstoffenDB().get(0).getVoorraad());
		assertEquals(0, pDao.getAlleBrandstoffenDB().get(0).getInBestelling());		
	}
	
	@Test
	public void getOnderdeelFromID(){
		assertEquals(pDao.getAlleOnderdelenDB().get(0).toString(), pDao.getOnderdeelFromID(1).toString());
	}
	
	@Test
	public void saveVoorraad(){
		Product p = new Product(0, "Wieldop", 2, 50, 30, 25);
		try {
			pDao.saveVoorraad(p.getProductNaam(), p.getType(), p.getMinVoorraad(), p.getVoorraad());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(p.toString(),pDao.getAlleOnderdelenDB().get(5).toString());
	}
	
	@Test
	public void changeVoorraad() throws SQLException{
		assertEquals(45, pDao.getOnderdeelFromID(1).getVoorraad());
		pDao.changeVoorraad(1, 5, 45);
		assertEquals(50, pDao.getOnderdeelFromID(1).getVoorraad());
	}
	
	@Test
	public void vrdInBestelling(){
		
	}
	
	@Test
	public void changeMinVoorraad(){
		try {
			pDao.changeMinVoorraad(4, 20);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(20,pDao.getAlleOnderdelenDB().get(3).getMinVoorraad());
	}
	
	@Test
	public void deleteVoorraad(){
//		vrdID is hoogste product ID in database
		int vrdID = 8;
		try {
			pDao.deleteVoorraad(vrdID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int aantProducten = pDao.getAlleBrandstoffenDB().size()+pDao.getAlleOnderdelenDB().size();
		assertEquals((vrdID-1), aantProducten);	
	}
}