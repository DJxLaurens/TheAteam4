package OnderdelenTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;

public class GebruikerTest {
	
	@Test
	public void testGebruikerID(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals(5, g1.getGebruikerID());
	}
	
	@Test
	public void testRolID(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals(4, g1.getRol());
	}
	
	@Test
	public void testNaam(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("Lionel", g1.getNaam());
	}
	
	@Test
	public void testWachtwoord(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("Messi", g1.getWachtwoord());
	}
	
	@Test
	public void testAdres(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("Kalverenstraat 10", g1.getAdres());
	}
	
	@Test
	public void testPostcode(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("1234AB", g1.getPostcode());
	}
	
	@Test
	public void testTelefoonnummer(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("87654321", g1.getTelefoonnummer());
	}
	
	@Test
	public void testEmail(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("lionel@lolmail.com", g1.getEmailadres());
	}
	
	@Test
	public void testLaatstGeweest(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("11-02-2012", g1.getLaatstgeweest());
	}
	
	@Test
	public void testKorting(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals(10, g1.getKorting(), 0);
	}
	
	@Test
	public void testOpenFactuur(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 1);
		assertEquals("01-01-2011", g1.getOpenFactuur());
	}
	
	@Test
	public void testBlokkade(){ 
		Gebruiker g1 = new Gebruiker(5, 4, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", "Kalverenstraat 10", "87654321", "lionel@lolmail.com", "11-02-2012", 10, "01-01-2011", 0);
		assertFalse(g1.getBlokkade());
	}
}