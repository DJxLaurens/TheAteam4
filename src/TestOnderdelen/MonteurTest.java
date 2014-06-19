package TestOnderdelen;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import Onderdelen.Monteur;

public class MonteurTest {
	Monteur m = new Monteur(null);
	
	@Before
	public void setUp(){
		m =  new Monteur("Henk Paladijn");
	}
	@Test
	public void testKenteken(){ 		
		assertEquals("Henk Paladijn", m.getNaam());
	}	
}

