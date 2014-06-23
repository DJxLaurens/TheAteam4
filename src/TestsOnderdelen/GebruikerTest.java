package TestsOnderdelen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;

public class GebruikerTest {
	Gebruiker g1 = new Gebruiker();
	
	@Before
	public void setUp(){
		g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "8765432153", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);	
	}
	@Test
	public void testGebruikerID(){ 
		assertEquals(5, g1.getGebruikerID());
	}
	
	@Test
	public void testRolID(){ 
		assertEquals(4, g1.getRol());
	}
	
	@Test
	public void testNaam(){ 
		assertEquals("Lionel", g1.getNaam());
	}
	
	@Test
	public void testWachtwoord(){ 
		assertEquals("Messi", g1.getWachtwoord());
	}
	
	@Test
	public void testAdres(){ 
		assertEquals("Kalverenstraat 10", g1.getAdres());
	}
	
	@Test
	public void testPostcode(){ 
		assertEquals("1234AB", g1.getPostcode());
	}
	
	@Test
	public void testTelefoonnummer(){ 
		assertEquals("8765432153", g1.getTelefoonnummer());
	}
	
	@Test
	public void testEmail(){ 
		assertEquals("lionel@lolmail.com", g1.getEmailadres());
	}
	
	@Test
	public void testLaatstGeweest(){ 
		assertEquals("11-02-2012", g1.getLaatstgeweest());
	}
	
	@Test
	public void testKorting(){ 
		assertEquals(10, g1.getKorting(), 0);
	}
	
	@Test
	public void testOpenFactuur(){ 
		assertEquals("01-01-2011", g1.getOpenFactuur());
	}
	
	@Test
	public void testBlokkade(){ 
		assertFalse(g1.getBlokkade());
	}
}