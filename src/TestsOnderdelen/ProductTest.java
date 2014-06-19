package TestsOnderdelen;

import static org.junit.Assert.*;

import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;
import Onderdelen.Product;

public class ProductTest {
	
	@Test
	public void testProductID(){ 
		Product p1 = new Product(4, "Uitlaat", 3, 50, 10, 5);
		assertEquals(4, p1.getProductID());
	}
	
	@Test
	public void testProductNaam(){ 
		Product p1 = new Product(4, "Uitlaat", 3, 50, 10, 5);
		assertEquals("Uitlaat", p1.getProductNaam());
	}
	
	@Test
	public void testType(){ 
		Product p1 = new Product(4, "Uitlaat", 3, 50, 10, 5);
		assertEquals(3, p1.getType());
	}
	
	@Test
	public void testMinVoorraad(){ 
		Product p1 = new Product(4, "Uitlaat", 3, 50, 10, 5);
		assertEquals(50, p1.getMinVoorraad());
	}
	
	@Test
	public void testVoorraad(){ 
		Product p1 = new Product(4, "Uitlaat", 3, 50, 10, 5);
		assertEquals(10, p1.getVoorraad());
	}
	
	@Test
	public void testInBestelling(){ 
		Product p1 = new Product(4, "Uitlaat", 3, 50, 10, 5);
		assertEquals(5, p1.getInBestelling());
	}
	
	@Test
	public void testProductNummer(){ 
		Product p1 = new Product();
		p1.setProductNummer(10);
		assertEquals(10, p1.getProductNummer());
	}
	
	@Test
	public void testProductPrijs(){ 
		Product p1 = new Product();
		p1.setProductPrijs(20);
		assertEquals(20, p1.getProductPrijs(), 0);
	}
	
}