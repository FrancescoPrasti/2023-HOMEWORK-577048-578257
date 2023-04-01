package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BorsaTest {

	private Borsa borsa;
	private Attrezzo martello;
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa();
		martello = new Attrezzo("martello", 5);
		borsa.addAttrezzo(martello);
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(new Borsa().isEmpty());
	}
	
	@Test
	public void testIsEmptyBorsaNonVuota() {
		assertFalse(borsa.isEmpty());
	}
	
	@Test
	public void getAttrezzoSeStaNellaBorsa() {
		assertEquals(martello, borsa.getAttrezzo("martello"));
	}
	
	@Test
	public void getAttrezzoSeNonNellaBorsa() {
		assertNull(borsa.getAttrezzo("chiave"));
	}
	
	@Test
	public void getAttrezzoBorsaVuota() {
		assertNull(new Borsa().getAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoSeAttrezzoCercatoStaNellaBorsa() {
		assertEquals(martello, borsa.removeAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoSeAttrezzoCercatoNonStaNellaBorsa() {
		assertNull(borsa.removeAttrezzo("chiave"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertNull(new Borsa().removeAttrezzo("chiave"));
	}
	
	@Test
	public void testGetPesoCon1Attrezzo() {
		assertEquals(5, borsa.getPeso());
	}
	
	@Test
	public void testGetPesoCon2Attrezzi() {
		borsa.addAttrezzo(new Attrezzo("chiave", 2));
		assertEquals(7, borsa.getPeso());
	}
	
	@Test
	public void testGetPesoConBorsaVuota() {
		assertEquals(0, new Borsa().getPeso());
	}
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	@Test
	public void testHasAttrezzoNonContenutoNellaBorsa() {
		assertFalse(borsa.hasAttrezzo("chiave"));
	}
	
	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(new Borsa().hasAttrezzo("martello"));
	}

}
