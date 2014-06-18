package OnderdelenTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;

public class AutoTest {
	
	@Test
	public void testKenteken(){ 
		Gebruiker g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		Auto a1 = new Auto("13-37-JT", "Opel", 1991, "Astra", g1, "Gas");
		assertEquals("13-37-JT", a1.getKenteken());
	}
	
	@Test
	public void testMerk(){ 
		Gebruiker g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		Auto a1 = new Auto("11-JJ-AT", "Opel", 1991, "Astra", g1, "Gas");
		assertEquals("Opel", a1.getMerk());
	}
	
	@Test
	public void testBouwjaar(){ 
		Gebruiker g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		Auto a1 = new Auto("11-JJ-AT", "Opel", 1991, "Astra", g1, "Gas");
		assertEquals(1991, a1.getBouwjaar());
	}

	@Test
	public void testType(){ 
		Gebruiker g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		Auto a1 = new Auto("11-JJ-AT", "Opel", 1991, "Astra", g1, "Gas");
		assertEquals("Astra", a1.getType());
	}
	
	@Test
	public void testEigenaar(){ 
		Gebruiker g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		Auto a1 = new Auto("11-JJ-AT", "Opel", 1991, "Astra", g1, "Gas");
		assertEquals(g1, a1.getEigenaar());
	}
	
	@Test
	public void testBrandstoftype(){ 
		Gebruiker g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		Auto a1 = new Auto("11-JJ-AT", "Opel", 1991, "Astra", g1, "Gas");
		assertEquals("Gas", a1.getBrandstoftype());
	}
	
}
