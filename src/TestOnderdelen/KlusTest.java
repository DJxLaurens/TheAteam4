package TestOnderdelen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;
import Onderdelen.Klus;
import Onderdelen.Monteur;

public class KlusTest {
	Klus k = new Klus();
	Auto a1 = new Auto(0);
	Gebruiker g1 = new Gebruiker();
	Monteur m = new Monteur(null);

	@Before
	public void setUp() {
		k = new Klus(1, "voorbeeldklus", "niks", 1, 1);
		g1 = new Gebruiker(0, 0, null, null, null, null, null, null, null, null, 0, null, 0);
		a1 = new Auto("11-JJ-AT", "Opel", 1991, "Astra", g1, "Gas");
		m = new Monteur("Henk Paladijn");
	}

	@Test
	public void testKlusnummer() {
		assertEquals(1, k.getKlusNummer());
	}

	@Test
	public void testKlusnaam() {
		assertEquals("voorbeeldklus", k.getKlusNaam());
	}

	@Test
	public void testVoegAutoToe() {
		assertTrue(k.voegAutoToe(a1));
	}

	@Test
	public void testZoekAuto() {
		k.voegAutoToe(a1);
		assertEquals(a1, k.zoekAuto(a1.getKenteken()));
	}

	@Test
	public void testHeeftAuto() {
		k.voegAutoToe(a1);
		assertTrue(k.heeftAuto(a1.getKenteken()));
	}

	@Test
	public void testHeeftMonteur() {
		k.voegMonteurToe(m);
		assertTrue(k.heeftMonteur(m.getNaam()));
	}

	@Test
	public void testVoegMonteurToe() {
		assertTrue(k.voegMonteurToe(m));
	}

	@Test
	public void testVoegDatumToe() {
		assertTrue(k.voegDatumToe(k.getToday()));
	}

	@Test
	public void testAlleDataArray() {
		assertNotNull(k.getAlleData());
	}

	@Test
	public void testAlleMonteursArray() {
		assertNotNull(k.getAlleMonteurs());
	}
}
