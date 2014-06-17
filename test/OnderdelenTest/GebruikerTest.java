package OnderdelenTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;

public class GebruikerTest {
	
	@Test
	public void testGebruikerID(){ 
		Gebruiker g1 = new Gebruiker(0, 0, "Lionel", "Messi", "Kalverenstraat 10", "1234AB", null, null, null, null, 0, null, 0);
		assertEquals("13-37-JT", g1.getGebruikerID());
	}
}