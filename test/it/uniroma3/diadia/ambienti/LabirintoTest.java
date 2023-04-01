package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		labirinto = new Labirinto();
	}

	@Test
	public void testGetStanzaIniziale() {
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaFinale() {
		assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
	}


}
