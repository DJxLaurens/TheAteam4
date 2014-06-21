package TestsOnderdelen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;
import Onderdelen.Product;

public class ProductTest {
	
	Product p1 = new Product();
	
	@Before
	public void setUp(){
		p1 = new Product(4, "Uitlaat", 3, 50, 10, 5);
	}
	
	@Test
	public void testProductID(){ 		
		assertEquals(4, p1.getProductID());
	}
	
	@Test
	public void testProductNaam(){ 
		assertEquals("Uitlaat", p1.getProductNaam());
	}
	
	@Test
	public void testType(){ 
		assertEquals(3, p1.getType());
	}
	
	@Test
	public void testMinVoorraad(){ 
		assertEquals(50, p1.getMinVoorraad());
	}
	
	@Test
	public void testVoorraad(){ 
		assertEquals(10, p1.getVoorraad());
	}
	
	@Test
	public void testInBestelling(){ 
		assertEquals(5, p1.getInBestelling());
	}
	
	@Test
	public void testProductNummer(){ 
		p1.setProductNummer(10);
		assertEquals(10, p1.getProductNummer());
	}
	
	@Test
	public void testProductPrijs(){ 
		p1.setProductPrijs(20);
		assertEquals(20, p1.getProductPrijs(), 0);
	}
	
}