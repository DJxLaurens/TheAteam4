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
		assertEquals(10, pDao.getAlleOnderdelenDB().get(0).getMinVoorraad());
		assertEquals(25, pDao.getAlleOnderdelenDB().get(0).getVoorraad());
		assertEquals(10, pDao.getAlleOnderdelenDB().get(0).getInBestelling());
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
	public void setOnderdelenDB(){
//		methode is nog niet uitgeschreven
//		fail("methode is niet uitgeschreven");
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
	public void setBrandstoffenDB(){
//		methode is nog niet uitgeschreven
//		fail("methode is niet uitgeschreven");
	}
	
	@Test
	public void getOnderdeelFromID(){
		assertEquals(pDao.getAlleOnderdelenDB().get(0), pDao.getOnderdeelFromID(1));
	}
	
	@Test
	public void saveVoorraad(){
		Product p = new Product(0, "Wieldop", 2, 50, 30, 25);
		try {
			pDao.saveVoorraad(p.getProductNaam(), p.getType(), p.getMinVoorraad(), p.getVoorraad());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(p, pDao.getAlleOnderdelenDB().get(5));
	}
	
	@Test
	public void changeVoorraad(){
		
	}
	
	@Test
	public void vrdInBestelling(){
		
	}
	
	@Test
	public void changeMinVoorraad(){
		try {
			pDao.changeMinVoorraad(5, 20);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(20,pDao.getAlleOnderdelenDB().get(3).getMinVoorraad());
	}
	
	@Test
	public void deleteVoorraad(){
////		vrdID is hoogste product ID in database
//		int vrdID = 6;
//		try {
//			pDao.deleteVoorraad(vrdID);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		int aantProducten = pDao.getAlleBrandstoffenDB().size()+pDao.getAlleOnderdelenDB().size();
//		assertEquals((vrdID-1), aantProducten);	
	}
}