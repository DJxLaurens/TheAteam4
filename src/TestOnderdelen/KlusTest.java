package TestOnderdelen;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import Onderdelen.Klus;

public class KlusTest {
	Klus k = new Klus();

	public String getToday() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	@Before
	public void setUp() {
		k = new Klus(1, "voorbeeldklus", "niks", 1, 1);
	}

	@Test
	public void testKlusnummer() {
		assertEquals(1, k.getKlusNummer());
	}
	@Test
	public void testKlusnaam() {
		assertEquals("voorbeeldklus", k.getKlusNaam());
	}
	

}
