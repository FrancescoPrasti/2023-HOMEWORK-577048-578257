package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {

	private Giocatore giocatore;
	
	@BeforeEach
	public void setUp() {
		giocatore = new Giocatore();
	}

	@Test
	public void testGetCFU() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		giocatore.setCfu(5);
		assertEquals(5, giocatore.getCfu());
	}

}
