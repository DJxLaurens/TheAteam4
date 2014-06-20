package TestsOnderdelen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;

public class AutoTest {
	Gebruiker g1 = new Gebruiker();
	Auto a1 = new Auto(0);
	

	@Before
	public void setUp(){
		g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		a1 = new Auto("11-JJ-AT", "Opel", 1991, "Astra", g1, "Gas");		
	}
	@Test
	public void testKenteken(){ 		
		assertEquals("11-JJ-AT", a1.getKenteken());
		System.out.println(a1.getAutoID());
	}
	
	@Test
	public void testMerk(){ 
		assertEquals("Opel", a1.getMerk());
	}
	
	@Test
	public void testBouwjaar(){ 
		assertEquals(1991, a1.getBouwjaar());
	}

	@Test
	public void testType(){ 
		assertEquals("Astra", a1.getType());
	}
	
	@Test
	public void testEigenaar(){ 
		assertEquals(g1, a1.getEigenaar());
	}
	
	@Test
	public void testBrandstoftype(){ 
		assertEquals("Gas", a1.getBrandstoftype());
	}
	
}
